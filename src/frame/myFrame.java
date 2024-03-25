package frame;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import static coinOwners.players.*;

import cards.cards;
import com.sun.security.jgss.InquireType;

import static colors.colors.*;

public class myFrame extends JFrame implements ActionListener {
    JButton shop = new JButton("Shop");
    JButton back = new JButton("Back");
    JButton back2 = new JButton("Back");
    JButton slot = new JButton("Slots");
    JButton confirm = new JButton("Confirm");

    JCheckBox RedBox = new JCheckBox();
    JCheckBox GreenBox = new JCheckBox();
    JCheckBox BlueBox = new JCheckBox();
    JCheckBox BlackBox = new JCheckBox();
    JCheckBox WhiteBox = new JCheckBox();
    JPanel backGround = new JPanel();
    JLayeredPane pane = new JLayeredPane();
    JLabel RedLabel = new JLabel();
    JLabel GreenLabel = new JLabel();
    JLabel BlueLabel = new JLabel();
    JLabel BlackLabel = new JLabel();
    JLabel WhiteLabel = new JLabel();

    public static ArrayList<JLayeredPane> lv1CardsBase= new ArrayList<>();
    public static ArrayList<JButton> buyButtons = new ArrayList<>();
    {
        for (int i = 0; i < 20; i++) {
           buyButtons.add(new JButton());
        }
    }
    public static ArrayList<JLayeredPane> lv2CardsBase= new ArrayList<>();
    public static ArrayList<JLayeredPane> lv3CardsBase= new ArrayList<>();
    public static ArrayList<JLayeredPane> lv0CardsBase= new ArrayList<>();
    public myFrame(){
        this.setPreferredSize(new Dimension(1920,1080));
        this.setLayout(null);
        this.setVisible(true);
        setResizable(false);
        this.setLocation(0,0);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        shop.setBounds(0,0,100,100);
        pane.add(shop , Integer.valueOf(0));
        pane.add(slot, Integer.valueOf(0));
        shop.addActionListener(this);
        confirm.addActionListener(this);
        back.addActionListener(this);
        back2.addActionListener(this);
        slot.addActionListener(this);
        back.setBounds(0,0,100,100);
        back2.setBounds(1805,0,100,100);
        confirm.setBounds(880,800,100,100);
        slot.setBounds(1805,0,100,100);
        pane.setBounds(0,0,1920,1080);
        this.add(pane);
    }
    int cardCount =0;
    public void drawCard(int XPos , int YPos , cards card , int level , int index ) {
        //makes card base
        JLayeredPane cardPane;
        if(level==1){
            if(lv1CardsBase.get(index) != null){
                pane.remove(lv1CardsBase.get(index));
                lv1CardsBase.set(index ,new JLayeredPane());
            }

            cardPane = lv1CardsBase.get(index);
        }
        else if(level==2){
            if(lv2CardsBase.get(index) != null)
                lv2CardsBase.set(index ,new JLayeredPane());
            cardPane = lv2CardsBase.get(index);
        }
        else if(level==3){
            if(lv3CardsBase.get(index) != null)
                lv3CardsBase.set(index ,new JLayeredPane());
            cardPane = lv3CardsBase.get(index);
        }
        else if(level==0){
            if(lv0CardsBase.get(index) != null)
                lv0CardsBase.set(index ,new JLayeredPane());
            cardPane = lv0CardsBase.get(index);
        }else cardPane=null;
        cardPane.setBounds(XPos, YPos, 200, 300);
        cardPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));
        //adds voucher icon
    if(!(card.voucher.isEmpty())){
        ImageIcon icon = null;
        for (int i = 0; i < colorList.size(); i++) {
            if (card.voucher.equals(colorList.get(i))) {
                icon = coinList.get(i);
                break;
            }
        }
        Image image = icon.getImage();
        Image newImg = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImg);
        JLabel voucher = new JLabel(icon);
        voucher.setBounds(150, 10, 40, 40);
        voucher.setOpaque(false);
        cardPane.add(voucher, Integer.valueOf(0));
    }
        //adds funValue
        JLabel funValue = new JLabel(((Integer) card.funValue).toString());
        funValue.setBounds(20,9,40,40);
        funValue.setOpaque(false);
        funValue.setFont(new Font("Calibre" , Font.PLAIN , 30));
        cardPane.add(funValue , Integer.valueOf(0));
        //add price
        ArrayList<JLabel> priceList= new ArrayList<>();
        int coinIndex = 0;
        for (int i = 0; i < card.cost.length; i++) {
          if(card.cost[i] != 0){
              ImageIcon icon1= coinList.get(i);
              Image image1 = icon1.getImage();
              Image newImg1 = image1.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH);
              icon1 = new ImageIcon(newImg1);
              priceList.add(new JLabel(icon1));
              priceList.getLast().setText(((Integer) card.cost[i]).toString());
              priceList.getLast().setHorizontalTextPosition(SwingConstants.CENTER);
              priceList.getLast().setVerticalTextPosition(SwingConstants.BOTTOM);
              priceList.getLast().setIconTextGap(0);
              priceList.getLast().setForeground(new Color(138, 138, 0));
              priceList.getLast().setBounds(150-(40*coinIndex),220,40,85);
              priceList.getLast().setFont(new Font("Calibre" , Font.BOLD , 20));
              cardPane.add(priceList.getLast());
              coinIndex++;
          }

        }
        //add buttons
        if(card.ownedBy.equals("bank")){
            JButton buy=new JButton("Buy");
            buy.setBounds(20,100,70,70);
            cardPane.add(buy);
            buy.addActionListener(this);
            buyButtons.set((level*4)+index,buy);
        }
        //final addition
            pane.add(cardPane, 2,-1);

    }
    public void drawShop(){
        backGround.setBounds(0,0,1920,1080);
        backGround.setBackground(Color.white);
        pane.add(backGround , Integer.valueOf(1));
        pane.add(back,Integer.valueOf(2));
        drawCard(500,25,cards.lv1CardsOnDeck.get(0) ,1,0);
        drawCard(725,25,cards.lv1CardsOnDeck.get(1) ,1,1);
        drawCard(950,25,cards.lv1CardsOnDeck.get(2) ,1,2);
        drawCard(1175,25,cards.lv1CardsOnDeck.get(3) ,1,3);
        drawCard(500,375,cards.lv2CardsOnDeck.get(0) ,2,0);
        drawCard(725,375,cards.lv2CardsOnDeck.get(1) ,2,1);
        drawCard(950,375,cards.lv2CardsOnDeck.get(2) ,2,2);
        drawCard(1175,375,cards.lv2CardsOnDeck.get(3) ,2,3);
    drawCard(500,725,cards.lv3CardsOnDeck.get(0) ,3,0);
    drawCard(725,725,cards.lv3CardsOnDeck.get(1) ,3,1);
    drawCard(950,725,cards.lv3CardsOnDeck.get(2) ,3,2);
    drawCard(1175,725,cards.lv3CardsOnDeck.get(3) ,3,3);
}
    public void drawSlots(){
        backGround.setBounds(0,0,1920,1080);
        backGround.setBackground(Color.white);
        pane.add(backGround , Integer.valueOf(1));
        ImageIcon Red = slotList.get(0);
        Image image1 = Red.getImage();
        Image newImg1 = image1.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
        Red = new ImageIcon(newImg1);
        RedLabel = new JLabel(Red);
        RedLabel.setBounds(325,425,200,200);
        RedBox = new JCheckBox();
        RedBox.setBounds(390,650,20,20);
        pane.add(RedBox , Integer.valueOf(2));
        pane.add(RedLabel , Integer.valueOf(2));
        ImageIcon Green = slotList.get(1);
        Image image2 = Green.getImage();
        Image newImg2 = image2.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
        Green = new ImageIcon(newImg2);
        GreenLabel = new JLabel(Green);
        GreenLabel.setBounds(575,425,200,200);
        GreenBox = new JCheckBox();
        GreenBox.setBounds(640,650,20,20);
        pane.add(GreenBox , Integer.valueOf(2));
        pane.add(GreenLabel , Integer.valueOf(2));
        ImageIcon Blue = slotList.get(2);
        Image image3 = Blue.getImage();
        Image newImg3 = image3.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
        Blue = new ImageIcon(newImg3);
        BlueLabel = new JLabel(Blue);
        BlueLabel.setBounds(825,425,200,200);
        BlueBox = new JCheckBox();
        BlueBox.setBounds(890,650,20,20);
        pane.add(BlueBox , Integer.valueOf(2));
        pane.add(BlueLabel , Integer.valueOf(2));
        ImageIcon Black = slotList.get(3);
        Image image4 = Black.getImage();
        Image newImg4 = image4.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
        Black = new ImageIcon(newImg4);
        BlackLabel = new JLabel(Black);
        BlackBox = new JCheckBox();
        BlackBox.setBounds(1140,650,20,20);
        pane.add(BlackBox , Integer.valueOf(2));
        BlackLabel.setBounds(1075,425,200,200);
        pane.add(BlackLabel , Integer.valueOf(2));
        ImageIcon White = slotList.get(4);
        Image image5 = White.getImage();
        Image newImg5 = image5.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
        White = new ImageIcon(newImg5);
        WhiteLabel = new JLabel(White);
        WhiteBox = new JCheckBox();
        WhiteBox.setBounds(1390,650,20,20);
        pane.add(WhiteBox , Integer.valueOf(2));
        WhiteLabel.setBounds(1325,425,200,200);
        pane.add(WhiteLabel , Integer.valueOf(2));
        pane.add(back2 ,Integer.valueOf(2));
        pane.add(confirm,Integer.valueOf(2));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(shop)) {
            drawShop();
            pane.repaint();
        }
        else if(e.getSource().equals(back)){
            goBack();
        }
        else if(e.getSource().equals(back2)){
            goBack2();
        }
        else if(e.getSource().equals(slot)){
            drawSlots();
            pane.repaint();
        }
        else if(e.getSource().equals(confirm)){
            int buttonsActive = 0;
            int[] checkArray = {0,0,0,0,0};
            if(RedBox.isSelected()){
                buttonsActive++;
                checkArray[0] = 1;
            }
            if(GreenBox.isSelected()){
                buttonsActive++;
                checkArray[1] = 1;
            }
            if(BlueBox.isSelected()){
                buttonsActive++;
                checkArray[2] = 1;
            }
            if(BlackBox.isSelected()){
                buttonsActive++;
                checkArray[3] = 1;
            }
            if(WhiteBox.isSelected()){
                buttonsActive++;
                checkArray[4] = 1;
            }
            System.out.println(Arrays.toString(checkArray));
            if(buttonsActive == 1){
                for (int i = 0; i < 5; i++) {
                    if(checkArray[i] == 1){
                        player1.takeFromSlotMachine(i);
                        goBack2();
                        break;
                    }
                }
            }
            else if(buttonsActive == 3){
                int input1=0;
                int input2=0;
                int input3=0;
                    for (int i = 0; i < 5; i++) {
                        if (checkArray[i] == 1) {
                            input1 = i;
                            break;
                        }
                    }
                    for (int i = input1+1; i < 5; i++) {
                    if (checkArray[i] == 1) {
                        input2 = i;
                        break;
                    }
                }
                for (int i = input2+1; i < 5; i++) {
                    if (checkArray[i] == 1) {
                        input3 = i;
                        break;
                    }
                }
                player1.takeFromSlotMachine(input1,input2,input3);
                goBack2();
            }

        }
        else for (int i = 4; i < 16; i++) {
            if(e.getSource().equals(buyButtons.get(i))){
                if(player1.buyCard(i/4,i%4)==0) {
                    goBack();
                }
            }
        }



    }

    private void goBack() {
        pane.remove(lv1CardsBase.get(0));
        pane.remove(lv1CardsBase.get(1));
        pane.remove(lv1CardsBase.get(2));
        pane.remove(lv1CardsBase.get(3));
        pane.remove(lv2CardsBase.get(0));
        pane.remove(lv2CardsBase.get(1));
        pane.remove(lv2CardsBase.get(2));
        pane.remove(lv2CardsBase.get(3));
        pane.remove(lv3CardsBase.get(0));
        pane.remove(lv3CardsBase.get(1));
        pane.remove(lv3CardsBase.get(2));
        pane.remove(lv3CardsBase.get(3));
        pane.remove(backGround);
        pane.remove(back);
        pane.repaint();
    }

    private void goBack2() {
        pane.remove(RedLabel);
        pane.remove(GreenLabel);
        pane.remove(BlueLabel);
        pane.remove(BlackLabel);
        pane.remove(WhiteLabel);
        pane.remove(backGround);
        pane.remove(back2);
        pane.remove(RedBox);
        pane.remove(GreenBox);
        pane.remove(BlueBox);
        pane.remove(BlackBox);
        pane.remove(WhiteBox);
        pane.remove(confirm);
        pane.repaint();
    }
}