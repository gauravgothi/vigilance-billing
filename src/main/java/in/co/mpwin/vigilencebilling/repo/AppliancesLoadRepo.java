package in.co.mpwin.vigilencebilling.repo;

import in.co.mpwin.vigilencebilling.bean.AppliancesLoadBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppliancesLoadRepo extends JpaRepository<AppliancesLoadBean,Long> {

    @Query(value="select * from vigilance.appliances_load where p4id=:p4id",nativeQuery = true)
    List<AppliancesLoadBean> findByP4id(@Param("p4id") String p4id);
}
