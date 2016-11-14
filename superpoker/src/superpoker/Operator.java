
package superpoker;

public class Operator {
    
    private String symbol;
    
    public Operator(String symbol){
        this.symbol = symbol;
    }
    
    public int operate(int a, int b)
    {
        try{
        if(symbol.equals("+"))
            return a + b;
        else if(symbol.equals("-"))
            return a - b;
        else if(symbol.equals("*"))
            return a * b;
        else
            return a / b;
        }catch(ArithmeticException e){
            return 0;
        }
    }
    
    @Override
    public String toString(){
        return " " + symbol + " ";
    }
}
