
import clinic.config.AppConfig;
import clinic.service.PersonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by CoT on 10/13/17.
 */
public class Main {
    public static void main(String[] args){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        PersonService personService = (PersonService) context.getBean("personService");

    }
}
