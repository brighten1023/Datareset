public class CleanSub {

    public static String getLastTwo(String cate){
        String S = "";
        String[] s = cate.split(">");
        try{
            S = s[s.length-2] + ">" + s[s.length-1];
        }catch (ArrayIndexOutOfBoundsException e){
            return cate;
        }
        return S;
    }
}
