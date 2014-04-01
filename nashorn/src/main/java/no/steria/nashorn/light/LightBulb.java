package no.steria.nashorn.light;

public class LightBulb {

    private static LightBulb lightBulb;

    boolean isOn = false;

    public static LightBulb getInstance() {
        if (lightBulb == null) {
            lightBulb = new LightBulb();
        }
        return lightBulb;
    }

    public void turnOn() {
        isOn = true;
    }

    public boolean isOn() {
        return isOn;
    }
}
