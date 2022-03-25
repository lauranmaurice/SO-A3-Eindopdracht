package eindopdracht.domain.pipeline;

/**
 * TestResults
 */
public class TestResults {

    private double coverage;
    private boolean success;

    public TestResults(double coverage, boolean success) {
        this.coverage = coverage;
        this.success = success;
    }
    
    public boolean isSuccess() {
        return success;
    }
    public double getCoverage() {
        return coverage;
    }
    public void setCoverage(double coverage) {
        this.coverage = coverage;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }

}