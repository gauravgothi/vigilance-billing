package in.co.mpwin.vigilencebilling.controller;

import in.co.mpwin.vigilencebilling.bean.LdhfBean;
import in.co.mpwin.vigilencebilling.dtos.LoadUnitDto;
import in.co.mpwin.vigilencebilling.interfaces.LdhfInterface;
import in.co.mpwin.vigilencebilling.miscellanious.ApiException;
import in.co.mpwin.vigilencebilling.miscellanious.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ldhf")
@CrossOrigin(origins="*")
public class LdhfController {
        @Autowired private LdhfInterface ldhfInterface;

        @GetMapping("")
        public ResponseEntity<?> getLdhfBeans(){
            ResponseEntity respLdhfBeans =null;
            List<LdhfBean> ldhfBeanList=new ArrayList<>();
            try{
                ldhfBeanList = ldhfInterface.getLdhfBeans();
                respLdhfBeans=new ResponseEntity(ldhfBeanList, HttpStatus.OK);
            }catch (ApiException apiException) {
                respLdhfBeans = new ResponseEntity<>(new Message(apiException.getMessage()), apiException.getHttpStatus());

            } catch (Exception e) {
                respLdhfBeans = new ResponseEntity<>(new Message(e.getMessage()), HttpStatus.BAD_REQUEST);

            }
            return  respLdhfBeans;

        }
    @GetMapping("/total-unit")
    public ResponseEntity<?> getTotalUnits(){
        ResponseEntity respLdhfBeans =null;
        List<LoadUnitDto> loadUnitDtoList=new ArrayList<>();
        try{
            loadUnitDtoList = ldhfInterface.getLoadUnitDtos("1123","","Direct","DL","LV1","NA","NA");
            respLdhfBeans=new ResponseEntity(loadUnitDtoList, HttpStatus.OK);
        }catch (ApiException apiException) {
            respLdhfBeans = new ResponseEntity<>(new Message(apiException.getMessage()), apiException.getHttpStatus());

        } catch (Exception e) {
            respLdhfBeans = new ResponseEntity<>(new Message(e.getMessage()), HttpStatus.BAD_REQUEST);

        }
        return  respLdhfBeans;

    }
}
