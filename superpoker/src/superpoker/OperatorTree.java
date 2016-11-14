
package superpoker;

public class OperatorTree {
    
    private Card A;
    private Card B;
    private Card C;
    private Card D;
    
    Operator[] operators = {new Operator("+"), new Operator("-"), new Operator("*"), new Operator("/")};
    Node[] roots = {new Node(operators[0]),new Node(operators[1]),new Node(operators[2]),new Node(operators[3])};
    Node temp;
    
    public OperatorTree(){
        //construct operator tree
        for(Node r : roots){
            for(Operator o : operators){
                temp = new Node(o);
                r.addChild(temp);
                for(Operator o1 : operators)
                    temp.addChild(new Node(o1));
            } 
        }
    }
    
    public OperatorTree(Card A, Card B, Card C, Card D){
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        
        //construct operator tree
        for(Node r : roots){
            for(Operator o : operators){
                temp = new Node(o);
                r.addChild(temp);
                for(Operator o1 : operators)
                    temp.addChild(new Node(o1));
            } 
        }
    }
    
    public void setCards(Card cardA, Card cardB, Card cardC, Card cardD){
        this.A = cardA;
        this.B = cardB;
        this.C = cardC;
        this.D = cardD;
    }
    
    public void setCardA(Card card){
        this.A = card;
    }
    
    public void setCardB(Card card){
        this.B = card;
    }

    public void setCardC(Card card){
        this.C = card;
    }
    
    public void setCardD(Card card){
        this.D = card;
    }
    
