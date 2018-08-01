package tut4exercises;

import org.springframework.stereotype.Component;

@Component("SMSService")
public class SMSService implements MessageService {
    public void send() {
        System.out.println("SMS Service");
    }
}
