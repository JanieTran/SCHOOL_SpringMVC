package tut4exercises;

import org.springframework.stereotype.Component;

@Component("FacebookService")
public class FacebookService implements MessageService {
    public void send() {
        System.out.println("Facebook Service");
    }
}
