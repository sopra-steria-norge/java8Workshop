import java.util.function.Function;

public interface Debuggable {

    public Function<Debuggable, String> traceFunction();

    public default void debugit() {
        // Should output value of trace function
    }
}
