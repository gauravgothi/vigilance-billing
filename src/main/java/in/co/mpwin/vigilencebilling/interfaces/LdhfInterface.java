package in.co.mpwin.vigilencebilling.interfaces;

import in.co.mpwin.vigilencebilling.bean.LdhfBean;
import in.co.mpwin.vigilencebilling.dtos.LoadUnitDto;

import java.util.List;

public interface LdhfInterface{

public List<LdhfBean> getLdhfBeans();

    List<LoadUnitDto> getLoadUnitDtos(String p4id, String ivrs, String theftType
            , String tariff,String tariffCode, String isContinuous, String noOfShift);
}
