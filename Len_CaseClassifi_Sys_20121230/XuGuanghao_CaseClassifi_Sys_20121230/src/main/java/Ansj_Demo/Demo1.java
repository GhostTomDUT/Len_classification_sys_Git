package Ansj_Demo;
import org.ansj.splitWord.analysis.ToAnalysis;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.List;
/**
 * Created by XGHJOB on 2015/10/20.
 */
public class Demo1 {
    public static void main(String[] args) throws Exception{
        FileReader fr = new FileReader("H:\\Data_Mining\\Java\\workspace\\XuGuanghao_CaseClassifi_Sys_W3\\Data\\tf-idf\\b.txt" );
        //Demo.txt编码格式应该是ANSI,IDEA的格式为UTF-8,
        //可以正常读取显示，原因未知
        LineNumberReader lnr = new LineNumberReader(fr);
        //采用 LineNumberReader来读写以便获得行数，没有采用缓冲区
        //BufferedReader bufr = new BufferedReader(fr);
        String line = null;
        //lnr.setLineNumber(100);
        while((line = lnr.readLine()) != null){
          //  System.out.println(line);
            List x = ToAnalysis.parse(line);
            String s1 = x.toString();
            System.out.println(x.toString());
            s1 = s1.substring(3, s1.length() - 1);
            s1 = s1.replaceAll(" ","");
            s1 = s1.replaceAll("  ","");
            s1 = s1.replaceAll("\n\r","");
            System.out.println(s1);
        }

     //   bufr.close();
        lnr.close();
    }
}