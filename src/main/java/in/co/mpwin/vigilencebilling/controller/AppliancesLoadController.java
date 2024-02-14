package in.co.mpwin.vigilencebilling.controller;


import in.co.mpwin.vigilencebilling.interfaces.AppliancesLoadInterface;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appliances")
@CrossOrigin(origins="*")
public class AppliancesLoadController {


    @Autowired
    private AppliancesLoadInterface appliancesLoadInterface;

    @GetMapping("/list/p4id/{p4id}")
    public ResponseEntity<?> getAppliancesListByP4id(@PathVariable("p4id") String p4id)
    {
        return new ResponseEntity<>(appliancesLoadInterface.getApplianceLoadBeanByP4id(p4id), HttpStatus.OK);
    }
}
