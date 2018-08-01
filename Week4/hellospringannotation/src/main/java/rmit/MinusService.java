package rmit;

import org.springframework.stereotype.Component;

@Component
public class MinusService {
    public int minus(int a, int b) {
        return a - b;
    }
}
