import org.hibernate.validator.constraints.Length;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        /*ValidatorFactory factory= Validation.buildDefaultValidatorFactory();
//        Validator validator=factory.getValidator();
//        User user=new User();
//        Set<ConstraintViolation<User> > violations=validator.validate(user);
//        violations.forEach(violation -> {
//            String message = violation.getPropertyPath()
//                    + ": " + violation.getMessage();
//            System.out.println(message);
//        });*/

        ValidatorFactory factory= Validation.buildDefaultValidatorFactory();
        Validator validator=factory.getValidator();
        Transaction t=new Transaction();
        Set<ConstraintViolation<Transaction>> violations=validator.validate(t);
        violations.forEach(violation -> {
            String message = violation.getPropertyPath()
                    + ": " + violation.getMessage();
            System.out.println(message);
        });



    }
}

class Transaction{
    @Length(min = 0,max = 5,message = "String length incorrect")
    private String orderId="Vikram";

}

class User {

    @NotNull(message = "Name can't be null")
    private String name;

}


