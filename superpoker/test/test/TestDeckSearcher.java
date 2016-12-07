
package test;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import superpoker.DeckSearcher;

public class TestDeckSearcher {
    DeckSearcher deckSearcher;
    
    @Before
    public void oneTimeSetup(){
        deckSearcher = new DeckSearcher();
    }
    
    @Test
    public void createUrlSuccessfullyConnectsToApiEndpoint(){
        deckSearcher.createURL();
        assertTrue(deckSearcher.isConnected());
    }
    
    public void getOperatorTreeDoesNotReturnNull(){
        assertTrue(deckSearcher.getOperatorTree() != null);
    }
}
