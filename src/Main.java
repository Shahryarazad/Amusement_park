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
    }
}
