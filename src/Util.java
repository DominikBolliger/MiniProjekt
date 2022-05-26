import java.io.File;
import java.util.ArrayList;

public class Util {

    private static final String INI_FILE = ":\\OPMS\\Zeag\\opms.ini";

    public static String getIniFilePath(){
        String ret = "";
        File fC = new File("C" + INI_FILE);
        File fD = new File("D" + INI_FILE);
        if(fC.isFile()) {
            ret = "C" + INI_FILE;
        }
        else if(fD.isFile()) {
            ret = "D" + INI_FILE;
        }
        else {
            System.out.println("There is no OPMS.ini file..");
            System.exit(0);
        }
        return ret;
    }

    public static void formatter(int characters){
        System.out.println();
        System.out.println("-".repeat(characters));
        System.out.println();
    }
}

