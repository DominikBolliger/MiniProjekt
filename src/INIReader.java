public class INIReader {
    public static void main(String[] args) throws Exception{

        Reader reader = new Reader(Util.getIniFilePath());
        int stringLength = reader.getStringLength();
        int choice = -1;

        while(choice != 0){
            reader.printKeys();
            Menu.printMenu(Menu.sectionOptions);

            switch (choice = Input.getMenuInput(stringLength)){
                case 0:
                    System.out.println("Das Programm wird nun beendet");
                    break;
                case 1:
                    //Show Values from Section
                    reader.printValues(Input.getSectionNumber());
                    Menu.printMenu(Menu.keyOptions);
                    //New Switch for Value options

                    switch (choice = Input.getMenuInput(stringLength)){
                        case 1:
                            reader.addKey();
                            break;
                        case 2:
                            reader.changeValue();
                            break;
                        case 3:
                            reader.deleteKey();
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    //Add a new Section
                    reader.deleteSection(Input.getSectionNumber());
                    break;
                case 3:
                    //Delete a section
                    reader.addSection(Input.getSectionName(stringLength));
                    break;
                default:
                    break;
            }
        }
    }
}
