package eindopdracht.sourcecontroltests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import eindopdracht.domain.sourcecontrol.GitManager;

/**
 * GitSCMTests
 */
public class GitSCMTests {

    @Test
    public void canAddBranchAndCheckout() {
        var manager = new GitManager();
        manager.addBranch("test", true);
        assertEquals("git checkout -b test", manager.commandHistory.get(0));
    }

    @Test
    public void canAddBranch() {
        var manager = new GitManager();
        manager.addBranch("test", false);
        assertEquals("git branch test", manager.commandHistory.get(0));
    }

    @Test
    public void canCommitWithMessage()
    {
        var manager = new GitManager();
        manager.commit("Hello, world");
        assertEquals("git commit -am \"Hello, world\"", manager.commandHistory.get(0));
    }

    @Test
    public void canRemoveBranch() {
        var manager = new GitManager();
        manager.removeBranch("test");
        assertEquals("git branch -D test", manager.commandHistory.get(0));
    }

    @Test
    public void canCheckout() {
        var manager = new GitManager();
        manager.checkout("test");
        assertEquals("git checkout test", manager.commandHistory.get(0));
    }

    @Test
    public void canMerge() {
        var manager = new GitManager();
        manager.merge("master");
        assertEquals("git merge master", manager.commandHistory.get(0));
    }

    @Test
    public void canFetch() {
        var manager = new GitManager();
        manager.fetch();
        assertEquals("git fetch", manager.commandHistory.get(0));
    }

    @Test
    public void canPull() {
        var manager = new GitManager();
        manager.pull();
        assertEquals("git pull", manager.commandHistory.get(0));
    }

    @Test
    public void canPush() {
        var manager = new GitManager();
        manager.push();
        assertEquals("git push", manager.commandHistory.get(0));
    }
}