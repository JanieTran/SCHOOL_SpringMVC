package rmit;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class ByeManager {
    public void bye() {
        System.out.println("Bye Manager");
    }
}
