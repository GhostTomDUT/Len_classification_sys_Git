package zhou;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by XGHJOB on 2015/11/7.
 */
public class MainTest {

    public static void main(String[] args) throws IOException {
        String line2 = null;
        Map<String, HashMap<String, Integer>> normal = MainDoc.NormalTFOfAll("D:\\data");
        for (String filename : normal.keySet()) {
            System.out.println("fileName " + filename);
            //System.out.println("TF " + normal.get(filename).toString());
            BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename,true),"UTF-8"));
            line2= normal.get(filename).toString();
            bufw.write(line2);
            bufw.newLine();
            bufw.flush();

        }
        System.out.println("-----------------------------------------");

        Map<String, Float> idf = MainDoc.idf("D:\\data");
        System.out.print(idf.keySet()+"\n");
        for (String word : idf.keySet()) {
            System.out.println("keyword :" + word + " idf: " + idf.get(word));
        }

    }
}
