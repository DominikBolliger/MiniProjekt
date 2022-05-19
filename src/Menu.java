public class Menu {

    public static String[] sectionOptions = {
            "Show section",
            "Delete Section",
            "Add section",
    };

    public static String[] keyOptions = {
            "Add Value",
            "Change value",
            "Delete value",
            "Back"
    };

    public static void printMenu(String[] options){
        int i = 1;
        System.out.println();
        for (String option : options){
            System.out.println(i + ". " + option);
            i++;
        }
    }
}
