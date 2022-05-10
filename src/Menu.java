public class Menu {

    public static String[] sectionOptions = {
            "Add section",
            "Change section"
    };

    public static String[] keyOptions = {
            "Add Value",
            "Change value",
            "Delete value"
    };

    public static void printMenu(String[] options){
        int i = 1;
        System.out.println();
        for (String option : options){
            System.out.println(i + ". " + option);
            i++;
        }
        System.out.println();
        System.out.print("Choose your option : ");
    }

}
