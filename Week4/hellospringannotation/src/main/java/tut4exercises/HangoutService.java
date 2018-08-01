package tut4exercises;

import org.springframework.stereotype.Component;

@Component("HangoutService")
public class HangoutService implements MessageService {
    public void send() {
        System.out.println("Hangout Service");
    }
}
