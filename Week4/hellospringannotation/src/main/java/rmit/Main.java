package rmit;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by CoT on 10/12/17.
 */

public class Main {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.register(rmit.AppConfig.class);
        context.register(AppConfigComponentScan.class);
        context.refresh();

//        // The same as with xml
//        HelloManager helloManager = context.getBean(HelloManager.class);
//        helloManager.greet();
//
//        ByeManager byeManager = context.getBean(ByeManager.class);
//        byeManager.bye();

        // Dependency injection
        Communicator communicator = context.getBean(Communicator.class);
//        communicator.getHelloManager().greet();
//        communicator.getByeManager().bye();
//
//        // MathManager has 2 proterties:
//        // - rmit.AddService: add(1,2)
//        // - rmit.MinusService: minus(1,2)
//        // Define beans for classes
//        MathService mathService = context.getBean(MathService.class);
//        int add = mathService.getAddService().add(1,2);
//        int minus = mathService.getMinusService().minus(1,2);
//        System.out.println(add + ", " + minus);
//
//        // When having interface + implement, @Component in implement only
//        ChineseHello chineseHello = context.getBean(ChineseHello.class);
//        chineseHello.greet();

        // @Component("qualifier") in implement class
        // @Qualifier("qualifier") in @Autowired
        communicator.getHelloManager().greet();
    }
}
