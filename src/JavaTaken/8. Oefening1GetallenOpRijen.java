package NestedLoops;

public class Oefening1GetallenOpRijen {
    public static void main(String[] args) {
        for (int row = 1; row <= 5; row++) {
            System.out.println();
            for (int column = 0; column < 3; column++) {
                System.out.print(row + " ");
            }
        }
    }
}
