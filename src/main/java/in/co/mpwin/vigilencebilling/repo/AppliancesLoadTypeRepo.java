package in.co.mpwin.vigilencebilling.repo;

import in.co.mpwin.vigilencebilling.bean.AppliancesLoadTypeBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppliancesLoadTypeRepo extends JpaRepository<AppliancesLoadTypeBean,Long> {
    AppliancesLoadTypeBean findByApplianceNameAndTariffCode(String applianceName, String tariffCode);
}
