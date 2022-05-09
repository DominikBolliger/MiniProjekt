import java.util.Scanner;

public class Input {
    private static Scanner scn = new Scanner(System.in);
    public static int getInput(){
        System.out.println();
        System.out.println("----------------------------------------------------------------");
        System.out.println();
        System.out.print("Please enter your Keynumber: ");
        return scn.nextInt();
    }
}
