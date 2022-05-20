public class CLIoutput {

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

    public static void formatter(int length){
        System.out.println();
        System.out.println("-".repeat(length));
        System.out.println();
    }

    public static void printMenu(String[] options){
        int i = 1;
        for (String option : options){
            System.out.println(i + ". " + option);
            i++;
        }
    }
}
