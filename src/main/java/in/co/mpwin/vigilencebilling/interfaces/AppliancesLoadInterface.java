package in.co.mpwin.vigilencebilling.interfaces;

import in.co.mpwin.vigilencebilling.bean.AppliancesLoadBean;

import java.util.List;

public interface AppliancesLoadInterface {

    public List<AppliancesLoadBean> getApplianceLoadBeanByP4id(String p4id);
}
