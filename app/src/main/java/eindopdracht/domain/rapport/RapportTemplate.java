package eindopdracht.domain.rapport;

import java.util.ArrayList;
import java.util.List;

import eindopdracht.domain.Project;
import eindopdracht.domain.Sprint;
import eindopdracht.domain.backlog.BacklogItem;
import eindopdracht.domain.export.ExportAdapter;
import eindopdracht.domain.factories.AdapterFactory;

/**
 * RapportTemplate
 */
public abstract class RapportTemplate {

    Project project;
    Sprint sprint;
    String header; 
    String footer;
    ExportAdapter exportAdapter;
    AdapterFactory adapterFactory;
    
    public RapportTemplate(Project project, AdapterFactory adapterFactory){
        this.project = project;
        this.sprint = project.getSprints().get(0);
        this.header = "==" + project.getName() + "==   www.ourimageurl.com";
        this.footer = "";
        this.adapterFactory = adapterFactory;
    }

    public void useExportAdapter(String name) {
        //call factory with "png" or "pdf"
        this.exportAdapter = this.adapterFactory.createAdapter(name);
    }

    public final String run(){
        StringBuilder stringBuilder = new StringBuilder();
        // header
        stringBuilder.append(getHeader() + "\n");
        //po
        stringBuilder.append(getProductOwner() + "\n");
        // scrummaster
        stringBuilder.append(getScrumMaster() + "\n");
        // teamsamenstelling
        stringBuilder.append(teamComposition());
        // tasks
        stringBuilder.append(getTasks());
        // footer
        stringBuilder.append(getFooter());
        //export
        return this.export(stringBuilder.toString());
    }

    public Sprint getSprint(){
        return this.sprint;
    }

    public void setSprint(int sprintNumber){
        int realNumber = sprintNumber - 1;
        // realnumber = 1
        List<Sprint> sprints = project.getSprints();
        if (realNumber >= 0 && realNumber <= sprints.size()){
            this.sprint = sprints.get(realNumber);
        } else {
            System.err.println("Sprintnumber is out of scope.");
        }
    } 

    public String getHeader(){
        return this.header;
    }

    public void setHeader(String title, String imageUrl){
        this.header = "==" + title + "==   " + imageUrl;
    }

    public String getFooter(){
        return this.footer;
    }

    public void setFooter(String footer){
        this.footer = footer; 
    }

    public String getTasks(){
        List<BacklogItem> backlogItems = this.sprint.getBacklog().getBacklogItems();
        List<BacklogItem> notFinished = new ArrayList<>(); 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("========================= \n Tasks finished \n ==================== \n");
        for (BacklogItem backlogItem : backlogItems) {
            if (backlogItem.getState() == backlogItem.getDoneState() || backlogItem.getState() == backlogItem.getClosedState()){
                stringBuilder.append(backlogItem.toString() + "\n"); 
            } else {
                notFinished.add(backlogItem);
            }
        }
        stringBuilder.append("====================== \n Tasks not finished \n ================== \n");
        for (BacklogItem backlogItem : notFinished) {
            stringBuilder.append(backlogItem.toString() + "\n");
        }
        return stringBuilder.toString();
    }

    public String getProductOwner(){
        return "Product Owner: " + project.getProductOwner().getName();
    }

    public String getScrumMaster(){
        return "Scrum Master: " + project.getScrumMaster().getName();
    }

    public String export(String string){
        return this.exportAdapter.export(string);
    }

    public abstract String teamComposition();


}

