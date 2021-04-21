import java.util.HashSet;
import java.util.Locale;

public class CleanAttribute {
    public static String getAttr(String attr,HashSet keywords){
        String extrattr = ";";
        String[] s = attr.split(";");
        for (int i = 0; i<s.length;i++){
            if(!keywords.contains(s[i].toLowerCase())){
                extrattr = extrattr + ";" + s[i];
            }
        }
        return extrattr;
    }
}
