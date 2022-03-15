package eindopdracht.pipelinetest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import eindopdracht.domain.pipeline.GradlePipeline;

/**
 * GradlePipelineTest
 */
public class GradlePipelineTest {

    @Test
    public void CanExecuteCommandsInTemplateOrder() {
        var pipeline = new GradlePipeline();
        pipeline.run();

        assertEquals(4, pipeline.commandHistory.size());
        assertEquals("gradle build --refresh-dependencies", pipeline.commandHistory.get(0));
        assertEquals("gradle test", pipeline.commandHistory.get(1));
        assertEquals("gradle build", pipeline.commandHistory.get(2));
        assertEquals("gradle deploy", pipeline.commandHistory.get(3));
    }

    @Test
    public void cantCollectSources() {
        var pipeline = new GradlePipeline();
        assertEquals(null, pipeline.collectSources());
    }
}