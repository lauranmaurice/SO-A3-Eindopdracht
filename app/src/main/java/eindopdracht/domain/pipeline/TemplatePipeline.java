package eindopdracht.domain.pipeline;

import java.util.ArrayList;
import java.util.List;

/**
 * TemplatePipeline
 */
public abstract class TemplatePipeline {
    public List<String> commandHistory;

    protected TemplatePipeline()
    {
        commandHistory = new ArrayList<>();
    }

    public final void run() {
        /* Template */

        var sources = collectSources();

        installPackages();
        runTests();
        analyze(sources);
        build();
        deploy();
        runUtilities();
    }

    protected void runCliCommand(String command) {
        System.out.println("Running command: "+command);
        commandHistory.add(command);
    }

    public abstract String[] collectSources();

    public abstract void installPackages();

    public abstract void build();

    public abstract void runTests();

    public void analyze(String[] sources) {
        System.err.println("No analysis configured. Skipping");
    }

    public abstract void deploy();

    public void runUtilities() {
        System.err.println("No utilities are configured. Skipping");
    }
}