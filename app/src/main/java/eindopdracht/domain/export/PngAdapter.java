package eindopdracht.domain.export;

public class PngAdapter implements ExportAdapter {

    @Override
    public String export(String string) {
        return PngLibrary.exportAsPng(string);
    }

    
}
