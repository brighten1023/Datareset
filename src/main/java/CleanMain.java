import java.io.*;
import java.util.HashSet;

public class CleanMain {
    public static void main(String[] args){
        //String str = args[0];
        HashSet<String> keywords = new HashSet<String>();
            keywords.add("category code");
            keywords.add("title");
            keywords.add("subtitle");
            keywords.add("description");
            keywords.add("imgsrc");
            keywords.add("modeltype");
            keywords.add("status");
            keywords.add("size");
            keywords.add("weight");
            keywords.add("availabledate");
            keywords.add("curprice");
            keywords.add("pricehistories");
        try{
            String epagePath = "/home/bright/Documents/AmazonScData/e/pageInfo.tsv";
            BufferedReader readerPage = new BufferedReader(new FileReader(epagePath));
            File writeCSV = new File("/home/bright/Documents/AmazonScData/e/CleanedPage.tsv");
            BufferedWriter writeError = new BufferedWriter(new FileWriter(writeCSV,true));
            String linePage = null;
            while((linePage=readerPage.readLine())!=null) {
                String itemPage[] = linePage.split("\t");
                String subCate = CleanSub.getLastTwo(itemPage[0]);
                String subCode = CleanCatecode.getCode(itemPage[1]);
                if(subCode.equals("!")){
                    continue;
                }
                String itemAttrSet = "";
                for (int i=3;i<itemPage.length;i++){
                    if(!itemPage[i].equals("N/A")) {
                        itemAttrSet = itemAttrSet + itemPage[i];
                    }
                }
                String itemAttr = CleanAttribute.getAttr(itemAttrSet,keywords);
                writeError.write(subCate+"\t"+subCode+"\t"+itemAttr);
                writeError.flush();
                writeError.newLine();
            }
            System.out.println("All error reset!!!!!!");
            writeError.close();
            readerPage.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
