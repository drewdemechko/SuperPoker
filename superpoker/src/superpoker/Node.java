
package superpoker;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private List<Node> children;
    private Operator operator;
    
    public Node(Operator operator){
        this.operator = operator;
        this.children = new ArrayList<>();
    }
    
    public Operator getOperator(){
        return operator;
    }
    
    public void addChild(Node child){
        children.add(child);
    }
    
    public List<Node> getChildren(){
        return children;
    }
}
