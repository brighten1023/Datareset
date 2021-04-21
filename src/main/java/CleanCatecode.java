public class CleanCatecode {
    public static String getCode(String code){
        String laststring;
        try {
            String newstring = code.substring(code.indexOf("?") + 1, code.indexOf("&dc&"));
            laststring = newstring.replace("%2Cn%3A", ":").replace("&rh=n%3A", ":");
        }catch (StringIndexOutOfBoundsException e){
            return "!";
        }
        return laststring;

    }
}
