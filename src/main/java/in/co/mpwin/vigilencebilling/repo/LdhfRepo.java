package in.co.mpwin.vigilencebilling.repo;

import in.co.mpwin.vigilencebilling.bean.LdhfBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LdhfRepo extends JpaRepository<LdhfBean,Long> {
}
