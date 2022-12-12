package NestedLoops;

import javax.swing.*;

public class Oefening5Gemiddelde {
    public static void main(String[] args) {
        int som = 0;
        int gemiddelde = 0;
        int getal = 0;
        String input = JOptionPane.showInputDialog("Aantal While");
        int aantal = Integer.parseInt(input);
        while (aantal > 0 && !input.equals("0")) {
            for (int i = 0; i < aantal; i++) {
                getal = Integer.parseInt(JOptionPane.showInputDialog("Geef Getallen"));
                som += getal;
            }
            gemiddelde = som / aantal;
            System.out.println(gemiddelde);
            input = JOptionPane.showInputDialog("Onder While");
            aantal = Integer.parseInt(input);
        }
    }
}
