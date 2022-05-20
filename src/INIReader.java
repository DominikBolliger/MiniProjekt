public class INIReader {
    public static void main(String[] args) throws Exception{

        Reader reader = new Reader(Util.getIniFilePath());
        int stringLength;
        int choice = -1;
        int sectionKey = 0;
        System.out.println();//Formatting

        while(choice != 0){
            reader.printSections();
            stringLength = reader.getLineLength();
            CLIoutput.formatter(stringLength);
            CLIoutput.printMenu(CLIoutput.sectionOptions);
            CLIoutput.formatter(stringLength);

            switch (choice = Input.getMenuInput()){
                case 0:
                    //End Prog
                    System.out.println("Das Programm wird nun beendet");
                    break;
                case 1:
                    while(choice != 4) {
                        //Show Values from Section
                        if (sectionKey == 0){
                            reader.printKeysAndValues(sectionKey=Input.getSectionNumber());
                        } else {
                            reader.printKeysAndValues(sectionKey);
                        }
                        CLIoutput.formatter(stringLength);
                        CLIoutput.printMenu(CLIoutput.keyOptions);
                        CLIoutput.formatter(stringLength);
                        //New Switch for Value options
                        switch (choice = Input.getMenuInput()) {
                            case 1:
                                //Add Key to section
                                reader.addKeyAndValue(sectionKey, Input.getKeyName(), Input.getKeyValue());
                                break;
                            case 2:
                                //Change the Value of a key
                                reader.changeValue(sectionKey, Input.getKeyNumber(), Input.getKeyValue());
                                break;
                            case 3:
                                //Delete a key (and with it its value)
                                reader.deleteKey(sectionKey, Input.getKeyNumber());
                                break;
                            case 4:
                                //Back to the Section view list
                                System.out.println();
                                sectionKey = 0;
                                break;
                            default:
                                //Exception handling
                                System.out.println("Bitte gültigen Menüpunkt eingeben");
                                break;
                        }
                    }
                    break;
                case 2:
                    //Add a new Section
                    reader.deleteSection(Input.getSectionNumber());
                    break;
                case 3:
                    //Delete a section
                    reader.addSection(Input.getSectionName());
                    break;
                default:
                    //Exception handling
                    System.out.println("Bitte gültigen Menüpunkt eingeben");
                    break;
            }
        }
    }
}