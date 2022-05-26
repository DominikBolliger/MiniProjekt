import org.ini4j.Profile;
import org.ini4j.Wini;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class Reader {

    private Wini ini;
    private Set<Map.Entry<String, Profile.Section>> sections;
    private ArrayList<String> sectionsList;
    private ArrayList<String> keyList;
    private int size;
    private int sectionListSeperator = 30;

    /**
     * Constructor for the reader
     *
     * @param path the path where the INI File is located
     */
    Reader(String path) {
        this.ini = this.createWini(path);
        this.sections = this.ini.entrySet();
        this.size = this.sections.size();
        this.sectionsList = this.createSectionsList();
        this.keyList = new ArrayList<>();
    }

    /**
     * This method will create our Wini object. Since this has to be done in a try
     * catch block I wanted to separate it from the constructor for better readability
     *
     * @param path the path where the ini file is stored
     * @return the Wini object
     */
    private Wini createWini(String path) {
        Wini ret = new Wini();
        try {
            ret = new Wini(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * This method takes all the sections and puts them into a ArrayList for better handling.
     *
     * @return the sortet array List containing all sections from the ini file
     */
    private ArrayList<String> createSectionsList() {
        ArrayList<String> ret = new ArrayList<>();
        for (Map.Entry<String, Profile.Section> e : this.sections) {
            Profile.Section section = e.getValue();
            ret.add(section.getName());
        }
        Collections.sort(ret);
        return ret;
    }

    /**
     * This method is responsible for printing all the Section names that are present in the INI-File.
     * It is also going to format the Output to 3 Values per line and makes sure all the spaces fit with the other lines
     */
    public int printSections() {
        ArrayList<String> cliLine = new ArrayList<>();
        int lineLength = 0;
        int actualLineLength = 0;
        for (int i = 0; i < this.sectionsList.size(); i += 3) {
            cliLine.clear();
            for (int j = 0; j < 3; j++) {
                cliLine.add(j + i + 1 + ". " + this.sectionsList.get(i + j));
            }
            for (int j = 0; j < cliLine.size(); j++) {
                System.out.printf("%-"+sectionListSeperator+"s", cliLine.get(j));
            }
            System.out.println();
        }
        return lineLength;
    }

    /**
     * Removes a given Section from the INI file
     *
     * @param key Index Number to delete the Section from all Lists
     */
    public void deleteSection(int key) {
        Profile.Section section = this.ini.get(this.sectionsList.get(key - 1));
        try {
            this.ini.remove(section);
            this.ini.store();
            this.sectionsList.remove(key - 1);
            this.size--;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a new Section to the INI File
     *
     * @param sectionName The Name for the new Section
     */
    public void addSection(String sectionName) {
        try {
            this.ini.put(sectionName, "key 1", "Value 1");
            this.sectionsList.add(sectionName);
            this.size++;
            Collections.sort(sectionsList);
            ini.store();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints all Values from a selected Section
     *
     * @param key The index of the selected Section
     */
    public void printKeysAndValues(int key) {
        int i = 1;
        this.keyList.clear();
        Profile.Section section = this.ini.get(this.sectionsList.get(key - 1));
        System.out.println();
        System.out.println("[" + this.sectionsList.get(key - 1) + "]");
        System.out.println();
        for (String s : section.keySet()) {
            if (!s.startsWith("!")) {
                System.out.println(i + ". " + s + " = " + section.get(s));
                this.keyList.add(s);
                i++;
            }
        }
    }

    /**
     * Add a new Key to a selected Section. Also adds a value to this new Key
     *
     * @param key     The Index of the selected Section
     * @param keyName The Name for the New Key
     * @param value   The Value for the new Key
     */
    public void addKeyAndValue(int key, String keyName, String value) {
        Profile.Section section = this.ini.get(this.sectionsList.get(key - 1));
        section.put(keyName, value);
        try {
            ini.store();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Changes a Value of a selected Key from a Section
     *
     * @param key       Index for the selected Section
     * @param keyNumber index for the Key to be changed
     * @param value     The new Value for the selected Key
     */
    public void changeValue(int key, int keyNumber, String value) {
        Profile.Section section = this.ini.get(this.sectionsList.get(key - 1));
        section.put(this.keyList.get(keyNumber - 1), value);
        try {
            ini.store();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a selected Key from a Section
     *
     * @param key       Index for the selected Section
     * @param keyNumber Index for the Key to delete
     */
    public void deleteKey(int key, int keyNumber) {
        Profile.Section section = this.ini.get(this.sectionsList.get(key - 1));
        section.remove(this.keyList.get(keyNumber - 1));
        try {
            ini.store();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getSize() {
        return size;
    }
}