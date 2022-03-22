package eindopdracht.domain.export;

public class PdfAdapter implements ExportAdapter {

    @Override
    public String export(String string) {
        return PdfLibrary.exportAsPdf(string);
    }
    
}
