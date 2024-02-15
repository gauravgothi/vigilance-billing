package in.co.mpwin.vigilencebilling.repo;

import in.co.mpwin.vigilencebilling.bean.LdhfBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LdhfRepo extends JpaRepository<LdhfBean,Long> {
    LdhfBean findByTariffAndIsContinuousAndLoadTypeAndNoOfShift(String tariff, String isContinuous,String loadType, String noOfShift);
}
