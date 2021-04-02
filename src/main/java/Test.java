import javax.validation.*;
import java.util.Set;

public class Test{
    public static void main(String[] args) {
        Person p=new Person(16);
        ValidatorFactory factory=Validation.buildDefaultValidatorFactory();
        Validator validator=factory.getValidator();
        Set<ConstraintViolation<Person>> violations=validator.validate(p);
        violations.forEach((violation->{
            System.out.println(violation.getMessage());
        }));
        System.out.println(p.age);
    }
}