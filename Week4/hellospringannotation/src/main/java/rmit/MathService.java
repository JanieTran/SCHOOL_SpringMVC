package rmit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MathService {
    @Autowired
    private AddService addService;
    @Autowired
    private MinusService minusService;

    public AddService getAddService() {
        return addService;
    }

    public void setAddService(AddService addService) {
        this.addService = addService;
    }

    public MinusService getMinusService() {
        return minusService;
    }

    public void setMinusService(MinusService minusService) {
        this.minusService = minusService;
    }
}
