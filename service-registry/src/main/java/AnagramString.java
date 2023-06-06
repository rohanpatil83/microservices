import javax.xml.transform.sax.SAXResult;
import java.awt.font.FontRenderContext;
import java.util.Arrays;
import java.util.TreeMap;

public class AnagramString {
    static boolean checkAnagram(String str, String str1) {

        if (str.length() == str1.length()) {
            char[] ctr = str.toCharArray();
            char[] ctr1 = str1.toCharArray();
            Arrays.sort(ctr);
            Arrays.sort(ctr1);
            return Arrays.toString(ctr).equals(Arrays.toString(ctr1));
        }
        return false;

    }


    public static void main(String[] args) {
        String str = "silent";
        String str1 = "listen";
        System.out.println(checkAnagram(str, str1));

    }


}
