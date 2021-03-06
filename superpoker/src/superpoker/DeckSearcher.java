
package superpoker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

public class DeckSearcher implements IDeckSearcher{
    private OperatorTree possibleComputationsTree;
    private String ENDPOINT = "http://seiisuperpoker.azurewebsites.net/api/SuperPoker";
    private URL url;
    
    private HttpURLConnection request;
    
    public DeckSearcher(){
            possibleComputationsTree = new OperatorTree();
    }
    
    public DeckSearcher(Card cardA, Card cardB, Card cardC, Card cardD){
        possibleComputationsTree = new OperatorTree(cardA, cardB, cardC, cardD);
    }
    
    public void createURL(){
        try {
            url = new URL(ENDPOINT);
            request = (HttpURLConnection) url.openConnection();
            request.setRequestMethod("GET");
            request.setRequestProperty("Accept", "application/json");
            request.connect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }  
    }
    
    public boolean isConnected(){
        return request != null;
    }
    
    @Override
    public void createDeck(Card cardA, Card cardB, Card cardC, Card cardD){
        possibleComputationsTree.setCards(cardA, cardB, cardC, cardD);
    }
    
    @Override
    public String findSolutionThroughEndpoint(){
        createURL();
        
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(request.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(DeckSearcher.class.getName()).log(Level.SEVERE, null, ex);
        }
        String inputLine;
        StringBuffer response = new StringBuffer();

        try {
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        } catch (IOException ex) {
            Logger.getLogger(DeckSearcher.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(DeckSearcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        //Get Json from endpoint and parse
        JSONObject jsonResponse = new JSONObject(response.toString());
        JSONArray jsonDeck = jsonResponse.getJSONArray("cards");
        Card cardA = new Card(jsonDeck.getJSONObject(0).get("value").toString(),jsonDeck.getJSONObject(0).getInt("value"));
        Card cardB = new Card(jsonDeck.getJSONObject(1).get("value").toString(),jsonDeck.getJSONObject(1).getInt("value"));
        Card cardC = new Card(jsonDeck.getJSONObject(2).get("value").toString(),jsonDeck.getJSONObject(2).getInt("value"));
        Card cardD = new Card(jsonDeck.getJSONObject(3).get("value").toString(),jsonDeck.getJSONObject(3).getInt("value"));

        //add card values to deck
        createDeck(cardA, cardB, cardC, cardD);
                
        return findSolution();
    }
    
    @Override
    public String findSolution(){
        return possibleComputationsTree.findSolution();
    }
    
    @Override
    public OperatorTree getOperatorTree(){
        return possibleComputationsTree;
    }
}
