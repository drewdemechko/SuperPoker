
package superpoker;

public class Operator {
    
    private String symbol;
    
    public Operator(String symbol){
        this.symbol = symbol;
    }
    
    public int operate(int a, int b)
    {
        if(symbol.equals("+"))
            return a + b;
        else if(symbol.equals("-"))
            return a - b;
        else if(symbol.equals("*"))
            return a * b;
        else
            return a / b;
    }
    
    @Override
    public String toString(){
        return " " + symbol + " ";
    }
}
