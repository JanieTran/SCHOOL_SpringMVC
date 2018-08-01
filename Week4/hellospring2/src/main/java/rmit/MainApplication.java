package rmit;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by CoT on 10/12/17.
 */

public class MainApplication {
    public static void main(String[] args){
        // Create Bean factory - Bean factory inside the Application Context
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Hello hello = context.getBean(Hello.class);
        hello.say();

        Goodbye goodbye = context.getBean(Goodbye.class);
        goodbye.bye();

        Communicator communicator = context.getBean(Communicator.class);
        Hello cHello = communicator.getHello();
        Goodbye cGoodbye = communicator.getGoodbye();
        cHello.say();
        cGoodbye.bye();
    }
}
