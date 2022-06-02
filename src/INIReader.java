public class INIReader {
    public static void main(String[] args) throws Exception{

        Reader reader = new Reader(Util.getIniFilePath());
        int choice = -1;
        int sectionKey = 0;
        System.out.println();//Formatting
        reader.printSections();

        while(choice != 0){
            Util.formatter();
            CLIoutput.printMenu(CLIoutput.sectionOptions);
            Util.formatter();

            switch (choice = Input.getMenuInput()){
                case 0:
                    //End Prog
                    System.out.println("Das Programm wird nun beendet");
                    break;
                case 1:
                    while(choice != 4) {
                        //Show Values from Section
                        if (sectionKey == 0){
                            do{
                                sectionKey=Input.getSectionNumber(reader.getSize());
                            } while (sectionKey <= 0 || sectionKey >= reader.getSize());

                            reader.printKeysAndValues(sectionKey);
                            Util.formatter();
                        } else {
                            reader.printKeysAndValues(sectionKey);
                            Util.formatter();
                        }
                        CLIoutput.printMenu(CLIoutput.keyOptions);
                        Util.formatter();
                        //New Switch for Value options
                        switch (choice = Input.getMenuInput()) {
                            case 1:
                                //Add Key to section
                                reader.addKeyAndValue(sectionKey, Input.getKeyName(), Input.getKeyValue());
                                Util.formatter();
                                break;
                            case 2:
                                //Delete a key (and with it its value)
                                reader.deleteKey(sectionKey, Input.getKeyNumber());
                                Util.formatter();
                                break;
                            case 3:
                                //Change the Value of a key
                                reader.changeValue(sectionKey, Input.getKeyNumber(), Input.getKeyValue());
                                Util.formatter();
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
                    reader.deleteSection(Input.getSectionNumber(reader.getSize()));
                    Util.formatter();
                    break;
                case 3:
                    //Delete a section
                    reader.addSection(Input.getSectionName());
                    Util.formatter();
                    break;
                default:
                    //Exception handling
                    System.out.println("Bitte gültigen Menüpunkt eingeben");
                    break;
            }
        }
    }
}