package coinOwners;
import java.util.ArrayList;
import cards.cards;

import static colors.colors.*;
public class players {

     public int[] coinAmounts = {0, 0, 0, 0, 0, 0};
     public int[] voucherAmounts = {0, 0, 0, 0, 0};
     public ArrayList<cards> ownedCards= new ArrayList<>();
     public ArrayList<cards> reservedCards= new ArrayList<>();
     public static players player1 = new players();
     public static players player2 = new players();
     public static int turn=1;
     public void giveCoins(int amount , String color){
          for (int i = 0; i < colorList.size() ; i++) {
               if(color.equals(colorList.get(i))) {
                    this.coinAmounts[i] += amount;
                    break;
               }
          }
     }
     public int getCoinAmount(String color){
          for (int i = 0; i < colorList.size() ; i++) {
               if(color.equals(colorList.get(i))) {
                   return coinAmounts[i];
               }
          }
          return -1;
     }
     public void giveVoucher(int amount , String color){
          if(color.equals("Red"))
               this.voucherAmounts[0] +=amount;
          if(color.equals("Green"))
               this.voucherAmounts[1] +=amount;
          if(color.equals("Blue"))
               this.voucherAmounts[2] +=amount;
          if(color.equals("Black"))
               this.voucherAmounts[3] +=amount;
          if(color.equals("White"))
               this.voucherAmounts[4] +=amount;
          if(color.equals("Gold"))
               this.voucherAmounts[5] +=amount;

     }
     public int getVoucherAmount(String color){
          if(color.equals("Red"))
               return voucherAmounts[0];
          if(color.equals("Green"))
               return voucherAmounts[1];
          if(color.equals("Blue"))
               return voucherAmounts[2];
          if(color.equals("Black"))
               return voucherAmounts[3];
          if(color.equals("White"))
               return voucherAmounts[4];
          if(color.equals("Gold"))
               return voucherAmounts[5];
          else return -1;

     }
     public void takeFromSlotMachine(int machineNum){
               switch (machineNum){
                    case 0-> slotMachines.Red.coinAmount -=2;
                    case 1-> slotMachines.Green.coinAmount -=2;
                    case 2-> slotMachines.Blue.coinAmount -=2;
                    case 3-> slotMachines.Black.coinAmount -=2;
                    case 4-> slotMachines.White.coinAmount -=2;
                    case 5-> slotMachines.Bank.coinAmount -=2;

               }
               this.coinAmounts[machineNum] +=2;
     }
     public void takeFromSlotMachine(int machineNum1 , int machineNum2, int machineNum3){
          switch (machineNum1-1){
               case 1-> slotMachines.Red.coinAmount -=1;
               case 2-> slotMachines.Green.coinAmount -=1;
               case 3-> slotMachines.Blue.coinAmount -=1;
               case 4-> slotMachines.Black.coinAmount -=1;
               case 5-> slotMachines.White.coinAmount -=1;
               case 6-> slotMachines.Bank.coinAmount -=1;
          }
          switch (machineNum2-1){
               case 1-> slotMachines.Red.coinAmount -=1;
               case 2-> slotMachines.Green.coinAmount -=1;
               case 3-> slotMachines.Blue.coinAmount -=1;
               case 4-> slotMachines.Black.coinAmount -=1;
               case 5-> slotMachines.White.coinAmount -=1;
               case 6-> slotMachines.Bank.coinAmount -=1;
          }
          switch (machineNum3-1){
               case 1-> slotMachines.Red.coinAmount -=1;
               case 2-> slotMachines.Green.coinAmount -=1;
               case 3-> slotMachines.Blue.coinAmount -=1;
               case 4-> slotMachines.Black.coinAmount -=1;
               case 5-> slotMachines.White.coinAmount -=1;
               case 6-> slotMachines.Bank.coinAmount -=1;
          }
          this.coinAmounts[machineNum1] +=1;
          this.coinAmounts[machineNum2] +=1;
          this.coinAmounts[machineNum3] +=1;

     }
     public int buyCard(int level , int index) {
          if (level == 1) {
               int extraNeeded = 0;
               for (int i = 0; i < cards.lv1CardsOnDeck.get(index).cost.length; i++) {
                    if (cards.lv1CardsOnDeck.get(index).cost[i] - this.voucherAmounts[i] - this.coinAmounts[i] > 0)
                         extraNeeded += cards.lv1CardsOnDeck.get(index).cost[i] - this.voucherAmounts[i] - this.coinAmounts[i];
               }
               if (this.coinAmounts[5] >= extraNeeded) {
                    this.coinAmounts[5] -= extraNeeded;
                    for (int i = 0; i < cards.lv1CardsOnDeck.get(index).cost.length; i++) {
                         if(cards.lv1CardsOnDeck.get(index).cost[i] > this.voucherAmounts[i])
                              this.coinAmounts[i] -= cards.lv1CardsOnDeck.get(index).cost[i] - this.voucherAmounts[i];
                         if (this.coinAmounts[i] < 0)
                              this.coinAmounts[i] = 0;
                    }
                    this.ownedCards.add(cards.lv1CardsOnDeck.get(index));
                    if(this == player1)
                         cards.lv1CardsOnDeck.get(index).ownedBy = "1";
                    else if(this == player2)
                         cards.lv1CardsOnDeck.get(index).ownedBy = "2";
                    for (int i = 0; i < 5; i++) {
                         if(cards.lv1CardsOnDeck.get(index).voucher.equals(colorList.get(i)))
                              this.voucherAmounts[i]++;
                    }
                    cards.lv1CardsOnDeck.remove(index);
                    cards.lv1CardsOnDeck.add(index, new cards(level));
               } else
                    return -1;
          }
          else if (level == 2) {
               int extraNeeded = 0;
               for (int i = 0; i < cards.lv2CardsOnDeck.get(index).cost.length; i++) {
                    if (cards.lv2CardsOnDeck.get(index).cost[i] - this.voucherAmounts[i] - this.coinAmounts[i] > 0)
                         extraNeeded += cards.lv2CardsOnDeck.get(index).cost[i] - this.voucherAmounts[i] - this.coinAmounts[i];
               }
               if (this.coinAmounts[5] >= extraNeeded) {
                    this.coinAmounts[5] -= extraNeeded;
                    for (int i = 0; i < cards.lv2CardsOnDeck.get(index).cost.length; i++) {
                         if(cards.lv2CardsOnDeck.get(index).cost[i] > this.voucherAmounts[i])
                              this.coinAmounts[i] -= cards.lv2CardsOnDeck.get(index).cost[i] - this.voucherAmounts[i];
                         if (this.coinAmounts[i] < 0)
                              this.coinAmounts[i] = 0;
                    }
                    this.ownedCards.add(cards.lv2CardsOnDeck.get(index));
                    if(this == player1)
                         cards.lv1CardsOnDeck.get(index).ownedBy = "1";
                    else if(this == player2)
                         cards.lv1CardsOnDeck.get(index).ownedBy = "2";
                    for (int i = 0; i < 5; i++) {
                         if(cards.lv1CardsOnDeck.get(index).voucher.equals(colorList.get(i)))
                              this.voucherAmounts[i]++;
                    }
                    cards.lv2CardsOnDeck.remove(index);
                    cards.lv2CardsOnDeck.add(index, new cards(level));
               } else
                    return -1;
          }
          else if (level == 3) {
               int extraNeeded = 0;
               for (int i = 0; i < cards.lv3CardsOnDeck.get(index).cost.length; i++) {
                    if (cards.lv3CardsOnDeck.get(index).cost[i] - this.voucherAmounts[i] - this.coinAmounts[i] > 0)
                         extraNeeded += cards.lv3CardsOnDeck.get(index).cost[i] - this.voucherAmounts[i] - this.coinAmounts[i];
               }
               if (this.coinAmounts[5] >= extraNeeded) {
                    this.coinAmounts[5] -= extraNeeded;
                    for (int i = 0; i < cards.lv3CardsOnDeck.get(index).cost.length; i++) {
                         if(cards.lv3CardsOnDeck.get(index).cost[i] > this.voucherAmounts[i])
                              this.coinAmounts[i] -= cards.lv3CardsOnDeck.get(index).cost[i] - this.voucherAmounts[i];
                         if (this.coinAmounts[i] < 0)
                              this.coinAmounts[i] = 0;
                    }
                    this.ownedCards.add(cards.lv3CardsOnDeck.get(index));
                    if(this == player1)
                         cards.lv1CardsOnDeck.get(index).ownedBy = "1";
                    else if(this == player2)
                         cards.lv1CardsOnDeck.get(index).ownedBy = "2";
                    for (int i = 0; i < 5; i++) {
                         if(cards.lv1CardsOnDeck.get(index).voucher.equals(colorList.get(i)))
                              this.voucherAmounts[i]++;
                    }
                    cards.lv3CardsOnDeck.remove(index);
                    cards.lv3CardsOnDeck.add(index, new cards(level));
               } else
                    return -1;
          }
          else if (level == 0) {
               int checker = 0;
               for (int i = 0; i < this.voucherAmounts.length; i++) {
                    if (this.voucherAmounts[i] >= cards.lv0CardsOnDeck.get(index).cost[i])
                         checker++;
               }
               if (checker == this.voucherAmounts.length) {
                    this.ownedCards.add(cards.lv0CardsOnDeck.get(index));
                    if(this == player1)
                         cards.lv1CardsOnDeck.get(index).ownedBy = "1";
                    else if(this == player2)
                         cards.lv1CardsOnDeck.get(index).ownedBy = "2";
                    cards.lv0CardsOnDeck.remove(index);
               } else
                    return -1;
          }
          return 0;
     }
     public void reserveCard(int level , int index){
          if (level == 1) {
               this.reservedCards.add(cards.lv1CardsOnDeck.get(index));
               cards.lv1CardsOnDeck.remove(index);
               cards.lv1CardsOnDeck.add(index, new cards(level));
          }
          if (level == 2) {
               this.reservedCards.add(cards.lv2CardsOnDeck.get(index));
               cards.lv2CardsOnDeck.remove(index);
               cards.lv2CardsOnDeck.add(index, new cards(level));
          }
          if (level == 3) {
               this.reservedCards.add(cards.lv3CardsOnDeck.get(index));
               cards.lv3CardsOnDeck.remove(index);
               cards.lv3CardsOnDeck.add(index, new cards(level));
          }
     }
}
