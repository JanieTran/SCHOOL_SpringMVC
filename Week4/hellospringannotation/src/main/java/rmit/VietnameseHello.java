package rmit;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("VietnameseHello")
public class VietnameseHello implements HelloManager {
    public void greet() {
        System.out.println("Xin chao");
    }
}
