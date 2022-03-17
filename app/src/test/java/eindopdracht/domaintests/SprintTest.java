package eindopdracht.domaintests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import eindopdracht.TestHelper;
import eindopdracht.domain.Sprint;


public class SprintTest {
    
    private static Sprint sprint;
    
    @BeforeAll
    public static void prepare(){
        sprint = new Sprint("Sprint 1", 1, TestHelper.giveMeAScrumMaster());
    }
    
    @Test
    public void getSprintName(){
        assertEquals("Sprint 1", sprint.getSprintName());
    }

    @Test 
    public void setSprintName(){
        sprint.setSprintName("Migration");
        assertEquals("Migration", sprint.getSprintName());
    }

    @Test
    public void getSprintNumber(){
        assertEquals(1, sprint.getSprintNumber());
    }

    @Test
    public void setSprintNumber(){
        sprint.setSprintNumber(2);
        assertEquals(2, sprint.getSprintNumber());
    }

}
