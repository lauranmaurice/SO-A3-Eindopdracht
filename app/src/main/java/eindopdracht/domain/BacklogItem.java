package eindopdracht.domain;

import java.util.ArrayList;
import java.util.List;

public class BacklogItem {

    private int number;
    private String title;
    private String description;
    private Person developer;
    private Person tester;
    private List<BacklogTask> tasks;

    public BacklogItem(int number, String title, String description){
        setNumber(number);
        setTitle(title);
        setDescription(description);
        this.tasks = new ArrayList<>();
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

    public int getNumber(){
        return this.number;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void addTask(BacklogTask task){
        this.tasks.add(task);
    }

    public void removeTask(BacklogTask task){
        this.tasks.remove(task);
    }

    public List<BacklogTask> getTasks(){
        return this.tasks;
    }

    

}
