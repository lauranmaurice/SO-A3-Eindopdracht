package eindopdracht.domain;

import java.util.ArrayList;
import java.util.List;

public class BacklogItem {

    private int number;
    private String title;
    private String description;
    private Person person;
    private List<BacklogTask> tasks;

    public BacklogItem(int number, String title, String description, Person person){
        setNumber(number);
        setTitle(title);
        setDescription(description);
        setPerson(person);
        this.tasks = new ArrayList<>();
    }

    // functions number
    public int getNumber(){
        return this.number;
    }

    public void setNumber(int number){
        this.number = number;
    }

    // functions title
    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    // functions description
    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    // functions person
    public Person getPerson(){
        return this.person;
    }

    public void setPerson(Person person){
        this.person = person;
    }

    // functions task
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
