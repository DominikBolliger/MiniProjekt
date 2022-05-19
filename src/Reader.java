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
    private String path;
    private Set<Map.Entry<String, Profile.Section>> sections;
    private ArrayList<String> keyList;
    private int size;
    private int stringLength;

    Reader(String p){
        this.path = p;
        try {
            this.ini = new Wini(new File(this.path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.sections = this.ini.entrySet();
        this.size = this.sections.size();
        this.keyList = new ArrayList<>();
        for (Map.Entry<String, Profile.Section> e : this.sections) {
            Profile.Section section = e.getValue();
            this.keyList.add(section.getName());
        }
        this.stringLength = Util.getLongestString(this.keyList);
        Collections.sort(keyList);
    }

    public void printKeys(){
        int stringLength = Util.getLongestString(this.keyList);
        for (int i = 0; i <= this.size; i+=3) {
            for (int j = 0; j < 3; j++) {
                if (String.valueOf(i + j).length() <= String.valueOf(this.size).length()){
                    System.out.print(" ".repeat(3-String.valueOf(i + 1).length()));
                    if (this.keyList.get(i+j).length() <= this.stringLength){
                        System.out.print(1 + (i + j) + ". " + this.keyList.get(i + j) + " ".repeat(38 - this.keyList.get(i + j).length()));
                        if (i + j == this.size-1) {
                            System.out.println();
                            return;
                        }
                    }
                }
            }
            System.out.println();
        }
    }

    public void printValues(int key){
        int i = 1;
        Profile.Section section = this.ini.get(this.keyList.get(key-1));
        System.out.println();
        System.out.println("[" + this.keyList.get(key-1) + "]");
        System.out.println();
        for (String s:section.keySet()) {
            if (!s.startsWith("!")) {
                System.out.println(i + ". " + s + " = " + section.get(s));
                i++;
            }
        }
    }

    public void deleteSection(int key){
        Profile.Section section = this.ini.get(this.keyList.get(key-1));
        this.keyList.remove(key-1);
        this.size--;
        try {
            this.ini.remove(section);
            this.ini.store();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addSection(String sectionName){
        try {
            this.ini.put(sectionName, "keyName", "value");
            ini.store();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getStringLength() {
        return stringLength;
    }

    public void addKey() {
    }

    public void changeValue() {
    }

    public void deleteKey() {
    }
}