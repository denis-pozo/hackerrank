package org.pozopardo.challenges.hackerrank.data.structure;

import java.util.*;

public class ScoreBoard implements Comparator<Player> {

    @Override
    public int compare(Player pOne, Player pTwo) {
        if(pOne.score != pTwo.score)
            return pTwo.score - pOne.score;

        if(pOne.score == pTwo.score) {
            return pOne.name.compareTo(pTwo.name);
        }
        return 0;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        ScoreBoard scoreBoard = new ScoreBoard();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, scoreBoard);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }

}

class Player{
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

