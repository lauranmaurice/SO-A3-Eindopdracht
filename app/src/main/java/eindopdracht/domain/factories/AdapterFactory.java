package eindopdracht.domain.factories;

import eindopdracht.domain.export.ExportAdapter;

/**
 * AdapterFactory
 */
public interface AdapterFactory {

    public ExportAdapter createAdapter(String name);
}