package NestedLoops;

public class Oefening4StarsSterrekes {
    public static void main(String[] args) {
        int counter = 0;
        for (int i = 0; i < 10; i++) {
            System.out.println();
            counter++;
            for (int j = counter; j > 0 ; j--) {
                System.out.print("*");
            }
        }
    }
}
