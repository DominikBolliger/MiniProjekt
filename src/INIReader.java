public class INIReader {
    public static void main(String[] args) throws Exception{
        Reader reader = new Reader(Util.getIniFilePath());
        int choice = -1;
        while(choice != 0){
            reader.printKeys();
            choice = Input.getInput();
            reader.printValues(choice);
            choice = Input.getInput();
        }
    }
}
