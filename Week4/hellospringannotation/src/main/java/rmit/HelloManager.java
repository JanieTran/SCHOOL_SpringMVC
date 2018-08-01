package rmit;

import org.springframework.context.annotation.Scope;

/**
 * Created by CoT on 10/12/17.
 */

// No @Component in interface
@Scope(scopeName = "singleton")
public interface HelloManager {
    void greet();
}
