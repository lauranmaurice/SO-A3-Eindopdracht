package eindopdracht.domaintests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import eindopdracht.domain.ProductOwner;
import eindopdracht.domain.Project;
import eindopdracht.domain.backlog.Backlog;

/**
 * ProjectTest
 */
public class ProjectTest {

    private static Project project;
    
    @BeforeAll
    public static void prepare(){
        var backlog = new Backlog();
        ProductOwner productOwner = new ProductOwner("Tobi", "0682123143", "Tobi@home.nl");
        project = new Project("Shampoo", productOwner, backlog);

    }
    
    @Test
    public void getName(){
        
    }


}