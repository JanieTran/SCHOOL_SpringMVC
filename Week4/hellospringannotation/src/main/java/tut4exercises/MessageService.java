package tut4exercises;

import org.springframework.context.annotation.Scope;

@Scope(scopeName = "singleton")
public interface MessageService {
    void send();
}
