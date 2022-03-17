package eindopdracht.domain;

import java.util.ArrayList;
import java.util.List;

import eindopdracht.domain.behaviour.DeveloperBehaviour;
import eindopdracht.domain.behaviour.ScrumMasterBehaviour;
import eindopdracht.domain.behaviour.TestBehaviour;
import eindopdracht.domain.notifications.EmailSender;
import eindopdracht.domain.notifications.NotificationSender;
import eindopdracht.domain.observers.NotificationObserver;

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
    private List<NotificationSender> notificationSenders;
    private EmailSender mailSender;

    public Person(String name, String email, String phonenumber, DeveloperBehaviour developerBehaviour, TestBehaviour testerBehaviour, ScrumMasterBehaviour scrumMasterBehaviour){
        setName(name);
        this.email = email;
        setPhonenumber(phonenumber);
        setDeveloperBehaviour(developerBehaviour);
        setTesterBehaviour(testerBehaviour);
        setScrumMasterBehaviour(scrumMasterBehaviour);

        //TODO: preferences
        notificationSenders = new ArrayList<>();
        mailSender = new EmailSender(this.email);
        notificationSenders.add(mailSender);
    }

    public void addMethods(NotificationObserver observer) {
        for (var s : notificationSenders) {
            observer.addNotificationSender(s);
        }
    }

    public List<NotificationSender> getNotificationSenders() {
        return notificationSenders;
    }

    public String develop(){
        return this.developerBehaviour.develop();
    }

    public boolean canDevelop(){
        return this.developerBehaviour.canDevelop();
    }

    public String test(){
        return this.testerBehaviour.test();
    }

    public boolean canTest(){
        return this.testerBehaviour.canTest();
    }

    public String scrum(){
        return this.scrumMasterBehaviour.scrum();
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
        this.mailSender.setEmail(email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}