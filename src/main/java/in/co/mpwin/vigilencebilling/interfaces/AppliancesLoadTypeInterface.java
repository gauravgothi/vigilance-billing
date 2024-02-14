package in.co.mpwin.vigilencebilling.interfaces;

import in.co.mpwin.vigilencebilling.bean.AppliancesLoadTypeBean;

import java.util.List;

public interface AppliancesLoadTypeInterface {
    List<AppliancesLoadTypeBean> getAllAppliancesLoadTypes();

    AppliancesLoadTypeBean getAppliancesLoadTypeById(Long id);

    AppliancesLoadTypeBean saveOrUpdateAppliancesLoadType(AppliancesLoadTypeBean appliancesLoadType);

    void deleteAppliancesLoadType(Long id);
}
