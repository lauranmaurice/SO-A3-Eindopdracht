package eindopdracht.domain;

/**
 * BacklogTask
 */
public class BacklogTask extends BacklogComponent {

    private Person person;

    public BacklogTask(Person person){
        setPerson(person);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}