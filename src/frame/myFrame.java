package frame;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import static coinOwners.players.*;
import coinOwners.players;
import static coinOwners.slotMachines.*;

import cards.cards;
import static cards.cards.*;

import coinOwners.slotMachines;
import com.sun.security.jgss.InquireType;

import static colors.colors.*;

public class myFrame extends JFrame implements ActionListener {
    boolean menuIsUp = false;
    JButton shop = new JButton("Shop");
    JButton back = new JButton("Back");
    JButton back2 = new JButton("Back");
    JButton slot = new JButton("Slots");
    JButton confirm = new JButton("Confirm");
    JButton back3 = new JButton("Back");
    JButton Reserved = new JButton("Reserved Cards");
    JButton menuButton = new JButton();


    JCheckBox RedBox = new JCheckBox();
    JCheckBox GreenBox = new JCheckBox();
    JCheckBox BlueBox = new JCheckBox();
    JCheckBox BlackBox = new JCheckBox();
    JCheckBox WhiteBox = new JCheckBox();
    JPanel backGround = new JPanel();
    JPanel backGround2 = new JPanel();

    JLayeredPane pane = new JLayeredPane();
    JLabel RedLabel = new JLabel();
    JLabel GreenLabel = new JLabel();
    JLabel BlueLabel = new JLabel();
    JLabel BlackLabel = new JLabel();
    JLabel WhiteLabel = new JLabel();
    JLabel GoldLabel = new JLabel();

    public JTextField turnDisplay = new JTextField("Player1");
    public JTextField coinAmountDisplay1 = new JTextField(Arrays.toString(player1.coinAmounts)+"P1:"+player1.score);
    public JTextField voucherAmountDisplay1 = new JTextField(Arrays.toString(player1.voucherAmounts)+"P1");
    public JTextField coinAmountDisplay2 = new JTextField(Arrays.toString(player2.coinAmounts)+"P2:"+player2.score);
    public JTextField voucherAmountDisplay2 = new JTextField(Arrays.toString(player2.voucherAmounts)+"P2");
    JTextField RedAmount = new JTextField();
    JTextField GreenAmount = new JTextField();
    JTextField BlueAmount = new JTextField();
    JTextField BlackAmount = new JTextField();
    JTextField WhiteAmount = new JTextField();
    JTextField GoldAmount = new JTextField();

    public static ArrayList<JLayeredPane> lv1CardsBase= new ArrayList<>();
    public static ArrayList<JLayeredPane> lv2CardsBase= new ArrayList<>();
    public static ArrayList<JLayeredPane> lv3CardsBase= new ArrayList<>();
    public static ArrayList<JLayeredPane> lv0CardsBase= new ArrayList<>();
    public static ArrayList<JButton> buyButtons = new ArrayList<>();
    public static ArrayList<JButton> reserveButtons = new ArrayList<>();

