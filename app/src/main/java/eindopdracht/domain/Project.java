package eindopdracht.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eindopdracht.domain.backlog.Backlog;
import eindopdracht.domain.observers.SprintObserver;
import eindopdracht.domain.observers.TaskObserver;
/**
 * Project
 */
public class Project {

    private String name;
    private List<Sprint> sprints;
    private List<Person> persons;
    private Person scrumMaster;
    private ProductOwner productOwner;
    private Backlog backlog;

    private Map<Person, SprintObserver> sprintObservers;

    public Project(String name, Person scrumMaster, ProductOwner productOwner) {
        setName(name);
        this.sprints = new ArrayList<>();
        this.persons = new ArrayList<>();

        if(!scrumMaster.canScrum()) {
            throw new UnsupportedOperationException("This person has no scrum master behavior");
        }

        var scrumMasterTaskObserver = new TaskObserver();
        scrumMaster.addMethods(scrumMasterTaskObserver);

        this.backlog = new Backlog(scrumMasterTaskObserver);
        this.sprintObservers = new HashMap<>();

        setProductOwner(productOwner);
    }

    public Person getScrumMaster() {
        return scrumMaster;
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

        sprintObservers.forEach((k,v) -> {
            v.subscribeTo(sprint);
        });
    }

    public void removeSprint(Sprint sprint){
        this.sprints.remove(sprint);

        sprintObservers.forEach((k,v) -> {
            v.unsubscribeFrom(sprint);
        });
    }

    public void setProductOwner(ProductOwner productOwner){
        this.productOwner = productOwner;
    }

    public ProductOwner getProductOwner(){
        return this.productOwner;
    }

    public void addPerson(Person person){
        this.persons.add(person);

        var sprintObserver = new SprintObserver();
        person.addMethods(sprintObserver);
        for (var s : sprints) {
            sprintObserver.subscribeTo(s);
        }

        this.sprintObservers.put(person, sprintObserver);
    }

    public void removePerson(Person person){
        this.persons.remove(person);

        var sprintObserver = this.sprintObservers.get(person);
        for (var s : sprints) {
            sprintObserver.unsubscribeFrom(s);
        }

        this.sprintObservers.remove(person);
    }

    public List<Person> getPersons(){
        return this.persons;
    }
}