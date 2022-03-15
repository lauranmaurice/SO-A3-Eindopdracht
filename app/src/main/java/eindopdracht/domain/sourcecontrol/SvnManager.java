package eindopdracht.domain.sourcecontrol;

public class SvnManager implements SourceControlManager {
    private void runCliCmd(String command) {
        System.err.println("Running svn-cli command: "+command);
    }

    @Override
    public void commit(String message) {
        runCliCmd("svn commit -m \""+message+"\"");
    }

    @Override
    public void addBranch(String name, boolean autoCheckout) {
        runCliCmd("svn copy "+name);
        if (autoCheckout) {
            this.checkout(name);
        }
    }

    @Override
    public void removeBranch(String name) {
        runCliCmd("svn rm "+name);
    }

    @Override
    public void checkout(String name) {
        runCliCmd("svn switch "+name);
    }

    @Override
    public void merge(String name) {
        runCliCmd("svn merge "+name);
    }

    @Override
    public void fetch() {
        runCliCmd("svn update"); /* svn has no fetch */
    }

    @Override
    public void pull() {
        runCliCmd("svn update");
    }

    @Override
    public void push() {
        runCliCmd("svn commit"); /* svn has no push, commit also pushes */
    }
    
}
