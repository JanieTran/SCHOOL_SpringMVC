package rmit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Communicator {
    @Autowired
    @Qualifier("ChineseHello")
    private HelloManager helloManager;
    @Autowired
    private ByeManager byeManager;

    public HelloManager getHelloManager() {
        return helloManager;
    }

    public void setHelloManager(HelloManager helloManager) {
        this.helloManager = helloManager;
    }

    public ByeManager getByeManager() {
        return byeManager;
    }

    public void setByeManager(ByeManager byeManager) {
        this.byeManager = byeManager;
    }
}
