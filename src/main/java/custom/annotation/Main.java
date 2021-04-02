package custom.annotation;
//Custom annotation to validate that a given String may either be uppercase or lowercase
//https://docs.jboss.org/hibernate/validator/4.1/reference/en-US/html/validator-customconstraints.html
// Refer to above links for doubts

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Car car=new Car("i10");
        ValidatorFactory factory= Validation.buildDefaultValidatorFactory();
        Validator validator=factory.getValidator();
        Set<ConstraintViolation<Car>> violationSet=validator.validate(car);
        violationSet.forEach(violation->{
            System.out.println(violation.getMessage());
        });
    }
}
