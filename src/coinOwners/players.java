package coinOwners;
import java.util.ArrayList;
import java.util.List;

import cards.cards;
import frame.myFrame;
import javax.swing.*;

import static colors.colors.*;
public class players {

     public int[] coinAmounts = {0, 0, 0, 0, 0, 0};
     public int[] voucherAmounts = {0, 0, 0, 0, 0};
     public int score =0;
     public ArrayList<cards> ownedCards= new ArrayList<>();
     public ArrayList<cards> reservedCards= new ArrayList<>();
     public ArrayList<JLayeredPane> reservedCardsBase= new ArrayList<>(List.of(new JLayeredPane() ,new JLayeredPane(),new JLayeredPane()));
     public static players player1 = new players();
     public static players player2 = new players();
     public static int turn=1;
     public boolean takeFromSlotMachine(int machineNum){
          boolean allowed =true;
               switch (machineNum){
                    case 0:
                         if(slotMachines.Red.coinAmount>=2)
                              slotMachines.Red.coinAmount -=2;
                         else allowed = false;
                         break;
                    case 1:
                         if(slotMachines.Green.coinAmount >=2)
                              slotMachines.Green.coinAmount -=2;
                         else allowed = false;
                         break;
                    case 2:
                         if(slotMachines.Blue.coinAmount >=2)
                              slotMachines.Blue.coinAmount -=2;
                         else allowed = false;
                         break;
                    case 3:
                         if(slotMachines.Black.coinAmount >=2)
                              slotMachines.Black.coinAmount -=2;
                         else allowed = false;
                         break;
                    case 4:
                         if(slotMachines.White.coinAmount >=2)
                              slotMachines.White.coinAmount -=2;
                         else allowed = false;
                         break;
               }
               if(allowed)
                    this.coinAmounts[machineNum] +=2;
               return allowed;
     }
     public boolean takeFromSlotMachine(int machineNum1 , int machineNum2, int machineNum3){
          boolean allowed =true;
          switch (machineNum1+1){
               case 1:
                    if(slotMachines.Red.coinAmount >=1)
                         slotMachines.Red.coinAmount -=1;
                    else allowed =false;
                    break;
               case 2:
                    if(slotMachines.Green.coinAmount >=1)
                         slotMachines.Green.coinAmount -=1;
                    else allowed =false;
                    break;
               case 3:
                    if(slotMachines.Blue.coinAmount >=1)
                         slotMachines.Blue.coinAmount -=1;
                    else allowed =false;
                    break;
               case 4:
                    if(slotMachines.Black.coinAmount >=1)
                         slotMachines.Black.coinAmount -=1;
                    else allowed =false;
                    break;
               case 5:
                    if(slotMachines.White.coinAmount >=1)
                         slotMachines.White.coinAmount -=1;
                    else allowed =false;
                    break;
          }
          if(allowed) {
               switch (machineNum2 + 1) {
                    case 1:
                         if (slotMachines.Red.coinAmount >= 1)
                              slotMachines.Red.coinAmount -= 1;
                         else allowed = false;
                         break;
                    case 2:
                         if (slotMachines.Green.coinAmount >= 1)
                              slotMachines.Green.coinAmount -= 1;
                         else allowed = false;
                         break;
                    case 3:
                         if (slotMachines.Blue.coinAmount >= 1)
                              slotMachines.Blue.coinAmount -= 1;
                         else allowed = false;
                         break;
                    case 4:
                         if (slotMachines.Black.coinAmount >= 1)
                              slotMachines.Black.coinAmount -= 1;
                         else allowed = false;
                         break;
                    case 5:
                         if (slotMachines.White.coinAmount >= 1)
                              slotMachines.White.coinAmount -= 1;
                         else allowed = false;
                         break;
               }
          }
          if(allowed) {
               switch (machineNum3 + 1) {
                    case 1:
                         if (slotMachines.Red.coinAmount >= 1)
                              slotMachines.Red.coinAmount -= 1;
                         else allowed = false;
                         break;
                    case 2:
                         if (slotMachines.Green.coinAmount >= 1)
                              slotMachines.Green.coinAmount -= 1;
                         else allowed = false;
                         break;
                    case 3:
                         if (slotMachines.Blue.coinAmount >= 1)
                              slotMachines.Blue.coinAmount -= 1;
                         else allowed = false;
                         break;
                    case 4:
                         if (slotMachines.Black.coinAmount >= 1)
                              slotMachines.Black.coinAmount -= 1;
                         else allowed = false;
                         break;
                    case 5:
                         if (slotMachines.White.coinAmount >= 1)
                              slotMachines.White.coinAmount -= 1;
                         else allowed = false;
                         break;
               }
          }
          if(allowed) {
               this.coinAmounts[machineNum1] += 1;
               this.coinAmounts[machineNum2] += 1;
               this.coinAmounts[machineNum3] += 1;
          }
          return allowed;
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
                    slotMachines.Bank.coinAmount+=extraNeeded;
                    for (int i = 0; i < cards.lv1CardsOnDeck.get(index).cost.length; i++) {
                         if(cards.lv1CardsOnDeck.get(index).cost[i] > this.voucherAmounts[i])
                              this.coinAmounts[i] -= cards.lv1CardsOnDeck.get(index).cost[i] - this.voucherAmounts[i];
                         if (this.coinAmounts[i] < 0)
                              this.coinAmounts[i] = 0;
                    }
                    this.ownedCards.add(cards.lv1CardsOnDeck.get(index));
                    this.score+= cards.lv1CardsOnDeck.get(index).funValue;
                    if(this == player1) {
                         cards.lv1CardsOnDeck.get(index).ownedBy = "1";
                         player1.voucherAmounts[colorList.indexOf(cards.lv1CardsOnDeck.get(index).voucher)]++;
                    }
                    else if(this == player2){
                         cards.lv1CardsOnDeck.get(index).ownedBy = "2";
                         player2.voucherAmounts[colorList.indexOf(cards.lv1CardsOnDeck.get(index).voucher)]++;
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
                    slotMachines.Bank.coinAmount+=extraNeeded;
                    for (int i = 0; i < cards.lv2CardsOnDeck.get(index).cost.length; i++) {
                         if(cards.lv2CardsOnDeck.get(index).cost[i] > this.voucherAmounts[i])
                              this.coinAmounts[i] -= cards.lv2CardsOnDeck.get(index).cost[i] - this.voucherAmounts[i];
                         if (this.coinAmounts[i] < 0)
                              this.coinAmounts[i] = 0;
                    }
                    this.ownedCards.add(cards.lv2CardsOnDeck.get(index));
                    this.score+= cards.lv2CardsOnDeck.get(index).funValue;
                    if(this == player1) {
                         cards.lv2CardsOnDeck.get(index).ownedBy = "1";
                         player1.voucherAmounts[colorList.indexOf(cards.lv2CardsOnDeck.get(index).voucher)]++;
                    }
                    else if(this == player2) {
                         cards.lv2CardsOnDeck.get(index).ownedBy = "2";
                         player2.voucherAmounts[colorList.indexOf(cards.lv2CardsOnDeck.get(index).voucher)]++;
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
                    slotMachines.Bank.coinAmount += extraNeeded;
                    for (int i = 0; i < cards.lv3CardsOnDeck.get(index).cost.length; i++) {
                         if (cards.lv3CardsOnDeck.get(index).cost[i] > this.voucherAmounts[i])
                              this.coinAmounts[i] -= cards.lv3CardsOnDeck.get(index).cost[i] - this.voucherAmounts[i];
                         if (this.coinAmounts[i] < 0)
                              this.coinAmounts[i] = 0;
                    }
                    this.ownedCards.add(cards.lv3CardsOnDeck.get(index));
                    this.score+= cards.lv3CardsOnDeck.get(index).funValue;
                    if (this == player1) {
                         cards.lv3CardsOnDeck.get(index).ownedBy = "1";
                         player1.voucherAmounts[colorList.indexOf(cards.lv3CardsOnDeck.get(index).voucher)]++;
                    } else if (this == player2){
                         cards.lv3CardsOnDeck.get(index).ownedBy = "2";
                    player2.voucherAmounts[colorList.indexOf(cards.lv3CardsOnDeck.get(index).voucher)]++;
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
                    this.score+= cards.lv0CardsOnDeck.get(index).funValue;
                    if(this == player1)
                         cards.lv0CardsOnDeck.get(index).ownedBy = "1";
                    else if(this == player2)
                         cards.lv0CardsOnDeck.get(index).ownedBy = "2";
                    cards.lv0CardsOnDeck.remove(index);
               } else
                    return -1;
          }
          return 0;
     }
     public int buyCard(int index) {
          int extraNeeded = 0;
          for (int i = 0; i < this.reservedCards.get(index).cost.length; i++) {
                    if (this.reservedCards.get(index).cost[i] - this.voucherAmounts[i] - this.coinAmounts[i] > 0)
                         extraNeeded += this.reservedCards.get(index).cost[i] - this.voucherAmounts[i] - this.coinAmounts[i];
          }
          if (this.coinAmounts[5] >= extraNeeded) {
               this.coinAmounts[5] -= extraNeeded;
               slotMachines.Bank.coinAmount+=extraNeeded;
               for (int i = 0; i < this.reservedCards.get(index).cost.length; i++) {
                    if(this.reservedCards.get(index).cost[i] > this.voucherAmounts[i])
                         this.coinAmounts[i] -= this.reservedCards.get(index).cost[i] - this.voucherAmounts[i];
                    if (this.coinAmounts[i] < 0)
                         this.coinAmounts[i] = 0;
                    }
               this.ownedCards.add(this.reservedCards.get(index));
               this.score+= this.reservedCards.get(index).funValue;
                    if(this == player1) {
                         this.reservedCards.get(index).ownedBy = "1";
                         player1.voucherAmounts[colorList.indexOf(reservedCards.get(index).voucher)]++;
                    }
                    else if(this == player2) {
                         this.reservedCards.get(index).ownedBy = "2";
                         player2.voucherAmounts[colorList.indexOf(reservedCards.get(index).voucher)]++;
                    }
               this.reservedCards.remove(index);
               } else
                    return -1;

          return 0;
     }
     public int reserveCard(int level , int index){
          if (level == 1 && this.reservedCards.size()<=2) {
               this.reservedCards.add(cards.lv1CardsOnDeck.get(index));
               if(this == player1)
                    cards.lv1CardsOnDeck.get(index).reservedBy = "1";
               else if(this == player2)
                    cards.lv1CardsOnDeck.get(index).reservedBy = "2";
               cards.lv1CardsOnDeck.remove(index);
               cards.lv1CardsOnDeck.add(index, new cards(level));
               if(slotMachines.Bank.coinAmount>=1) {
                    slotMachines.Bank.coinAmount--;
                    this.coinAmounts[5]++;
               }
               return 0;
          }
          else if (level == 2 && this.reservedCards.size()<=2) {
               this.reservedCards.add(cards.lv2CardsOnDeck.get(index));
               if(this == player1)
                    cards.lv2CardsOnDeck.get(index).reservedBy = "1";
               else if(this == player2)
                    cards.lv2CardsOnDeck.get(index).reservedBy = "2";
               cards.lv2CardsOnDeck.remove(index);
               cards.lv2CardsOnDeck.add(index, new cards(level));
               if(slotMachines.Bank.coinAmount>=1) {
                    slotMachines.Bank.coinAmount--;
                    this.coinAmounts[5]++;
               }
               return 0;
          }
          else if (level == 3 && this.reservedCards.size()<=2) {
               this.reservedCards.add(cards.lv3CardsOnDeck.get(index));
               if(this == player1)
                    cards.lv3CardsOnDeck.get(index).reservedBy = "1";
               else if(this == player2)
                    cards.lv3CardsOnDeck.get(index).reservedBy = "2";
               cards.lv3CardsOnDeck.remove(index);
               cards.lv3CardsOnDeck.add(index, new cards(level));
               if(slotMachines.Bank.coinAmount>=1) {
                    slotMachines.Bank.coinAmount--;
                    this.coinAmounts[5]++;
               }
               return 0;
          }else return -1;
     }
}
