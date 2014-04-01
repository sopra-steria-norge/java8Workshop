package no.steria.nashorn;

import no.steria.nashorn.light.LightBulb;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class SimpleNashornTest {

    @Test
    public void should_reply_when_Nashorn_calls() throws Exception {
        SimpleNashorn simpleNashorn = new SimpleNashorn();
        HelloNashorn helloNashorn = simpleNashorn.loadHelloNashorn();

        assertThat(helloNashorn.sayHello("Nashorn")).isEqualTo("Hello Nashorn");
    }

    @Test
    public void should_turn_on_lightbulb_using_nashorn() throws Exception {
        SimpleNashorn simpleNashorn = new SimpleNashorn();
        HelloNashorn helloNashorn = simpleNashorn.loadHelloNashorn();

        helloNashorn.turnOnLightBulb();

        assertThat(LightBulb.getInstance().isOn()).isTrue();
    }
}