package eindopdracht.pipelinetest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import eindopdracht.domain.pipeline.DotnetPipeline;
import eindopdracht.domain.pipeline.PipelineConfiguration;

/**
 * DotnetPipelineTest
 */
public class DotnetPipelineTest {

    @Test
    public void CanExecuteCommandsInTemplateOrder() {
        var pipeline = new DotnetPipeline(new PipelineConfiguration(new String[]{}, new String[]{}));
        pipeline.run();

        assertEquals(4, pipeline.commandHistory.size());
        assertEquals("dotnet restore", pipeline.commandHistory.get(0));
        assertEquals("dotnet test", pipeline.commandHistory.get(1));
        assertEquals("dotnet build", pipeline.commandHistory.get(2));
        assertEquals("dotnet publish -c Release", pipeline.commandHistory.get(3));
    }

    @Test
    public void cantCollectSources() {
        var pipeline = new DotnetPipeline(new PipelineConfiguration(new String[]{}, new String[]{}));
        assertEquals(null, pipeline.collectSources());
    }
}