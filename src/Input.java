import java.util.Scanner;

public class Input {

    private static Scanner scn = new Scanner(System.in);

    public static int getMenuInput(int length){
        System.out.println();
        System.out.println("-".repeat(4*length));
        System.out.println();
        System.out.print("Choose your option : ");
        return scn.nextInt();
    }

    public static int getSectionNumber(){
        System.out.println();
        System.out.print("Pleas enter the Section Number: ");
        return scn.nextInt();
    }

    public static String getSectionName(int length){
        System.out.println();
        System.out.println("-".repeat(4*length));
        System.out.println();
        System.out.print("Pleas enter a Name for the new Section: ");
        return scn.next();
    }

}
