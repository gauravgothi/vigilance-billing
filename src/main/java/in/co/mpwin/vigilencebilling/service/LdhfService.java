package in.co.mpwin.vigilencebilling.service;

import in.co.mpwin.vigilencebilling.bean.AppliancesLoadBean;
import in.co.mpwin.vigilencebilling.bean.AppliancesLoadTypeBean;
import in.co.mpwin.vigilencebilling.bean.LdhfBean;
import in.co.mpwin.vigilencebilling.dtos.LoadUnitDto;
import in.co.mpwin.vigilencebilling.interfaces.AppliancesLoadInterface;
import in.co.mpwin.vigilencebilling.interfaces.AppliancesLoadTypeInterface;
import in.co.mpwin.vigilencebilling.interfaces.LdhfInterface;
import in.co.mpwin.vigilencebilling.repo.LdhfRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LdhfService implements LdhfInterface {

    @Autowired private LdhfRepo ldhfRepo;

    @Autowired private AppliancesLoadInterface appliancesLoadInterface;
    @Autowired private AppliancesLoadTypeInterface appliancesLoadTypeInterface;

    @Override
    public List<LdhfBean> getLdhfBeans() {
        return ldhfRepo.findAll();
    }

    @Override
    public List<LoadUnitDto> getLoadUnitDtos(String p4id, String ivrs, String theftType
            , String tariff, String tariffCode, String isContinuous, String noOfShift){
        List<LoadUnitDto> loadUnitDtoList = new ArrayList<>();
        List<AppliancesLoadBean> appliancesLoadBeanList =
                appliancesLoadInterface.getApplianceLoadBeanByP4id(p4id);
        // Stream the list, map each Item to its fieldName, and collect them distinct into another list
        List<String> distinctTariff = appliancesLoadBeanList.stream()
                .map(AppliancesLoadBean::getTariff)
                .distinct()
                .collect(Collectors.toList());
        //for ()
        Double sumLightLoadInKw = 0.0d; Double sumPettyLoadInKw = 0.0d; Double sumSeasonalInKw = 0.0d;
        for (AppliancesLoadBean p4Bean : appliancesLoadBeanList) {
            String applianceName = p4Bean.getApplianceName();
            AppliancesLoadTypeBean appliancesLoadTypeBean =
                    appliancesLoadTypeInterface.getAppliancesLoadTypeByApplianceNameAndTariffCode(applianceName, tariffCode);
            String appliancesLoadType = appliancesLoadTypeBean.getLoadType();
            Double itemLoadInKw = 0.0;
            switch (p4Bean.getLoadUnit().toUpperCase()) {
                case "WATT":
                    itemLoadInKw = (p4Bean.getApplianceLoad() / 1000.0d) * p4Bean.getNoOfAppliance();
                    break;
                case "KW":
                    itemLoadInKw = p4Bean.getApplianceLoad() * p4Bean.getNoOfAppliance();
                    break;
                case "HP":
                    itemLoadInKw = (p4Bean.getApplianceLoad() * 0.746d) * p4Bean.getNoOfAppliance();
                    break;
                case "KVA":
                    itemLoadInKw = (p4Bean.getApplianceLoad()) * p4Bean.getNoOfAppliance(); //kW = kVA × PF thus PF required
                    break;
                default:
                    System.out.println("Selected Unit is unknown");
            }
            switch (appliancesLoadType.toUpperCase()) {
                case "LL":
                    sumLightLoadInKw = sumLightLoadInKw + itemLoadInKw;
                    break;
                case "PL":
                    sumPettyLoadInKw = sumPettyLoadInKw + itemLoadInKw;
                    break;
                case "SL":
                    sumSeasonalInKw = sumSeasonalInKw + itemLoadInKw;
                    break;
                default:
                    System.out.println("Selected Load Type is unknown");
            }
        }
            LoadUnitDto loadUnitDto = new LoadUnitDto();
            loadUnitDto.setP4id(p4id);
            loadUnitDto.setIvrs(ivrs);
            loadUnitDto.setTheftType(theftType.toUpperCase());
            loadUnitDto.setTariff(tariff.toUpperCase()); //here tariff like DL CL not LV1 and LV2
            loadUnitDto.setTariffCode(tariffCode.toUpperCase());
            loadUnitDto.setIsContinuous(isContinuous.toUpperCase());
            loadUnitDto.setNoOfShift(noOfShift);


            LdhfBean ldhfBeanOfLightLoad  =  ldhfRepo.findByTariffAndIsContinuousAndLoadTypeAndNoOfShift
                    (tariff,isContinuous,"LL",noOfShift);
            LdhfBean ldhfBeanOfSeasonalLoad  =  ldhfRepo.findByTariffAndIsContinuousAndLoadTypeAndNoOfShift
                    (tariff,isContinuous,"SL",noOfShift);
            LdhfBean ldhfBeanOfPettyLoad  =  ldhfRepo.findByTariffAndIsContinuousAndLoadTypeAndNoOfShift
                    (tariff,isContinuous,"PL",noOfShift);

            loadUnitDto.setTotalLightLoad(sumLightLoadInKw);
            loadUnitDto.setTotalPettyLoad(sumPettyLoadInKw);
            loadUnitDto.setTotalSeasonalLoad(sumSeasonalInKw);

            loadUnitDto.setTotalLightDays(ldhfBeanOfLightLoad.getDays());
            loadUnitDto.setTotalPettyDays(ldhfBeanOfPettyLoad.getDays());
            loadUnitDto.setTotalSeasonalDays(ldhfBeanOfSeasonalLoad.getDays());

            loadUnitDto.setTotalLightMonths(ldhfBeanOfLightLoad.getMonths());
            loadUnitDto.setTotalPettyMonths(ldhfBeanOfPettyLoad.getMonths());
            loadUnitDto.setTotalSeasonalMonths(ldhfBeanOfSeasonalLoad.getMonths());

            loadUnitDto.setTotalLightHours(ldhfBeanOfLightLoad.getHours());
            loadUnitDto.setTotalPettyHours(ldhfBeanOfPettyLoad.getHours());
            loadUnitDto.setTotalSeasonalHours(ldhfBeanOfSeasonalLoad.getHours());

            if (loadUnitDto.getTheftType().equalsIgnoreCase("DIRECT")){
                loadUnitDto.setLightFactor(ldhfBeanOfLightLoad.getFactorDirectTheft());
                loadUnitDto.setPettyFactor(ldhfBeanOfPettyLoad.getFactorDirectTheft());
                loadUnitDto.setSeasonalFactor(ldhfBeanOfSeasonalLoad.getFactorDirectTheft());
            } else if (!loadUnitDto.getTheftType().equalsIgnoreCase("DIRECT")) {
                loadUnitDto.setLightFactor(ldhfBeanOfLightLoad.getFactorOther());
                loadUnitDto.setPettyFactor(ldhfBeanOfPettyLoad.getFactorOther());
                loadUnitDto.setSeasonalFactor(ldhfBeanOfSeasonalLoad.getFactorOther());
            }

            loadUnitDto.setTotalLightUnits(loadUnitDto.getTotalLightLoad() *
                                            loadUnitDto.getTotalLightDays() *
                                            loadUnitDto.getTotalLightMonths() *
                                            loadUnitDto.getTotalLightHours() *
                                            loadUnitDto.getLightFactor());

            loadUnitDto.setTotalPettyUnits(loadUnitDto.getTotalPettyLoad() *
                    loadUnitDto.getTotalPettyDays() *
                    loadUnitDto.getTotalPettyMonths() *
                    loadUnitDto.getTotalPettyHours() *
                    loadUnitDto.getPettyFactor());

            loadUnitDto.setTotalSeasonalUnits(loadUnitDto.getTotalSeasonalLoad() *
                    loadUnitDto.getTotalSeasonalDays() *
                    loadUnitDto.getTotalSeasonalMonths() *
                    loadUnitDto.getTotalSeasonalHours() *
                    loadUnitDto.getSeasonalFactor());

            loadUnitDto.setAllLoadTotalUnits(Math.ceil(loadUnitDto.getTotalLightUnits() +
                    loadUnitDto.getTotalPettyUnits() + loadUnitDto.getTotalSeasonalUnits()
            ));

            loadUnitDtoList.add(loadUnitDto);

        return loadUnitDtoList;
    }
}
