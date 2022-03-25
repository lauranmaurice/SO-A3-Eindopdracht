package eindopdracht.pipelinetest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import eindopdracht.domain.pipeline.AntPipeline;
import eindopdracht.domain.pipeline.PipelineConfiguration;

public class AntPipelineTest {
    @Test
    public void CanExecuteCommandsInTemplateOrder() {
        var pipeline = new AntPipeline(new PipelineConfiguration(new String[]{}, new String[]{}));
        pipeline.run();

        assertEquals(4, pipeline.commandHistory.size());
        assertEquals("ant install", pipeline.commandHistory.get(0));
        assertEquals("ant nuke tests", pipeline.commandHistory.get(1));
        assertEquals("ant build", pipeline.commandHistory.get(2));
        assertEquals("ant deploy", pipeline.commandHistory.get(3));
    }
}
