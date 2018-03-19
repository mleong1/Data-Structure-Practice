package ObjectOrientedProblems;

import java.util.ArrayList;

public class BlackJackHand extends Hand<BlackJackCard> {
    //this class extends hand so it shares fields and methods with Hand like the array of cards
    public BlackJackHand(){

    }

    //generate arraylist of possible scores
    private ArrayList<Integer> possibleScores(){
        ArrayList<Integer> scores = new ArrayList<>();
        //if you have no cards return an empty list of scores
        if(this.cards.size() == 0){
            return scores;
        }
        for (BlackJackCard card: cards) {
                this.addCardToScoreList(card, scores);
        }
        return scores;
    }

    public void addCardToScoreList(BlackJackCard card, ArrayList<Integer> scores){
        //initilizes score to 0
        if(scores.size() == 0){
            scores.add(0);
        }
        //need to create  a variable fro scores.size because size will change dynamically with the ace
        int length = scores.size();
        for(int i = 0; i < length; i ++){
            int oldScore = scores.get(i);
            scores.set(i, oldScore + card.minValue());
            //essentially if the card added is an ace
            if(card.isAce()){
                scores.add(oldScore + card.maxValue());
            }
        }
    }
    public int score(){
        ArrayList<Integer> scores = this.possibleScores();
        int maxUnder = Integer.MIN_VALUE;
        int minOver = Integer.MAX_VALUE;
        for(int s: scores){
            if(s > 21 && s < minOver){
                minOver = s;
            } else if (s <= 21 && s > maxUnder){
                maxUnder = s;
            }
        }
        //if maxunder never changed return minOver and if it did return maxUnder
        //if maxunder never changed that score busted
        return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
    }

    public boolean isBusted(){
        return this.score() > 21;
    }

    public boolean is21(){
        return this.score() == 21;
    }

    public boolean isBlackJack() {
        if (this.cards.size() == 2) {
            BlackJackCard one = this.cards.get(0);
            BlackJackCard two = this.cards.get(1);
            return (one.isAce() && two.isFaceCard() || one.isFaceCard() && two.isAce());
        }
        return false;
    }
}
