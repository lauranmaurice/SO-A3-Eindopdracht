package eindopdracht.domain.rapport;

import eindopdracht.domain.Project;
import eindopdracht.domain.factories.AdapterFactory;

/**
 * ExternRapportGenerator
 */
public class ExternRapportGenerator extends RapportTemplate{

	public ExternRapportGenerator(Project project, AdapterFactory exportAdapterFactory) {
		super(project, exportAdapterFactory);
	}

	@Override
	public String teamComposition() {
		return "";
	}

    
}