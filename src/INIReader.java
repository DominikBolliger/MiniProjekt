public class INIReader {
    public static void main(String[] args) throws Exception{

        Reader reader = new Reader(Util.getIniFilePath());
        int choice = -1;
        int sectionKey = 0;
        int lineLength = 0;
        System.out.println();//Formatting

        while(choice != 0){
            lineLength = reader.printSections();
            Util.formatter(lineLength);
            CLIoutput.printMenu(CLIoutput.sectionOptions);
            Util.formatter(lineLength);

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
                            Util.formatter(lineLength);
                        } else {
                            reader.printKeysAndValues(sectionKey);
                            Util.formatter(lineLength);
                        }
                        CLIoutput.printMenu(CLIoutput.keyOptions);
                        Util.formatter(lineLength);
                        //New Switch for Value options
                        switch (choice = Input.getMenuInput()) {
                            case 1:
                                //Add Key to section
                                reader.addKeyAndValue(sectionKey, Input.getKeyName(), Input.getKeyValue());
                                Util.formatter(lineLength);
                                break;
                            case 2:
                                //Delete a key (and with it its value)
                                reader.deleteKey(sectionKey, Input.getKeyNumber());
                                Util.formatter(lineLength);
                                break;
                            case 3:
                                //Change the Value of a key
                                reader.changeValue(sectionKey, Input.getKeyNumber(), Input.getKeyValue());
                                Util.formatter(lineLength);
                                break;
                            case 4:
                                //Back to the Section view list
                                System.out.println();
                                sectionKey = 0;
                                break;
                            default:
                                //Exception handling
                                System.out.println("Bitte g??ltigen Men??punkt eingeben");
                                break;
                        }
                    }
                    break;
                case 2:
                    //Add a new Section
                    reader.deleteSection(Input.getSectionNumber(reader.getSize()));
                    Util.formatter(lineLength);
                    break;
                case 3:
                    //Delete a section
                    reader.addSection(Input.getSectionName());
                    Util.formatter(lineLength);
                    break;
                default:
                    //Exception handling
                    System.out.println("Bitte g??ltigen Men??punkt eingeben");
                    break;
            }
        }
    }
}