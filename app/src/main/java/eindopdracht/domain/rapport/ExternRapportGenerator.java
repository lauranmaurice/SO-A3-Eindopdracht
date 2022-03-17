package eindopdracht.domain.rapport;

import eindopdracht.domain.Project;

/**
 * ExternRapportGenerator
 */
public class ExternRapportGenerator extends RapportTemplate{

	public ExternRapportGenerator(Project project) {
		super(project);
	}

	@Override
	public String teamComposition() {
		return "";
	}

    
}