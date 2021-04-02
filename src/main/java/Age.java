import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE,ElementType.CONSTRUCTOR,ElementType.PARAMETER,ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {AgeValidator.class})
public @interface Age{
    String message() default "Must be greater than {value}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
    int value();
}