package rmit;

import org.springframework.stereotype.Component;

@Component
public class AddService {
    public int add(int a, int b) {
        return a + b;
    }
}
