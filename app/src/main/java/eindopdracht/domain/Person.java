package eindopdracht.domain;

/**
 * Person
 */
public class Person {

    private String name;
    private String email;
    private String phonenumber;
    private boolean developer;
    private boolean tester;
    private boolean scrumMaster;

    public Person(String name, String email, String phonenumber, boolean developer, boolean tester, boolean scrumMaster){
        setName(name);
        setEmail(email);
        setPhonenumber(phonenumber);
        setDeveloper(developer);
        setTester(tester);
        setScrumMaster(scrumMaster);
    }

    public boolean isScrumMaster() {
        return scrumMaster;
    }

    public void setScrumMaster(boolean scrumMaster) {
        this.scrumMaster = scrumMaster;
    }

    public boolean isTester() {
        return tester;
    }

    public void setTester(boolean tester) {
        this.tester = tester;
    }

    public boolean isDeveloper() {
        return developer;
    }

    public void setDeveloper(boolean developer) {
        this.developer = developer;
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

    public void develop(){
        if (this.developer){
            System.out.println("I am developing.");
        } else {
            System.out.println("doing nothing");
        }
    }

    public void test(){
        if (this.tester){
            System.out.println("I am testing");
        } else {
            System.out.println("doing nothing");
        }
    }

    public void scrumming(){
        if (this.scrumMaster){
            System.out.println("I am holding a meeting.");
        } else {
            System.out.println("doing nothing");
        }
    }
    
}