package eindopdracht.domain.backlog;

/**
 * Backlog item
 */
public class BacklogItem extends BacklogComponent {
    public BacklogItem(int number, String title, String description) {
        super(number, title, description);

    }

    public String toString(){
        return this.getNumber() + "" + this.getTitle(); 
    }
}