    //Algorithm that returns the first available solution to 24
    public String findSolution(){
        
        if(A == null || B == null || C == null || D == null) //all cards not set
            return "Not all 4 cards have been selected!";
        int temp;
        
        for(Node r : roots){  //for each root + - * /
            if(r.getChildren() != null){  //if root has children --should never be null
                for(Node rootChild : r.getChildren()){
                    if(rootChild.getChildren() != null){ //--should never be null
                        for(Node child : rootChild.getChildren()){ //if child has children
                            //try to find 24 by using each operator and card only once but trying different scenarios (orders) --24 unique results, order matters so 4*3*2*1 
                            
                            //---------------* = operator and not necessarily multiply----------------
                            //A * B * C * D
                            temp = child.getOperator().operate(D.getValue(), 
                                        rootChild.getOperator().operate(C.getValue(),
                                                r.getOperator().operate(A.getValue(), B.getValue())));
                            if(temp == 24)
                                return "" + A + r.getOperator() + B + rootChild.getOperator() + C + child.getOperator() + D;
                            
                            //A * B * D * C
                            temp = child.getOperator().operate(C.getValue(), 
                                        rootChild.getOperator().operate(D.getValue(),
                                                r.getOperator().operate(A.getValue(), B.getValue())));
                            if(temp == 24)
                                return "" + A + r.getOperator() + B + rootChild.getOperator() + D + child.getOperator() + C;
                            
                            //A * C * D * B
                            temp = child.getOperator().operate(B.getValue(), 
                                        rootChild.getOperator().operate(D.getValue(),
                                                r.getOperator().operate(A.getValue(), C.getValue())));
                            if(temp == 24)
                                return "" + A + r.getOperator() + C + rootChild.getOperator() + D + child.getOperator() + B;
                            
                            //A * C * B * D
                            temp = child.getOperator().operate(D.getValue(), 
                                        rootChild.getOperator().operate(B.getValue(),
                                                r.getOperator().operate(A.getValue(), C.getValue())));
                            if(temp == 24)
                                return "" + A + r.getOperator() + B + rootChild.getOperator() + D + child.getOperator() + C;
                            
                            //A * D * C * B
                            temp = child.getOperator().operate(B.getValue(), 
                                        rootChild.getOperator().operate(C.getValue(),
                                                r.getOperator().operate(A.getValue(), D.getValue())));
                            if(temp == 24)
                                return "" + A + r.getOperator() + D + rootChild.getOperator() + C + child.getOperator() + B;
                            
                            //A * D * B * C
                            temp = child.getOperator().operate(C.getValue(), 
                                        rootChild.getOperator().operate(B.getValue(),
                                                r.getOperator().operate(A.getValue(), D.getValue())));
                            if(temp == 24)
                                return "" + A + r.getOperator() + D + rootChild.getOperator() + B + child.getOperator() + C;
                            
                            //B * C * D * A
                            temp = child.getOperator().operate(A.getValue(), 
                                        rootChild.getOperator().operate(D.getValue(),
                                                r.getOperator().operate(B.getValue(), C.getValue())));
                            if(temp == 24)
                                return "" + B + r.getOperator() + C + rootChild.getOperator() + D + child.getOperator() + A;
                            
                            //B * C * A * D
                            temp = child.getOperator().operate(D.getValue(), 
                                        rootChild.getOperator().operate(A.getValue(),
                                                r.getOperator().operate(B.getValue(), C.getValue())));
                            if(temp == 24)
                                return "" + B + r.getOperator() + C + rootChild.getOperator() + A + child.getOperator() + D;
                            
                            //B * A * C * D
                            temp = child.getOperator().operate(D.getValue(), 
                                        rootChild.getOperator().operate(C.getValue(),
                                                r.getOperator().operate(B.getValue(), A.getValue())));
                            if(temp == 24)
                                return "" + B + r.getOperator() + A + rootChild.getOperator() + C + child.getOperator() + D;
                            
                            //B * A * D * C
                            temp = child.getOperator().operate(C.getValue(), 
                                        rootChild.getOperator().operate(D.getValue(),
                                                r.getOperator().operate(B.getValue(), A.getValue())));
                            if(temp == 24)
                                return "" + B + r.getOperator() + A + rootChild.getOperator() + D + child.getOperator() + C;
                            
                            //B * D * A * C
                            temp = child.getOperator().operate(C.getValue(), 
                                        rootChild.getOperator().operate(A.getValue(),
                                                r.getOperator().operate(B.getValue(), D.getValue())));
                            if(temp == 24)
                                return "" + B + r.getOperator() + D + rootChild.getOperator() + A + child.getOperator() + C;
                            
                            //B * D * C * A
                            temp = child.getOperator().operate(A.getValue(), 
                                        rootChild.getOperator().operate(C.getValue(),
                                                r.getOperator().operate(B.getValue(), D.getValue())));
                            if(temp == 24)
                                return "" + B + r.getOperator() + D + rootChild.getOperator() + C + child.getOperator() + A;
                            
                            //C * D * A * B
                            temp = child.getOperator().operate(B.getValue(), 
                                        rootChild.getOperator().operate(A.getValue(),
                                                r.getOperator().operate(C.getValue(), D.getValue())));
                            if(temp == 24)
                                return "" + C + r.getOperator() + D + rootChild.getOperator() + A + child.getOperator() + B;
                            
                            //C * D * B * A
                            temp = child.getOperator().operate(A.getValue(), 
                                        rootChild.getOperator().operate(B.getValue(),
                                                r.getOperator().operate(C.getValue(), D.getValue())));
                            if(temp == 24)
                                return "" + C + r.getOperator() + D + rootChild.getOperator() + B + child.getOperator() + A;
                            
                            //C * A * D * B
                            temp = child.getOperator().operate(B.getValue(), 
                                        rootChild.getOperator().operate(D.getValue(),
                                                r.getOperator().operate(C.getValue(), A.getValue())));
                            if(temp == 24)
                                return "" + C + r.getOperator() + A + rootChild.getOperator() + D + child.getOperator() + B;
                            
                            //C * A * B * D
                            temp = child.getOperator().operate(D.getValue(), 
                                        rootChild.getOperator().operate(B.getValue(),
                                                r.getOperator().operate(C.getValue(), A.getValue())));
                            if(temp == 24)
                                return "" + C + r.getOperator() + A + rootChild.getOperator() + B + child.getOperator() + D;
                            
                            //C * B * A * D
                            temp = child.getOperator().operate(D.getValue(), 
                                        rootChild.getOperator().operate(A.getValue(),
                                                r.getOperator().operate(C.getValue(), B.getValue())));
                            if(temp == 24)
                                return "" + C + r.getOperator() + B + rootChild.getOperator() + A + child.getOperator() + D;
                            
                            //C * B * D * A
                            temp = child.getOperator().operate(A.getValue(), 
                                        rootChild.getOperator().operate(D.getValue(),
                                                r.getOperator().operate(C.getValue(), B.getValue())));
                            if(temp == 24)
                                return "" + C + r.getOperator() + B + rootChild.getOperator() + D + child.getOperator() + A;
                            
                            //D * A * B * C
                            temp = child.getOperator().operate(C.getValue(), 
                                        rootChild.getOperator().operate(B.getValue(),
                                                r.getOperator().operate(D.getValue(), A.getValue())));
                            if(temp == 24)
                                return "" + D + r.getOperator() + A + rootChild.getOperator() + B + child.getOperator() + C;
                            
                            //D * A * C * B
                            temp = child.getOperator().operate(B.getValue(), 
                                        rootChild.getOperator().operate(C.getValue(),
                                                r.getOperator().operate(D.getValue(), A.getValue())));
                            if(temp == 24)
                                return "" + D + r.getOperator() + A + rootChild.getOperator() + C + child.getOperator() + B;
                            
                            //D * B * A * C
                            temp = child.getOperator().operate(C.getValue(), 
                                        rootChild.getOperator().operate(A.getValue(),
                                                r.getOperator().operate(D.getValue(), B.getValue())));
                            if(temp == 24)
                                return "" + D + r.getOperator() + B + rootChild.getOperator() + A + child.getOperator() + C;
                            
                            //D * B * C * A
                            temp = child.getOperator().operate(A.getValue(), 
                                        rootChild.getOperator().operate(C.getValue(),
                                                r.getOperator().operate(D.getValue(), B.getValue())));
                            if(temp == 24)
                                return "" + D + r.getOperator() + B + rootChild.getOperator() + C + child.getOperator() + A;
                            
                            //D * C * A * B
                            temp = child.getOperator().operate(B.getValue(), 
                                        rootChild.getOperator().operate(A.getValue(),
                                                r.getOperator().operate(D.getValue(), C.getValue())));
                            if(temp == 24)
                                return "" + D + r.getOperator() + C + rootChild.getOperator() + A + child.getOperator() + B;
                            
                            //D * C * B * A
                            temp = child.getOperator().operate(A.getValue(), 
                                        rootChild.getOperator().operate(B.getValue(),
                                                r.getOperator().operate(D.getValue(), C.getValue())));
                            if(temp == 24)
                                return "" + D + r.getOperator() + C + rootChild.getOperator() + B + child.getOperator() + A;
                        }
                    }
                }
            }
        }
        return "No solution could be found!";
    }
}
