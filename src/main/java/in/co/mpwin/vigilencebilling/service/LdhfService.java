package in.co.mpwin.vigilencebilling.service;

import in.co.mpwin.vigilencebilling.bean.LdhfBean;
import in.co.mpwin.vigilencebilling.dtos.LoadUnitDto;
import in.co.mpwin.vigilencebilling.interfaces.LdhfInterface;
import in.co.mpwin.vigilencebilling.repo.LdhfRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LdhfService implements LdhfInterface {

    @Autowired private LdhfRepo ldhfRepo;

    @Override
    public List<LdhfBean> getLdhfBeans() {
        return ldhfRepo.findAll();
    }

    public List<LoadUnitDto> getLoadUnitDtos(String p4id,String ivrs,String theftType
            ,String tariff,String isContinuous,String noOfShift){
        List<LoadUnitDto> loadUnitDtoList = new ArrayList<>();

        return loadUnitDtoList;
    }
}
