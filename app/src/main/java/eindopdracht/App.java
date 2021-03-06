package eindopdracht;

import eindopdracht.domain.Person;
import eindopdracht.domain.backlog.Backlog;
import eindopdracht.domain.backlog.BacklogItem;
import eindopdracht.domain.backlog.BacklogTask;
import eindopdracht.domain.backlog.Epic;
import eindopdracht.domain.behaviour.DevelopNever;
import eindopdracht.domain.behaviour.ScrumAll;
import eindopdracht.domain.behaviour.TestNever;
import eindopdracht.domain.observers.TaskObserver;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        var master = new Person("henk", "henk@mail.ru", "123456", new DevelopNever(), new TestNever(), new ScrumAll());
        var masterObserver = new TaskObserver();
        master.addMethods(masterObserver);
        Backlog backlog = new Backlog(masterObserver);
        Epic surfingEpic = new Epic(1, "Surfing", "We need to surf at the beach");
        Epic sunbathingEpic = new Epic(2, "Sunbathing", "Enjoy the sun.");
        
        BacklogItem getSurfboard = new BacklogItem(3, "surfboard", "Getting my surfboard");

        BacklogItem item = new BacklogItem(5, "Another item, with (maybe) some tasks!", "wuuu");
        BacklogTask todo = new BacklogTask(1, "Guess what", "Check if off!");
        item.addItem(todo);
    
        surfingEpic.addItem(getSurfboard);
        
        backlog.addItem(surfingEpic);
        backlog.addItem(sunbathingEpic);
        backlog.addItem(item);

        var epics = backlog.getEpics();
        var all = backlog.getItems();

        System.out.println("===== EPICS ====");
        for (var e : epics) {
            System.out.println("Epic: "+e.getTitle()+" "+e.getNumber() + " " + e.getDescription());
        }

        System.out.println("===== ALL ====");
        for (var i : all) {
            System.out.println("Item: "+i.getClass().getName()+" "+i.getTitle()+" "+i.getDescription());
        }

        System.out.println(new App().getGreeting());
    }
}