    {
        for (int i = 0; i < 30; i++) {
            buyButtons.add(new JButton());
            reserveButtons.add(new JButton());
        }
    }
    public myFrame(){
        //set up frame
        this.setUndecorated(true);
        this.setPreferredSize(new Dimension(1920,1080));
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocation(0,0);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setAlwaysOnTop(true);
        this.setTitle("Amusement-Park");
        //add menu button
        ImageIcon menuPic = new ImageIcon("arrows.png");
        menuPic = resize(menuPic , 1000,100);
        menuButton = new JButton(menuPic);
        menuButton.setOpaque(false);
        menuButton.setBackground(new Color(0, 0, 0));
        menuButton.setContentAreaFilled(false);
        menuButton.setBorder(new LineBorder(new Color(0,0,0),7,true));
        menuButton.setBounds(450,940,1000,100);
        menuButton.addActionListener(this);
        pane.add(menuButton ,Integer.valueOf(-1));
        //add turn info
        turnDisplay.setBounds(850,10,200,100);
        turnDisplay.setOpaque(false);
        turnDisplay.setBorder(null);
        turnDisplay.setFont(new Font("Calibre" , Font.PLAIN , 60));
        turnDisplay.setForeground(new Color(169, 167, 0));
        pane.add(turnDisplay,Integer.valueOf(0));
        //add player1 coin amounts
        coinAmountDisplay1.setBounds(10,600,300,50);
        coinAmountDisplay1.setOpaque(false);
        coinAmountDisplay1.setBorder(null);
        coinAmountDisplay1.setFont(new Font("Calibre" , Font.PLAIN , 30));
        coinAmountDisplay1.setForeground(new Color(169, 167, 0));
        pane.add(coinAmountDisplay1,Integer.valueOf(3));
        //add player2 coin amounts
        coinAmountDisplay2.setBounds(10,650,300,50);
        coinAmountDisplay2.setOpaque(false);
        coinAmountDisplay2.setBorder(null);
        coinAmountDisplay2.setFont(new Font("Calibre" , Font.PLAIN , 30));
        coinAmountDisplay2.setForeground(new Color(169, 167, 0));
        pane.add(coinAmountDisplay2,Integer.valueOf(3));
        //add player1 voucher amounts
        voucherAmountDisplay1.setBounds(10,750,200,50);
        voucherAmountDisplay1.setOpaque(false);
        voucherAmountDisplay1.setBorder(null);
        voucherAmountDisplay1.setFont(new Font("Calibre" , Font.PLAIN , 30));
        voucherAmountDisplay1.setForeground(new Color(169, 167, 0));
        pane.add(voucherAmountDisplay1,Integer.valueOf(3));
        //add player2 voucher amounts
        voucherAmountDisplay2.setBounds(10,800,200,50);
        voucherAmountDisplay2.setOpaque(false);
        voucherAmountDisplay2.setBorder(null);
        voucherAmountDisplay2.setFont(new Font("Calibre" , Font.PLAIN , 30));
        voucherAmountDisplay2.setForeground(new Color(169, 167, 0));
        pane.add(voucherAmountDisplay2,Integer.valueOf(3));
        //make pane
        pane.setBounds(0,0,1920,1080);
        //add coin icons
        //Red
        JLabel RedLabel = new JLabel();
        JLabel RedLabel1 = new JLabel();
        RedLabel.setBounds(10,575,30,30);
        RedLabel1.setBounds(10,725,30,30);
        ImageIcon RedCoin= new ImageIcon("Red.png");
        RedCoin= resize(RedCoin , 30,30);
        RedLabel.setIcon(RedCoin);
        RedLabel1.setIcon(RedCoin);
        pane.add(RedLabel,Integer.valueOf(3));
        pane.add(RedLabel1,Integer.valueOf(3));
        //Green
        JLabel GreenLabel = new JLabel();
        JLabel GreenLabel1 = new JLabel();
        GreenLabel.setBounds(43,575,30,30);
        GreenLabel1.setBounds(43,725,30,30);
        ImageIcon GreenCoin= new ImageIcon("green.png");
        GreenCoin= resize(GreenCoin , 30,30);
        GreenLabel.setIcon(GreenCoin);
        GreenLabel1.setIcon(GreenCoin);
        pane.add(GreenLabel,Integer.valueOf(3));
        pane.add(GreenLabel1,Integer.valueOf(3));
        //Blue
        JLabel BlueLabel = new JLabel();
        JLabel BlueLabel1 = new JLabel();
        BlueLabel.setBounds(76,575,30,30);
        BlueLabel1.setBounds(76,725,30,30);
        ImageIcon BlueCoin= new ImageIcon("Blue.png");
        BlueCoin= resize(BlueCoin , 30,30);
        BlueLabel.setIcon(BlueCoin);
        BlueLabel1.setIcon(BlueCoin);
        pane.add(BlueLabel,Integer.valueOf(3));
        pane.add(BlueLabel1,Integer.valueOf(3));
        //Black
        JLabel BlackLabel = new JLabel();
        JLabel BlackLabel1 = new JLabel();
        BlackLabel.setBounds(109,575,30,30);
        BlackLabel1.setBounds(109,725,30,30);
        ImageIcon BlackCoin= new ImageIcon("Black.png");
        BlackCoin= resize(BlackCoin , 30,30);
        BlackLabel.setIcon(BlackCoin);
        BlackLabel1.setIcon(BlackCoin);
        pane.add(BlackLabel,Integer.valueOf(3));
        pane.add(BlackLabel1,Integer.valueOf(3));
        //White
        JLabel WhiteLabel = new JLabel();
        JLabel WhiteLabel1 = new JLabel();
        WhiteLabel.setBounds(142,575,30,30);
        WhiteLabel1.setBounds(142,725,30,30);
        ImageIcon WhiteCoin= new ImageIcon("White.png");
        WhiteCoin= resize(WhiteCoin , 30,30);
        WhiteLabel.setIcon(WhiteCoin);
        WhiteLabel1.setIcon(WhiteCoin);
        pane.add(WhiteLabel,Integer.valueOf(3));
        pane.add(WhiteLabel1,Integer.valueOf(3));
        //Gold
        JLabel GoldLabel = new JLabel();
        GoldLabel.setBounds(175,575,30,30);
        ImageIcon GoldCoin= new ImageIcon("Gold.png");
        GoldCoin= resize(GoldCoin , 30,30);
        GoldLabel.setIcon(GoldCoin);
        pane.add(GoldLabel,Integer.valueOf(3));
        //add background picture
        ImageIcon backGroundPic = new ImageIcon("back.png");
        JLabel backGroundLabel = new JLabel(backGroundPic);
        backGroundLabel.setBounds(0,0,1920,1080);
        pane.add(backGroundLabel ,Integer.valueOf(-3));
        //add action listeners to all buttons not on screens
        shop.addActionListener(this);
        Reserved.addActionListener(this);
        confirm.addActionListener(this);
        back.addActionListener(this);
        back2.addActionListener(this);
        back3.addActionListener(this);
        slot.addActionListener(this);
        //set positions for all buttons not on screens
        shop.setBounds(360,400,1200,100);
        Reserved.setBounds(360,200,1200,100);
        back.setBounds(0,0,100,100);
        back2.setBounds(1805,0,100,100);
        back3.setBounds(1805,0,100,100);
        confirm.setBounds(880,800,100,100);
        slot.setBounds(360,600,1200,100);
        //set fonts for all buttons not on screens
        slot.setFont(new Font("Calibre" ,Font.BOLD , 40));
        shop.setFont(new Font("Calibre" ,Font.BOLD , 40));
        Reserved.setFont(new Font("Calibre" ,Font.BOLD , 40));

        //add pane to frame
        this.add(pane);
    }
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
        assert cardPane != null;
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
        assert icon != null;
        icon = resize(icon,40,40);
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
              icon1 = resize(icon1 , 40,40);
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
        if(card.level != 0){
        if(card.ownedBy.equals("bank")) {
            JButton res = new JButton("Res");
            res.setBounds(105, 100, 70, 70);
            cardPane.add(res);
            res.addActionListener(this);
            reserveButtons.set((level * 4) + index, res);
        }
        }
        //final addition
            pane.add(cardPane, 2,-1);

    }
    public void drawCard(int XPos , int YPos , cards card,int index, players player) {
        //makes card base
        JLayeredPane cardPane = new JLayeredPane();
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
            assert icon != null;
            icon = resize(icon,40,40);
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
                icon1 = resize(icon1 , 40,40);
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
        if(player == player1){
            JButton buy=new JButton("Buy");
            buy.setBounds(20,100,70,70);
            cardPane.add(buy);
            buy.addActionListener(this);
            buyButtons.set(20+index,buy);
        }
        if(player == player2){
            JButton buy=new JButton("Buy");
            buy.setBounds(20,100,70,70);
            cardPane.add(buy);
            buy.addActionListener(this);
            buyButtons.set(20+index+4,buy);
        }
        //final addition
        pane.add(cardPane, 2,-1);
        player.reservedCardsBase.set(index,cardPane);
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
        drawCard(1500,25,cards.lv0CardsOnDeck.get(0) ,0,0);
        drawCard(1500,375,cards.lv0CardsOnDeck.get(1) ,0,1);
        drawCard(1500,725,cards.lv0CardsOnDeck.get(2) ,0,2);
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
        RedAmount = new JTextField();
        RedAmount.setOpaque(false);
        RedAmount.setBorder(null);
        RedAmount.setBounds(375,350,50,50);
        pane.add(RedAmount , Integer.valueOf(2));
        RedAmount.setFont(new Font("calibre" , Font.PLAIN ,50));
        RedAmount.setText(Integer.toString(slotMachines.Red.coinAmount));
        pane.add(RedLabel , Integer.valueOf(2));
        ImageIcon Green = slotList.get(1);
        Image image2 = Green.getImage();
        Image newImg2 = image2.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
        Green = new ImageIcon(newImg2);
        GreenLabel = new JLabel(Green);
        GreenLabel.setBounds(575,425,200,200);
        GreenBox = new JCheckBox();
        GreenBox.setBounds(640,650,20,20);
        GreenAmount = new JTextField();
        GreenAmount.setOpaque(false);
        GreenAmount.setBorder(null);
        GreenAmount.setBounds(625,350,50,50);
        pane.add(GreenAmount , Integer.valueOf(2));
        GreenAmount.setFont(new Font("calibre" , Font.PLAIN ,50));
        GreenAmount.setText(Integer.toString(slotMachines.Green.coinAmount));
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
        BlueAmount = new JTextField();
        BlueAmount.setOpaque(false);
        BlueAmount.setBorder(null);
        BlueAmount.setBounds(875,350,50,50);
        pane.add(BlueAmount , Integer.valueOf(2));
        BlueAmount.setFont(new Font("calibre" , Font.PLAIN ,50));
        BlueAmount.setText(Integer.toString(slotMachines.Blue.coinAmount));
        pane.add(BlueBox , Integer.valueOf(2));
        pane.add(BlueLabel , Integer.valueOf(2));
        ImageIcon Black = slotList.get(3);
        Image image4 = Black.getImage();
        Image newImg4 = image4.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
        Black = new ImageIcon(newImg4);
        BlackLabel = new JLabel(Black);
        BlackBox = new JCheckBox();
        BlackBox.setBounds(1140,650,20,20);
        BlackAmount = new JTextField();
        BlackAmount.setOpaque(false);
        BlackAmount.setBorder(null);
        BlackAmount.setBounds(1125,350,50,50);
        pane.add(BlackAmount , Integer.valueOf(2));
        BlackAmount.setFont(new Font("calibre" , Font.PLAIN ,50));
        BlackAmount.setText(Integer.toString(slotMachines.Black.coinAmount));
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
        WhiteAmount = new JTextField();
        WhiteAmount.setOpaque(false);
        WhiteAmount.setBorder(null);
        WhiteAmount.setBounds(1375,350,50,50);
        pane.add(WhiteAmount , Integer.valueOf(2));
        WhiteAmount.setFont(new Font("calibre" , Font.PLAIN ,50));
        WhiteAmount.setText(Integer.toString(slotMachines.White.coinAmount));
        pane.add(WhiteBox , Integer.valueOf(2));
        WhiteLabel.setBounds(1325,425,200,200);
        pane.add(WhiteLabel , Integer.valueOf(2));
        pane.add(back2 ,Integer.valueOf(2));
        pane.add(confirm,Integer.valueOf(2));
        ImageIcon Gold = new ImageIcon("GoldS.png");
        Gold = resize(Gold ,200,200);
        GoldLabel = new JLabel(Gold);
        GoldLabel.setBounds(825,100,200,200);
        pane.add(GoldLabel , Integer.valueOf(2));
        GoldAmount = new JTextField();
        GoldAmount.setOpaque(false);
        GoldAmount.setBorder(null);
        GoldAmount.setBounds(875,50,50,50);
        pane.add(GoldAmount , Integer.valueOf(2));
        GoldAmount.setFont(new Font("calibre" , Font.PLAIN ,50));
        GoldAmount.setText(Integer.toString(slotMachines.Bank.coinAmount));
    }
    public void drawReserves(){
        backGround.setBounds(0,0,1920,1080);
        backGround.setBackground(Color.white);
        pane.add(back3 , Integer.valueOf(2));
        pane.add(backGround , Integer.valueOf(1));
        if(turn ==1){
            for (int i = 0; i < player1.reservedCards.size(); i++) {
                drawCard(600+250*i,25,player1.reservedCards.get(i),i,player1);
            }
        }
        if(turn ==2){
            for (int i = 0; i < player2.reservedCards.size(); i++) {
                drawCard(600+250*i,25,player2.reservedCards.get(i),i,player2);
            }
        }
    }

    public void drawMenu(){
        pane.add(shop , Integer.valueOf(0));
        pane.add(Reserved , Integer.valueOf(0));
        pane.add(slot , Integer.valueOf(0));
        backGround2.setBackground(Color.white);
        backGround2.setBounds(0,0,1920,1080);
        pane.add(backGround2 , Integer.valueOf(-1));

    }

    public ImageIcon resize(ImageIcon icon , int width , int height){
        Image image = icon.getImage();
        Image newImg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImg);
        return icon;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(shop)) {
            drawShop();
            pane.repaint();
        }
        else if(e.getSource().equals(menuButton)){
            if(menuIsUp) {
                goBack4();
                menuIsUp = false;
            }
                else {
                drawMenu();
                menuIsUp = true;
            }
        }
        else if(e.getSource().equals(Reserved)){
            drawReserves();
        }
        else if(e.getSource().equals(slot)){
            drawSlots();
            pane.repaint();
        }
        else if(e.getSource().equals(back)){
            goBack();
        }
        else if(e.getSource().equals(back2)){
            goBack2();
        }
        else if(e.getSource().equals(back3)){
            goBack3();
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
            if(buttonsActive == 1){
                for (int i = 0; i < 5; i++) {
                    if(checkArray[i] == 1){
                        if(turn == 1){
                            if(player1.takeFromSlotMachine(i)) {
                                goBack2();
                                switchTurn(2);
                            }
                            break;
                        }
                        else if(turn == 2){
                            if(player2.takeFromSlotMachine(i)) {
                                goBack2();
                                switchTurn(1);
                            }
                            break;
                        }
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
                if(turn == 1){
                    if(player1.takeFromSlotMachine(input1,input2,input3)) {
                        switchTurn(2);
                        goBack2();
                    }
                }
                else if(turn == 2){
                    if(player2.takeFromSlotMachine(input1,input2,input3)) {
                        switchTurn(1);
                        goBack2();
                    }
                }

            }
        }
        else for (int i = 0; i < 16; i++) {
            if(e.getSource().equals(buyButtons.get(i))){
                if(turn==1) {
                    if (player1.buyCard(i / 4, i % 4) == 0) {
                        switchTurn(2);
                        goBack();
                    }
                }
                else if(turn==2) {
                    if (player2.buyCard(i / 4, i % 4) == 0) {
                        switchTurn(1);
                        goBack();
                    }
                }
            }
        }
        for (int i = 0; i < 16; i++) {
            if(e.getSource().equals(reserveButtons.get(i))){
                if(turn==1) {
                    if (player1.reserveCard(i / 4, i % 4) == 0) {
                        switchTurn(2);
                        goBack();
                    }
                }
                else if(turn==2) {
                    if (player2.reserveCard(i / 4, i % 4) == 0) {
                        switchTurn(1);
                        goBack();
                    }
                }
            }
        }
        for (int i = 20; i < 27; i++) {
            if(e.getSource().equals(buyButtons.get(i))){
                if(turn==1) {
                    player1.buyCard(i-20);
                    goBack3();
                    switchTurn(2);
                    }
                else if(turn==2) {
                    player2.buyCard(i-24);
                    goBack3();
                    switchTurn(1);
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
        pane.remove(lv0CardsBase.get(0));
        pane.remove(lv0CardsBase.get(1));
        pane.remove(lv0CardsBase.get(2));
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
        pane.remove(GoldLabel);
        pane.remove(backGround);
        pane.remove(back2);
        pane.remove(RedBox);
        pane.remove(GreenBox);
        pane.remove(BlueBox);
        pane.remove(BlackBox);
        pane.remove(WhiteBox);
        pane.remove(RedAmount);
        pane.remove(GreenAmount);
        pane.remove(BlueAmount);
        pane.remove(BlackAmount);
        pane.remove(WhiteAmount);
        pane.remove(GoldAmount);
        pane.remove(confirm);
        pane.repaint();
    }
    private void goBack3() {
        pane.remove(backGround);
        pane.remove(back3);
        if(turn == 1){
            for (int i = 0; i < player1.reservedCardsBase.size(); i++) {
                pane.remove(player1.reservedCardsBase.get(i));
            }
        }
        if(turn == 2){
            for (int i = 0; i < player2.reservedCardsBase.size(); i++) {
                pane.remove(player2.reservedCardsBase.get(i));
            }
        }
        pane.repaint();
    }
    private void goBack4() {
        pane.remove(backGround2);
        pane.remove(shop);
        pane.remove(slot);
        pane.remove(Reserved);
        pane.repaint();
    }

    public void switchTurn(int newTurn){
        if(newTurn ==2) {
            turn = 2;
            turnDisplay.setText("Player2");
        }
        else if(newTurn ==1) {
            turn = 1;
            turnDisplay.setText("Player1");
        }
        coinAmountDisplay1.setText(Arrays.toString(player1.coinAmounts)+"P1:" + player1.score);
        voucherAmountDisplay1.setText(Arrays.toString(player1.voucherAmounts)+"P1");
        coinAmountDisplay2.setText(Arrays.toString(player2.coinAmounts)+"P2:"+player2.score);
        voucherAmountDisplay2.setText(Arrays.toString(player2.voucherAmounts)+"P2");
    }
}