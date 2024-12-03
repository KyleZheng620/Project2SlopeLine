


import java.util.ArrayList;


public class BlackjackLogic{
    private ArrayList<String> deck = new ArrayList<>();
    private ArrayList<String> playerHand;
    private ArrayList<String> dealerHand;

    public BlackjackLogic(ArrayList<String> deck, ArrayList<String> playerHand, ArrayList<String> dealerHand){
        this.deck = deck;
        this.playerHand = playerHand;
        this.dealerHand = dealerHand;
    }

    public int calculateHand(ArrayList<String> hand){
        int total = 0;
        int aces = 0;
        for (String card: hand){
            String rank = card.split (" ")[0];
            if ("Jack Queen King".contains(rank)){
                total+=10;
            } else if (rank.equals("Ace")){
                total+=11;
                aces++;
            } else {
                total+=Integer.parseInt(rank);
            }
        }
        while (total>21 && aces > 0){
            total-=10;
            aces--;
        }
        return total;
    }

    public ArrayList<String> initializeDeck(){
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        ArrayList<String> deck = new ArrayList<>();
        for (String i:suits){
            for (String j:ranks){
                deck.add(j + " of " + i);
            }
        }
        return deck;
    }
}
