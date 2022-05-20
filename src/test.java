import java.util.ArrayList;
import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        System.out.print(FirstFactorial(new String[] {"1, 5, 6, 7, 10, 11, 12", "5, 6, 8, 11, 17"}));
    }

    private static String FirstFactorial(String[] strArr) {
        String ret = "";
        String[] first = strArr[0].replace(",", "").split(" ");
        String[] second = strArr[1].replace(",", "").split(" ");
        if (first.length < second.length){
            for (int i = 0; i < first.length; i++) {
                if (Arrays.stream(first).anyMatch(second[i]::equals)){
                    ret += second[i] + ",";
                }
            }
        } else{
            for (int i = 0; i < second.length; i++) {
                if (Arrays.stream(second).anyMatch(first[i]::equals)){
                    ret += first[i] + ",";
                }
            }
        }
        System.out.println(ret);
        return ret.substring(0, ret.length() -1);
    }
}
