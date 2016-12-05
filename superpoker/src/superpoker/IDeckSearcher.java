
package superpoker;

public interface IDeckSearcher {
    public void createDeck(Card cardA, Card cardB, Card cardC, Card cardD);
    public String findSolution();
    public String findSolutionThroughEndpoint();
}
