package tut4exercises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("Chat Application")
public class ChatApplication {
    @Autowired
    @Qualifier("FacebookService")
    private MessageService facebookService;

    @Autowired
    @Qualifier("HangoutService")
    private MessageService hangoutService;

    @Autowired
    @Qualifier("SMSService")
    private MessageService smsService;

    public MessageService getFacebookService() {
        return facebookService;
    }

    public void setFacebookService(MessageService facebookService) {
        this.facebookService = facebookService;
    }

    public MessageService getHangoutService() {
        return hangoutService;
    }

    public void setHangoutService(MessageService hangoutService) {
        this.hangoutService = hangoutService;
    }

    public MessageService getSmsService() {
        return smsService;
    }

    public void setSmsService(MessageService smsService) {
        this.smsService = smsService;
    }
}
