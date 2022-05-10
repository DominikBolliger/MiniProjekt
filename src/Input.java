import java.util.Scanner;

public class Input {
    private static Scanner scn = new Scanner(System.in);
    public static int getInput(int length){
        System.out.println();
        System.out.println("-".repeat(4*length));
        System.out.println();
        System.out.print("Choose your option : ");
        return scn.nextInt();
    }
}
