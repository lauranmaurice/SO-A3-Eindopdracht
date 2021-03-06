package eindopdracht.domain.pipeline;

/**
 * GradlePipeline
 */
public class GradlePipeline extends TemplatePipeline {

    public GradlePipeline(PipelineConfiguration configuration) {
        super(configuration);
    }

    @Override
    public String[] collectSources() {
        return null;
    }

    @Override
    public void installPackages() {
        runCliCommand("gradle build --refresh-dependencies");
    }

    @Override
    public void build() {
        runCliCommand("gradle build");
    }

    @Override
    public void runTests() {
        runCliCommand("gradle test");
    }

    @Override
    public void deploy() {
        runCliCommand("gradle deploy");
    } 
}