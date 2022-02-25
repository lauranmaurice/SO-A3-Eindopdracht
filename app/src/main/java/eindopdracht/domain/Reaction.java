package eindopdracht.domain;

public class Reaction {
    
    private String symbol;
    private Person person;

    public Reaction(String symbol, Person person){
        setSymbol(symbol);
        this.person = person;
    }

    public void setSymbol(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol(){
        return this.symbol;
    }

    public Person getPerson(){
        return this.person;
    }

}
