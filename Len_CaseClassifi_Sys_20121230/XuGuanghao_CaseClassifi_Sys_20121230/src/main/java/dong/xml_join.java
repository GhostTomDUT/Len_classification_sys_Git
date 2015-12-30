package dong;

import java.io.*;

/**
 * Created by XGHJOB on 2015/12/1.
 */
public class xml_join {
    public static void main(String[] args) throws IOException {
     int x = 1;
    BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\data\\result.xml")));
    for(;x < 8801;x++) {
        String line = null;
        FileInputStream fis = new FileInputStream("D:\\data\\1 ("+x+").xml");
        BufferedReader bufr = new BufferedReader(new InputStreamReader(fis));
        System.out.println(fis.toString());
        while ((line = bufr.readLine()) != null) {
            System.out.println(line);
            System.out.println(x);
            bufw.write(line);
            bufw.newLine();
            bufw.flush();
        }
       // bufr.close();
    }
    }
}
