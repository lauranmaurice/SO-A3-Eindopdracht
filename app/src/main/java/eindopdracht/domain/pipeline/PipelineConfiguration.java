package eindopdracht.domain.pipeline;

/**
 * PipelineConfiguration
 */
public class PipelineConfiguration {
    private String[] utilityCommands;
    private String[] utilityScripts;

    public PipelineConfiguration(String[] utilityCommands, String[] utilityScripts) {
        this.utilityCommands = utilityCommands;
        this.utilityScripts = utilityScripts;
    }
    
    public String[] getUtilityCommands() {
        return utilityCommands;
    }
    public String[] getUtilityScripts() {
        return utilityScripts;
    }

    public void setUtilityScripts(String[] utilityScripts) {
        this.utilityScripts = utilityScripts;
    }
    public void setUtilityCommands(String[] utilityCommands) {
        this.utilityCommands = utilityCommands;
    }

    
}