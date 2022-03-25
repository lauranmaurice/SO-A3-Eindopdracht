package eindopdracht.domain.pipeline;

/**
 * AntPipeline
 */
public class AntPipeline extends TemplatePipeline {
    public AntPipeline(PipelineConfiguration configuration) {
        super(configuration);
    }

    @Override
    public String[] collectSources() {
        return null;
    }

    @Override
    public void installPackages() {
        this.runCliCommand("ant install");
    }

    @Override
    public void build() {
        this.runCliCommand("ant build");
    }

    @Override
    public void runTests() {
        this.runCliCommand("ant nuke tests");
    }

    @Override
    public void deploy() {
        this.runCliCommand("ant deploy");
    } 
}