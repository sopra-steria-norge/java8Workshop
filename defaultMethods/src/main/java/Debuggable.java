import java.util.function.Function;

public interface Debuggable {

    public Function<Debuggable, String> traceFunction();

    public default void debugit() {
        String debugstring = traceFunction().apply(this);
        System.out.println("Yo debug " + debugstring);
    }
}
