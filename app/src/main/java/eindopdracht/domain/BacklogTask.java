package eindopdracht.domain;

/**
 * BacklogTask
 */
public class BacklogTask {

    private String title;
    private String description;
    private Person developer;
    private Person tester;
    private boolean completed = false; 

    public BacklogTask(String title, String description){
        setTitle(title);
        setDescription(description);
    }

    public Person getTester() {
        return tester;
    }

    public void setTester(Person tester) {
        if (tester.isTester()){
            this.tester = tester;
        }
    }

    public Person getDeveloper() {
        return developer;
    }

    public void setDeveloper(Person developer) {
        if (developer.isDeveloper()){
            this.developer = developer;
        }
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}