package us.airt.client.scripting;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public final class ScriptEngineFacade {
    private final ScriptEngine jsEngine;

    public ScriptEngineFacade() {
        this.jsEngine = new ScriptEngineManager().getEngineByName("js");
    }

    public void evalJavaScript(String script) throws ScriptException {
        if (jsEngine == null) {
            throw new IllegalStateException("No JavaScript engine present. Add GraalJS runtime to classpath.");
        }
        jsEngine.eval(script);
    }
}
