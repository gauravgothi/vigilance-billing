package in.co.mpwin.vigilencebilling.service;

import in.co.mpwin.vigilencebilling.bean.AppliancesLoadBean;
import in.co.mpwin.vigilencebilling.interfaces.AppliancesLoadInterface;
import in.co.mpwin.vigilencebilling.repo.AppliancesLoadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppliancesLoadService implements AppliancesLoadInterface {

    @Autowired private AppliancesLoadRepo appliancesLoadRepo;
    @Override
    public List<AppliancesLoadBean> getApplianceLoadBeanByP4id(String p4id) {
        return appliancesLoadRepo.findByP4id(p4id);
    }
}
