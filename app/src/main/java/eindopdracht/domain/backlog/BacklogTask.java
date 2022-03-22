package eindopdracht.domain.backlog;

/**
 * BacklogTask
 */
public class BacklogTask extends BacklogComponent {
	public BacklogTask(int number, String title, String description) {
		super(number, title, description);
	}

    @Override
    public void addItem(BacklogComponent backlogComponent) {
        throw new UnsupportedOperationException("Unable to nest items into a task");
    }

    @Override
    public void removeItem(BacklogComponent backlogComponent) {
        throw new UnsupportedOperationException("Unable to remove baclogComponents from a backlogTask.");
    }

    @Override
    public String moveToToDo(){
        throw new UnsupportedOperationException("Unable to use states from a backlogTask.");
    }

    @Override
    public String moveToDoing(){
        throw new UnsupportedOperationException("Unable to use states from a backlogTask.");

    }

    @Override
    public String moveToReadyForTesting(){
        throw new UnsupportedOperationException("Unable to use states from a backlogTask.");
    }

    @Override
    public String moveToTesting(){
        throw new UnsupportedOperationException("Unable to use states from a backlogTask.");
    }

    @Override
    public String moveToTested(){
        throw new UnsupportedOperationException("Unable to use states from a backlogTask.");
    }

    @Override
    public String moveToDone(){
        throw new UnsupportedOperationException("Unable to use states from a backlogTask.");
    }

    @Override
    public String moveToClosed(){
        throw new UnsupportedOperationException("Unable to use states from a backlogTask.");
    }
}