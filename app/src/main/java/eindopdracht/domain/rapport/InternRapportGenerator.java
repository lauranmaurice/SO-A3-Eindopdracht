package eindopdracht.domain.rapport;

import eindopdracht.domain.Person;
import eindopdracht.domain.Project;
import eindopdracht.domain.factories.AdapterFactory;

/**
 * InternRapportGenerator
 */
public class InternRapportGenerator extends RapportTemplate{

    public InternRapportGenerator(Project project, AdapterFactory exportAdapterFactory) {
        super(project, exportAdapterFactory);
    }

    @Override
    public String teamComposition() {
        var persons = project.getPersons();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Team members: \n" );
        for (Person person : persons) {
            stringBuilder.append(person.getName() + "\n");
        }

        return stringBuilder.toString();
    }

}