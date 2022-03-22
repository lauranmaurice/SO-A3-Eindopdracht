package eindopdracht.domain.export;

public class PdfLibrary {
    
    public static String exportAsPdf(String string){
        return "<" + string + "> Has been exported as a pdf.";
    }
}
