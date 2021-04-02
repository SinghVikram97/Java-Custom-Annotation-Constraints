import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer> {
    protected Integer minAge;

    @Override
    public void initialize(Age age) {
        this.minAge=age.value();
    }

    @Override
    public boolean isValid(Integer age, ConstraintValidatorContext constraintValidatorContext) {
        // null values are valid
        if ( age == null ) {
            return true;
        }
        return age>minAge;
    }
}