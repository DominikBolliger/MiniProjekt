public class CLIoutput {

    public static String[] sectionOptions = {
            "Show section",
            "Delete Section",
            "Add section",
    };

    public static String[] keyOptions = {
            "Add Key",
            "Delete Key",
            "Change value",
            "Back"
    };

    public static void printMenu(String[] options){
        int i = 1;
        for (String option : options){
            System.out.println(i + ". " + option);
            i++;
        }
    }
}
