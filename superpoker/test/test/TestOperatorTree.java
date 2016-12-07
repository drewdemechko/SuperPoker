
package test;

import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*;
import superpoker.Card;
import superpoker.OperatorTree;

public class TestOperatorTree {
    
    OperatorTree operatorTree;
    
    @Before
    public void oneTimeSetUp()
    {
        operatorTree = new OperatorTree();
    }
    
    @Test
    public void getOperationsShouldReturnCoreMathOperations(){
        assertTrue(operatorTree.getOperators().contains("+"));
        assertTrue(operatorTree.getOperators().contains("-"));
        assertTrue(operatorTree.getOperators().contains("/"));
        assertTrue(operatorTree.getOperators().contains("*"));
    }
    
    @Test
    public void findSolutionShouldReturnNoSolutionForCardSetWithImpossibleSolutions(){
        Card cardA = new Card("Ace of Spades",1);
        Card cardB = new Card("Ace of Diamonds",1);
        Card cardC = new Card("Ace of Hearts",1);
        Card cardD = new Card("Ace of Clubs",1);
        operatorTree.setCards(cardA, cardB, cardC, cardD);
        assertTrue(operatorTree.findSolution().equals("No solution could be found!"));
    }
    
    @Test
    public void findSolutionShouldReturnSolutionForCardsOfUniqueValues(){
        Card cardA = new Card("Seven of Spades",7);
        Card cardB = new Card("Eight of Diamonds",8);
        Card cardC = new Card("Nine of Hearts",9);
        Card cardD = new Card("Ten of Clubs",10);
        operatorTree.setCards(cardA, cardB, cardC, cardD);
        assertTrue(operatorTree.solutionFound());
        
        Card cardA2 = new Card("Jack of Spades",10);
        Card cardB2 = new Card("Queen of Diamonds",11);
        Card cardC2 = new Card("Four of Hearts",4);
        Card cardD2 = new Card("Three of Clubs",3);
        operatorTree.setCards(cardA2, cardB2, cardC2, cardD2);
        assertTrue(operatorTree.solutionFound());
    }
    
    @Test
    public void findSolutionShouldReturnSolutionForCardsOfSameValues(){
        Card cardA = new Card("Four of Spades",4);
        Card cardB = new Card("Four of Diamonds",4);
        Card cardC = new Card("Four of Hearts",4);
        Card cardD = new Card("Four of Clubs",4);
        operatorTree.setCards(cardA, cardB, cardC, cardD);
        assertTrue(operatorTree.solutionFound());
        
        Card cardA2 = new Card("Six of Spades",6);
        Card cardB2 = new Card("Six of Diamonds",6);
        Card cardC2 = new Card("Six of Hearts",6);
        Card cardD2 = new Card("Six of Clubs",6);
        operatorTree.setCards(cardA2, cardB2, cardC2, cardD2);
        assertTrue(operatorTree.solutionFound());
    }
}
