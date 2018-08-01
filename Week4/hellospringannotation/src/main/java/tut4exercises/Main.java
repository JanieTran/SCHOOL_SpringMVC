package tut4exercises;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        ChatApplication chatApplication = context.getBean(ChatApplication.class);

        chatApplication.getFacebookService().send();
        chatApplication.getHangoutService().send();
        chatApplication.getSmsService().send();
    }
}
