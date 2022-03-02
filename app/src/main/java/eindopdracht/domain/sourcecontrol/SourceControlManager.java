package eindopdracht.domain.sourcecontrol;

/**
 * SourceControlManager
 */
public interface SourceControlManager {
    public void commit(String message);

    public void addBranch(String name, boolean autoCheckout);
    public void removeBranch(String name);
    public void checkout(String name);
    public void merge(String name);

    public void fetch();
    public void pull();
    public void push();
}