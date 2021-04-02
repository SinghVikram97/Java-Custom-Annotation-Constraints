package custom.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

// Constraint validator
public class CheckCaseValidator implements ConstraintValidator<CheckCase,String> {
    private CaseMode caseMode;

    @Override
    public void initialize(CheckCase constraintAnnotation) {
        this.caseMode=constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String object, ConstraintValidatorContext constraintValidatorContext) {
        if(object==null){
            // By default recommended null as true by bean validation
            // If null is not a valid value for an element it should be annotated with @NotNull explicitly
            return true;
        }

//        if(caseMode==CaseMode.UPPER){
//            return object.equals(object.toUpperCase());
//        }
//
//        else{
//            return object.equals(object.toLowerCase());
//        }

        // Add custom message
        boolean isValid;

        if(caseMode==CaseMode.UPPER){
            isValid=object.equals(object.toUpperCase());
        }

        else{
            isValid=object.equals(object.toLowerCase());
        }

        if(!isValid){
            // Supress default message
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("Please send me an uppercase license plate").addConstraintViolation();
        }

        return isValid;
    }
}