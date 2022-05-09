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


    Reader(String p){
        this.path = p;
        try {
            this.ini = new Wini(new File(this.path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.sections = this.ini.entrySet();
        this.keyList = new ArrayList<>();
        for (Map.Entry<String, Profile.Section> e : this.sections) {
            Profile.Section section = e.getValue();
            this.keyList.add(section.getName());
        }
        Collections.sort(keyList);
    }

    public void printKeys(){
        int i = 1;
        for (String key:keyList) {
            System.out.println(i + ". " + key);
            i++;
        }
    }

    public void printValues(int key){
        Profile.Section section = this.ini.get(this.keyList.get(key-1));
        System.out.println();
        System.out.println("[" + this.keyList.get(key-1) + "]");
        System.out.println();
        for (String s:section.keySet()) {
            if (!s.startsWith("!"))
            System.out.println(s + " = " + section.get(s));
        }
//        System.out.println("----------------------------------------------------------------");
//        System.out.println();
    }

    public void printFull(){
        for (Map.Entry<String, Profile.Section> e : this.sections) {
            Profile.Section section = e.getValue();
            System.out.println("[" + section.getName() + "]");

            Set<Map.Entry<String, String>> values = section.entrySet(); /* !!! */
            for (Map.Entry<String, String> e2 : values) {
                if (!e2.getKey().startsWith("!")){
                    System.out.println(e2.getKey() + " = " + e2.getValue());
                }
            }
        }
    }
}
