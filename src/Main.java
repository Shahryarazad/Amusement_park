import cards.cards;
import frame.myFrame;
import coinOwners.players;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        cards.makeFirstCards();
        myFrame myFrame = new myFrame();
        myFrame.pack();
        players.player1.voucherAmounts[0]= 10;
        players.player1.voucherAmounts[1]= 10;
        players.player1.voucherAmounts[2]= 10;
        players.player1.voucherAmounts[3]= 10;
        players.player1.voucherAmounts[4]= 10;

        int response = 0;
        do{
            response= scanner.nextInt();
            if(response == 1){
                System.out.println(Arrays.toString(players.player1.coinAmounts));
                System.out.println(Arrays.toString(players.player1.voucherAmounts));
            }
        }while (response != 0);
    }
}
