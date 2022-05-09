public class INIReader {

    private static final String INI_FILE = "C:\\OPMS\\Zeag\\opms.ini";

    public static void main(String[] args) throws Exception{
        Reader reader = new Reader(INI_FILE);
        int choice = -1;
        while(choice != 0){
            reader.printKeys();
            choice = Input.getInput();
            reader.printValues(choice);
            choice = Input.getInput();
        }
    }
}
