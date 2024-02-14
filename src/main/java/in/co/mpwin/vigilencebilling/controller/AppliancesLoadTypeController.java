package in.co.mpwin.vigilencebilling.controller;

import in.co.mpwin.vigilencebilling.bean.AppliancesLoadTypeBean;
import in.co.mpwin.vigilencebilling.interfaces.AppliancesLoadTypeInterface;
import in.co.mpwin.vigilencebilling.service.AppliancesLoadTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appliance-load-type")
@CrossOrigin(origins="*")
public class AppliancesLoadTypeController {
    @Autowired private AppliancesLoadTypeInterface appliancesLoadTypeInterface;


    @GetMapping
    public ResponseEntity<List<AppliancesLoadTypeBean>> getAllAppliancesLoadTypes() {
        List<AppliancesLoadTypeBean> appliancesLoadTypes = appliancesLoadTypeInterface.getAllAppliancesLoadTypes();
        return new ResponseEntity<>(appliancesLoadTypes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppliancesLoadTypeBean> getAppliancesLoadTypeById(@PathVariable("id") Long id) {
        AppliancesLoadTypeBean appliancesLoadType = appliancesLoadTypeInterface.getAppliancesLoadTypeById(id);
        if (appliancesLoadType != null) {
            return new ResponseEntity<>(appliancesLoadType, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<AppliancesLoadTypeBean> createAppliancesLoadType(@RequestBody AppliancesLoadTypeBean appliancesLoadType) {
        AppliancesLoadTypeBean createdAppliancesLoadType = appliancesLoadTypeInterface.saveOrUpdateAppliancesLoadType(appliancesLoadType);
        return new ResponseEntity<>(createdAppliancesLoadType, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppliancesLoadTypeBean> updateAppliancesLoadType(@PathVariable("id") Long id, @RequestBody AppliancesLoadTypeBean appliancesLoadType) {
        appliancesLoadType.setId(id); // Ensure the ID in the path matches the object
        AppliancesLoadTypeBean updatedAppliancesLoadType = appliancesLoadTypeInterface.saveOrUpdateAppliancesLoadType(appliancesLoadType);
        return new ResponseEntity<>(updatedAppliancesLoadType, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppliancesLoadType(@PathVariable("id") Long id) {
        appliancesLoadTypeInterface.deleteAppliancesLoadType(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
