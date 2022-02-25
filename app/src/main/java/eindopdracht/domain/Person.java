package eindopdracht.domain;

import eindopdracht.domain.behaviour.DeveloperBehaviour;
import eindopdracht.domain.behaviour.ScrumMasterBehaviour;
import eindopdracht.domain.behaviour.TestBehaviour;

/**
 * Person
 */
public class Person {

    private String name;
    private String email;
    private String phonenumber;
    private DeveloperBehaviour developerBehaviour;
    private TestBehaviour testerBehaviour;
    private ScrumMasterBehaviour scrumMasterBehaviour;

    public Person(String name, String email, String phonenumber, DeveloperBehaviour developerBehaviour, TestBehaviour testerBehaviour, ScrumMasterBehaviour scrumMasterBehaviour){
        setName(name);
        setEmail(email);
        setPhonenumber(phonenumber);
        setDeveloperBehaviour(developerBehaviour);
        setTesterBehaviour(testerBehaviour);
        setScrumMasterBehaviour(scrumMasterBehaviour);
    }

    public void develop(){
        this.developerBehaviour.develop();
    }

    public boolean canDevelop(){
        return this.developerBehaviour.canDevelop();
    }

    public void test(){
        this.testerBehaviour.test();
    }

    public boolean canTest(){
        return this.testerBehaviour.canTest();
    }

    public void scrum(){
        this.scrumMasterBehaviour.scrum();
    }

    public boolean canScrum(){
        return this.scrumMasterBehaviour.canScrum();
    }


    public void setDeveloperBehaviour(DeveloperBehaviour developerBehaviour){
        this.developerBehaviour = developerBehaviour;
    }

    public void setTesterBehaviour(TestBehaviour testBehaviour){
        this.testerBehaviour = testBehaviour;
    }

    public void setScrumMasterBehaviour(ScrumMasterBehaviour scrumMasterBehaviour){
        this.scrumMasterBehaviour = scrumMasterBehaviour;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}