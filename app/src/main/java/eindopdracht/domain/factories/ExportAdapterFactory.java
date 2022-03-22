package eindopdracht.domain.factories;

import eindopdracht.domain.export.ExportAdapter;
import eindopdracht.domain.export.PdfAdapter;
import eindopdracht.domain.export.PngAdapter;

/**
 * ExportAdapterFactory
 */
public class ExportAdapterFactory implements AdapterFactory {

    public ExportAdapter createAdapter(String name) {
        switch (name.toLowerCase()) {
            case "png":
                return new PngAdapter();
            case "pdf":
                return new PdfAdapter();
            default:
                throw new UnsupportedOperationException("Adapter "+name+" is not supported");
        }
    }
}