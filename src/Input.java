import java.util.Scanner;

public class Input {

    private static Scanner scn = new Scanner(System.in);

    public static int getMenuInput(){
        System.out.print("Choose your option : ");
        while (!scn.hasNextInt()){
            System.out.println("Please enter a valid number!");
            scn = new Scanner(System.in);
        }
        return scn.nextInt();
    }

    public static int getSectionNumber(int size){
        System.out.print("Pleas enter the Section Number: ");
        int ret = -1;
        while (!scn.hasNextInt()){
            System.out.println("Please enter a valid number!");
            scn = new Scanner(System.in);
        }
        return scn.nextInt();
    }

    public static int getKeyNumber(){
        System.out.print("Pleas enter the Key Number: ");
        while (!scn.hasNextInt()){
            System.out.println("Please enter a valid number!");
            scn = new Scanner(System.in);
        }
        return scn.nextInt();
    }

    public static String getSectionName(){
        System.out.print("Pleas enter a Name for the new Section: ");
        return scn.next();
    }

    public static String getKeyName(){
        System.out.print("Pleas enter a Name for the new Key: ");
        return scn.next();
    }

    public static String getKeyValue() {
        System.out.print("Please enter a Value for the new Key: ");
        return scn.next();
    }
}
