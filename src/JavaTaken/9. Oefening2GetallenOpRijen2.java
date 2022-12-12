package NestedLoops;

public class Oefening2GetallenOpRijen2 {
    public static void main(String[] args) {
        int counter = 1;
        for (int row = 0; row < 5; row++) {
            System.out.println();
            for (int column = 0; column < 3; column++) {
                System.out.print(counter + "\t");
                counter++;
            }
        }
    }
}
