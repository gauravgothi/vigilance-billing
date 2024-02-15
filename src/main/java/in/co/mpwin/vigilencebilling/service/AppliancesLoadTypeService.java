package in.co.mpwin.vigilencebilling.service;

import in.co.mpwin.vigilencebilling.bean.AppliancesLoadTypeBean;
import in.co.mpwin.vigilencebilling.interfaces.AppliancesLoadTypeInterface;
import in.co.mpwin.vigilencebilling.repo.AppliancesLoadTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppliancesLoadTypeService implements AppliancesLoadTypeInterface {
    @Autowired private AppliancesLoadTypeRepo appliancesLoadTypeRepo;

    @Override
    public List<AppliancesLoadTypeBean> getAllAppliancesLoadTypes() {
        return appliancesLoadTypeRepo.findAll();
    }

    @Override
    public AppliancesLoadTypeBean getAppliancesLoadTypeById(Long id) {
        return appliancesLoadTypeRepo.findById(id).orElse(null);
    }

    @Override
    public AppliancesLoadTypeBean saveOrUpdateAppliancesLoadType(AppliancesLoadTypeBean appliancesLoadType) {
        return appliancesLoadTypeRepo.save(appliancesLoadType);
    }

    @Override
    public void deleteAppliancesLoadType(Long id) {
        appliancesLoadTypeRepo.deleteById(id);
    }

    public AppliancesLoadTypeBean getAppliancesLoadTypeByApplianceNameAndTariffCode(String applianceName,String tariffCode){
        return appliancesLoadTypeRepo.findByApplianceNameAndTariffCode(applianceName,tariffCode);

    }
}
