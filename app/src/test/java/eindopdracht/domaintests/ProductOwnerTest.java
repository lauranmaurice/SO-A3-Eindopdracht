package eindopdracht.domaintests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import eindopdracht.domain.ProductOwner;

public class ProductOwnerTest {

    private static ProductOwner productOwner;
    
    @BeforeEach
    public void prepare(){
        productOwner = new ProductOwner("Tobi", "0682123143", "Tobi@home.nl");

    }
    
    @Test
    public void getEmail(){
        assertEquals("Tobi@home.nl", productOwner.getEmail());
    }

    @Test
    public void setEmail(){
        productOwner.setEmail("Tobi@gmail.com");
        assertEquals("Tobi@gmail.com", productOwner.getEmail());
    }

    @Test
    public void getName(){
        assertEquals("Tobi", productOwner.getName());
    }

    @Test
    public void setName(){
        productOwner.setName("Tobi-Kadachi");
        assertEquals("Tobi-Kadachi", productOwner.getName());
    }

    @Test
    public void getPhoneNumber(){
        assertEquals("0682123143", productOwner.getPhoneNumber());
    }

    @Test
    public void setPhoneNumber(){
        productOwner.setPhoneNumber("0632392105");
        assertEquals("0632392105", productOwner.getPhoneNumber());
    }

}
