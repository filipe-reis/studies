package interview.brex.cardsandgems;

import java.util.HashMap;
import java.util.Map;

/**
 * Splendor is a card-based board game where players buy cards in exchange for colored gems.
 * In this game, today, we care about two things, gems and cards.
 * Players can have any number of gems of five different colors: (B)lue, (W)hite, (G)reen, (R)ed, and (Y)ellow.
 * Players can exchange gems for cards. A card appears as such:
 *
 * +----------+
 * | G |
 * | |
 * | |
 * | 3W |
 * | 2G |
 * | 1R |
 * +----------+
 *
 * This indicates that the card costs 3 (W)hite gems, 2 (G)reen gems, and 1 (R)ed.
 * The “G” in the upper right indicates the color of the card (this will be useful later)
 * For this entire problem, we want to keep things simple by assuming that there is only one player.
 * The data model and structure of the program is up to you.
 *
 * QUESTION 1: We want to write a function can_purchase() such that,
 *              given a particular card and collection of gems for a player,
 *              we return true if the player can afford the card, and false if they cannot.
 *
 * QUESTION 2: We want to write a function purchase() such that,
 *             given a particular card and collection of gems for a player,
 *             we add the card to the players hand and subtract the cost from the players gems,
 *             if they are able to afford the card.
 *             The function should return true if the player can afford the card,
 *             and false if they cannot.
 *
 * !!!!!!!!!NÃO CHEGUEI NA QUESTÃO 3 NA MINHA ENTREVISTA!!!!!!!!
 *
 * QUESTION 3: We want to introduce a new concept: for each card in a players hand of a given color,
 *              we want to reduce the cost of any new purchase by 1 gem for that held cards color.
 *              For example, if the player holds 2 (G)reen cards and 1 (R)ed,
 *              and we are considering a card that lists its cost as 3 (G)reen, 2 (R)ed, and 1 (B)lue,
 *              then the player should be able to purchase it for 1 G, 1 R, and 1 B.
 */
public class CardsAndGemsQuestion {

    public static void main(String[] args) {
        HashMap<String, Integer> gems = new HashMap<>();
        gems.put("W", 3);
        gems.put("G", 2);
        gems.put("R", 1);

        HashMap<String, Integer> wallet = new HashMap<>();
        gems.put("W", 3);
        gems.put("G", 2);
        gems.put("R", 1);

        var sol = new Purchase();
        sol.can_purchase(gems, wallet);
    }

}

class Purchase{

    public boolean can_purchase(HashMap<String, Integer> gems, HashMap<String, Integer> wallet){
        int walletValue = 0;

        for(Map.Entry<String, Integer> gemColor: gems.entrySet()){
            walletValue = wallet.getOrDefault(gemColor.getKey(), 0);

            if(walletValue < gemColor.getValue()){
                return false;
            }
        }

        return true;
    }

    // Não tive tempo para criar os objetos Card e Player durante a entrevista
    // e não tive tempo para testar esse metodo.
    public boolean purchase(Card card, Player player){
        HashMap gems = new HashMap();
        gems = card.gems;

        HashMap wallet = new HashMap();
        wallet = player.wallet;

        if(can_purchase(gems, wallet)){
            player.card = card;

            for(Map.Entry<String, Integer> gemColor : gems.entrySet()){
                wallet.get(gemColor.getKey(), wallet.get(gemColor.getKey() - gemColor.getValue()));
            }
            player.wallet = wallet;
        }
    }
}