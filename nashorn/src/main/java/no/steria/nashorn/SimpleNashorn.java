package no.steria.nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SimpleNashorn {

    public HelloNashorn loadHelloNashorn() throws ScriptException {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("nashorn");

        InputStream scriptFile = SimpleNashorn.class.getResourceAsStream("/js/helloNashorn.js");
        return (HelloNashorn) engine.eval(new InputStreamReader(scriptFile));
    }
}
