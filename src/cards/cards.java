package cards;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static colors.colors.*;
import static frame.myFrame.*;

public class cards {
    public static ArrayList<cards> lv1CardsOnDeck= new ArrayList<>();
    public static ArrayList<cards> lv2CardsOnDeck= new ArrayList<>();
    public static ArrayList<cards> lv3CardsOnDeck= new ArrayList<>();
    public static ArrayList<cards> lv0CardsOnDeck= new ArrayList<>();
    public int level;
    public int funValue;
    public String ownedBy;
    public String voucher;
    public int[] cost = new int[5];
    public cards(int level){
        ownedBy = "bank";
        Random random = new Random();
        this.level =level;
        if(level != 0)
            this.voucher = colorList.get(random.nextInt(5));
        else
            this.voucher = "";
        if(level == 1){
            this.funValue= random.nextInt(2);
            giveCost(4 ,6);
        }
        if(level == 2){
            this.funValue= random.nextInt(2,5);
            giveCost(6 ,8);
        }
        if(level == 3){
            this.funValue= random.nextInt(3,6);
              giveCost(7 ,10);
        }
        if(level == 0){
            this.funValue= random.nextInt(3,5);
            giveCost(8 ,12);
        }




    }
    public int giveCost(int totalB,int totalE){
        Random random = new Random();
        int total= random.nextInt(totalE-totalB+1)+totalB;
        int totalPerm= total;
        for (int i = 0; total != 0; i++) {
            if(i == 4){
                this.cost[4] += total;
                total = 0;
            }else {
                int j= random.nextInt(5);
                if(cost[j] == 0){
                    this.cost[j]= random.nextInt(total+1);
                    total -=this.cost[j];
                }
            }
        }
        return totalPerm;
    }

    public static void makeFirstCards(){
        lv1CardsOnDeck.add(new cards(1));
        lv1CardsOnDeck.add(new cards(1));
        lv1CardsOnDeck.add(new cards(1));
        lv1CardsOnDeck.add(new cards(1));
        lv2CardsOnDeck.add(new cards(2));
        lv2CardsOnDeck.add(new cards(2));
        lv2CardsOnDeck.add(new cards(2));
        lv2CardsOnDeck.add(new cards(2));
        lv3CardsOnDeck.add(new cards(3));
        lv3CardsOnDeck.add(new cards(3));
        lv3CardsOnDeck.add(new cards(3));
        lv3CardsOnDeck.add(new cards(3));
        lv0CardsOnDeck.add(new cards(0));
        lv0CardsOnDeck.add(new cards(0));
        lv0CardsOnDeck.add(new cards(0));
        lv1CardsBase.add(new JLayeredPane());
        lv1CardsBase.add(new JLayeredPane());
        lv1CardsBase.add(new JLayeredPane());
        lv1CardsBase.add(new JLayeredPane());
        lv2CardsBase.add(new JLayeredPane());
        lv2CardsBase.add(new JLayeredPane());
        lv2CardsBase.add(new JLayeredPane());
        lv2CardsBase.add(new JLayeredPane());
        lv3CardsBase.add(new JLayeredPane());
        lv3CardsBase.add(new JLayeredPane());
        lv3CardsBase.add(new JLayeredPane());
        lv3CardsBase.add(new JLayeredPane());
        lv0CardsBase.add(new JLayeredPane());
        lv0CardsBase.add(new JLayeredPane());
        lv0CardsBase.add(new JLayeredPane());
    }

}
