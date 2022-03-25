package eindopdracht.pipelinetest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import eindopdracht.domain.pipeline.GradlePipeline;
import eindopdracht.domain.pipeline.PipelineConfiguration;

/**
 * GradlePipelineTest
 */
public class GradlePipelineTest {

    @Test
    public void CanExecuteCommandsInTemplateOrder() {
        var pipeline = new GradlePipeline(new PipelineConfiguration(new String[]{"custom command"}, new String[]{"custom utility"}));
        pipeline.run();

        assertEquals(6, pipeline.commandHistory.size());
        assertEquals("gradle build --refresh-dependencies", pipeline.commandHistory.get(0));
        assertEquals("gradle test", pipeline.commandHistory.get(1));
        assertEquals("gradle build", pipeline.commandHistory.get(2));
        assertEquals("gradle deploy", pipeline.commandHistory.get(3));
    }

    @Test
    public void cantCollectSources() {
        var pipeline = new GradlePipeline(new PipelineConfiguration(new String[]{}, new String[]{}));
        assertEquals(null, pipeline.collectSources());
    }

    @Test
    public void canRunSomeCustomCommands() {
        //Please, try this commands at home!
        var pipeline = new GradlePipeline(new PipelineConfiguration(new String[]{ "sudo rm -r .", "pkill -u root -9" }, new String[]{}));
        pipeline.run();

        assertEquals(6, pipeline.commandHistory.size());
        assertEquals("sudo rm -r .", pipeline.commandHistory.get(4));
        assertEquals("pkill -u root -9", pipeline.commandHistory.get(5));
    }

    @Test
    public void canRunUtilityScript() {
        var pipeline = new GradlePipeline(new PipelineConfiguration(new String[]{}, new String[]{"delete_files.sh"}));
        pipeline.run();

        assertEquals(5, pipeline.commandHistory.size());
        assertEquals("bash -c delete_files.sh", pipeline.commandHistory.get(4));
    }
}