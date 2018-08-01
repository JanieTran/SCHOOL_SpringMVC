package rmit;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("ChineseHello")
public class ChineseHello implements HelloManager {
    public void greet() {
        System.out.println("Ni hao");
    }
}
