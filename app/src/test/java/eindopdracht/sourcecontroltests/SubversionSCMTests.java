package eindopdracht.sourcecontroltests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import eindopdracht.domain.sourcecontrol.SvnManager;

/**
 * SubversionSCMTests
 */
public class SubversionSCMTests {

    @Test
    public void canAddBranchAndCheckout() {
        var manager = new SvnManager();
        manager.addBranch("test", true);
        assertEquals("svn copy test", manager.commandHistory.get(0));
        assertEquals("svn switch test", manager.commandHistory.get(1));
    }

    @Test
    public void canAddBranch() {
        var manager = new SvnManager();
        manager.addBranch("test", false);
        assertEquals("svn copy test", manager.commandHistory.get(0));
    }

    @Test
    public void canCommitWithMessage()
    {
        var manager = new SvnManager();
        manager.commit("Hello, world");
        assertEquals("svn commit -m \"Hello, world\"", manager.commandHistory.get(0));
    }

    @Test
    public void canRemoveBranch() {
        var manager = new SvnManager();
        manager.removeBranch("test");
        assertEquals("svn rm test", manager.commandHistory.get(0));
    }

    @Test
    public void canCheckout() {
        var manager = new SvnManager();
        manager.checkout("test");
        assertEquals("svn switch test", manager.commandHistory.get(0));
    }

    @Test
    public void canMerge() {
        var manager = new SvnManager();
        manager.merge("master");
        assertEquals("svn merge master", manager.commandHistory.get(0));
    }

    @Test
    public void canFetch() {
        var manager = new SvnManager();
        manager.fetch();
        assertEquals("svn update", manager.commandHistory.get(0));
    }

    @Test
    public void canPull() {
        var manager = new SvnManager();
        manager.pull();
        assertEquals("svn update", manager.commandHistory.get(0));
    }

    @Test
    public void canPush() {
        var manager = new SvnManager();
        manager.push();
        assertEquals("svn commit", manager.commandHistory.get(0));
    }
}