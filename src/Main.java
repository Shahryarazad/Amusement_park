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
        int response = 0;
        do{
            System.out.println(Arrays.toString(players.player1.coinAmounts));
            System.out.println("what do you want to do?\n" +"1:buyCard   2:reserveCard   3:getCoins 4:getVoucher  ");
            response= scanner.nextInt();
            if(response == 1){
                System.out.println("enter level and index");
                int level=scanner.nextInt();
                int index=scanner.nextInt();
                System.out.println(Arrays.toString(players.player1.coinAmounts) + "coin before");
                System.out.println(Arrays.toString(players.player1.voucherAmounts) + "voucher before");
                System.out.println(Arrays.toString(cards.lv1CardsOnDeck.get(index).cost) + "cost");
                players.player1.buyCard(level, index);
                System.out.println(Arrays.toString(players.player1.coinAmounts) + "coin after");
                System.out.println(Arrays.toString(players.player1.voucherAmounts)+ "voucher after");
            }
            if(response == 2){
                System.out.println("enter level and index");
                players.player1.reserveCard(scanner.nextInt(), scanner.nextInt());
                System.out.println(Arrays.toString(players.player1.coinAmounts));

            }
            if(response == 3){
                System.out.println("enter amount and color");
                players.player1.giveCoins(scanner.nextInt() , scanner.next());
                System.out.println(Arrays.toString(players.player1.coinAmounts));

            }
            if(response == 4){
                System.out.println("enter amount and color");
                players.player1.giveVoucher(scanner.nextInt(),scanner.next());
                System.out.println(Arrays.toString(players.player1.coinAmounts));

            }

        }while (response != 0);
    }
}
