package eindopdracht.domain.sourcecontrol;

import java.util.ArrayList;
import java.util.List;

public class SvnManager implements SourceControlManager {
    public List<String> commandHistory;

    public SvnManager() {
        commandHistory = new ArrayList<>();
    }

    private void runCliCmd(String command) {
        System.err.println("Running svn-cli command: "+command);
        commandHistory.add(command);
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
