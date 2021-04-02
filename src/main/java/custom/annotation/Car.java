package custom.annotation;

import javax.validation.constraints.Size;

// Using the constraint
public class Car{
    @Size(min=6,max=14)
    @CheckCase(CaseMode.UPPER)
    private String lincensePlate;

    public Car(String lincensePlate) {
        this.lincensePlate = lincensePlate;
    }

    public String getLincensePlate() {
        return lincensePlate;
    }

    public void setLincensePlate(String lincensePlate) {
        this.lincensePlate = lincensePlate;
    }
}

