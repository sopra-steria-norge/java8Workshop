import java.util.function.Function;

public class Car implements Debuggable {
    private String license;

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    @Override
    public Function traceFunction() {
        Function<Car, String> getLicenseFunc = Car::getLicense;
        return getLicenseFunc;
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.setLicense("DE 12345");
        car.debugit();
    }
}
