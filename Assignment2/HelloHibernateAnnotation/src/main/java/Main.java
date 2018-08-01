
import clinic.config.AppConfig;
import clinic.entity.Lecturer;
import clinic.entity.School;
import clinic.service.PersonService;
import clinic.entity.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by CoT on 10/13/17.
 */
public class Main {
    public static void main(String[] args){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        PersonService personService = (PersonService) context.getBean("personService");

        Person person = new Person();
        person.setName("Hien");

        personService.savePerson(person);

        // Create entity named Lecturer: id, name
        Lecturer lecturer = new Lecturer();
        lecturer.setName("Thanh");

        // Entity Relation
        School sst = new School();
        sst.setName("SST");
//        personService.saveSchool(sst);

        lecturer.setSchool(sst);
        personService.saveLecturer(lecturer);


    }
}
