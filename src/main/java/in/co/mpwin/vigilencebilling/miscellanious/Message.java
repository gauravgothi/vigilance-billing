package in.co.mpwin.vigilencebilling.miscellanious;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Message {

    private String message;

    public Message() {
    }

    public Message(String message) {
        this.message = message;
    }


}
