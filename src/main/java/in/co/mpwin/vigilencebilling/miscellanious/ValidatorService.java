package in.co.mpwin.vigilencebilling.miscellanious;

import org.springframework.stereotype.Service;

@Service
public class ValidatorService {
    public String removeSpaceFromString(String data)
    {
        return data.replace(" ","");
    }


}
