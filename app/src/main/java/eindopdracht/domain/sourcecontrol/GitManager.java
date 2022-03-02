package eindopdracht.domain.sourcecontrol;

/**
 * GitManager
 */
public class GitManager implements SourceControlManager {

    private void runCliCmd(String command) {
        System.err.println("Running git-cli command: "+command);
    }

    @Override
    public void commit(String message) {
        runCliCmd("git commit -am \""+message+"\"");
    }

    @Override
    public void addBranch(String name, boolean autoCheckout) {
        if (!autoCheckout) {
            runCliCmd("git branch "+name);
        } else {
            runCliCmd("git checkout -b "+name);
        }
    }

    @Override
    public void removeBranch(String name) {
        runCliCmd("git branch -D "+name);
    }

    @Override
    public void checkout(String name) {
        runCliCmd("git checkout "+name);
    }

    @Override
    public void merge(String name) {
        runCliCmd("git merge "+name);
    }

    @Override
    public void fetch() {
        runCliCmd("git fetch");
    }

    @Override
    public void pull() {
        runCliCmd("git pull");
    }

    @Override
    public void push() {
        runCliCmd("git push");
    }
}