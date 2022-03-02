package eindopdracht.domain.pipeline;

/**
 * DotnetPipeline
 */
public class DotnetPipeline extends TemplatePipeline {

    @Override
    public String[] collectSources() {
        return null;
    }

    @Override
    public void installPackages() {
        super.runCliCommand("dotnet restore");
    }

    @Override
    public void build() {
        super.runCliCommand("dotnet build");
        super.runCliCommand("dotnet publish -c Release");
    }

    @Override
    public void runTests() {
        super.runCliCommand("dotnet test");
    }

    @Override
    public void deploy() {
        //deploy to Azure, if azure is selected
    }
}