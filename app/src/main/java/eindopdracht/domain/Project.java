package eindopdracht.domain;

import java.util.ArrayList;
import java.util.List;

import eindopdracht.domain.backlog.Backlog;

/**
 * Project
 */
public class Project {

    private String name;
    private List<Sprint> sprints;
    private List<Person> persons;
    private ProductOwner productOwner;
    private Backlog backlog;

    public Project(String name, ProductOwner productOwner) {
        setName(name);
        this.sprints = new ArrayList<>();
        this.persons = new ArrayList<>();
        this.backlog = new Backlog();
        setProductOwner(productOwner);
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Backlog getBacklog(){
        return this.backlog;
    }

    public List<Sprint> getSprints() {
        return sprints;
    }

    public void addSprint(Sprint sprint){
        this.sprints.add(sprint);
    }

    public void removeSprint(Sprint sprint){
        this.sprints.remove(sprint);
    }

    public void setProductOwner(ProductOwner productOwner){
        this.productOwner = productOwner;
    }

    public ProductOwner getProductOwner(){
        return this.productOwner;
    }

    public void addPerson(Person person){
        this.persons.add(person);
    }

    public void removePerson(Person person){
        this.persons.remove(person);
    }

    public List<Person> getPersons(){
        return this.persons;
    }
}