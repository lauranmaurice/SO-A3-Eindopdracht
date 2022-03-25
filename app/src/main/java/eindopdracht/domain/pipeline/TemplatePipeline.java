package eindopdracht.domain.pipeline;

import java.util.ArrayList;
import java.util.List;

/**
 * TemplatePipeline
 */
public abstract class TemplatePipeline {
    public List<String> commandHistory;
    private PipelineConfiguration configuration;

    protected TemplatePipeline(PipelineConfiguration configuration) {
        this.configuration = configuration;
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

    private final TestResults collectTestResults() {
        return new TestResults(82.3, true);
    }

    public abstract String[] collectSources();

    public abstract void installPackages();

    public abstract void build();

    public abstract void runTests();

    public void analyze(String[] sources) {
        prepareAnalysis();
        executeAnalysis();
        var results = reportAnalysis();
        System.out.println("Test success: "+ results.isSuccess()+", coverage: " + results.getCoverage() + "%");
    }

    public void prepareAnalysis(){}
    public void executeAnalysis(){}
    public TestResults reportAnalysis(){
        return this.collectTestResults();
    };

    public abstract void deploy();

    public void runUtilities() {
        if(this.configuration.getUtilityCommands().length > 0) {
            for (String command : this.configuration.getUtilityCommands()) {
                this.runCliCommand(command);
            }
        }

        if(this.configuration.getUtilityScripts().length > 0) {
            for(var script : this.configuration.getUtilityScripts()) {
                this.runCliCommand("bash -c " + script);
            }
        }
    }
}