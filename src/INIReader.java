public class INIReader {
    public static void main(String[] args) throws Exception{
        Reader reader = new Reader(Util.getIniFilePath());
        int stringLength = reader.getStringLength();
        int choice = -1;
        while(choice != 0){
            reader.printKeys();
            reader.printValues(Input.getInput(stringLength));
            Menu.printMenu(Menu.keyOptions);
            choice = Input.getInput(stringLength);
            switch (choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    break;
            }
            reader.printKeys();
            choice = Input.getInput(reader.getStringLength());
            reader.printValues(choice);
            choice = Input.getInput(reader.getStringLength());
        }
    }
}
