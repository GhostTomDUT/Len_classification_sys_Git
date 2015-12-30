package Ansj_Demo;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.ansj.util.FilterModifWord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by XGHJOB on 2015/12/28.
 */
public class join_one_line {
    public static void main(String[] args) throws Exception{
        FileReader fr = new FileReader("corpus/stopwords.txt" );
        LineNumberReader lnr = new LineNumberReader(fr);
        String line = null;
        List<String> ls = new ArrayList<String>();
        while((line = lnr.readLine()) != null) {
            ls.add(line);
        }
        System.out.print("停用词加载完成");
        FilterModifWord.insertStopWords(ls);
        //停用词加载
        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("corpus/alldata_wechat_toge.txt")));
        FileReader fr2 = new FileReader("corpus/alldata_wechat(2).txt" );
        LineNumberReader lnr2 = new LineNumberReader(fr2);
        String line2 = null;
        System.out.print("开始洗脑");
        while((line2 = lnr2.readLine()) != null){
            List y = ToAnalysis.parse(line2);
            List<Term> x = FilterModifWord.modifResult(y);
            String s1 = x.toString();
            s1 = s1.replaceAll("\r","");
            s1 = s1.replaceAll("/[a-z][a-z]","");
            s1 = s1.replaceAll("/[a-z]","");
            s1 = s1.replaceAll("A","a");
            s1 = s1.replaceAll("B","b");
            s1 = s1.replaceAll("C","c");
            s1 = s1.replaceAll("D","d");
            s1 = s1.replaceAll("E","e");
            s1 = s1.replaceAll("F","f");
            s1 = s1.replaceAll("G","g");
            s1 = s1.replaceAll("H","h");
            s1 = s1.replaceAll("I","i");
            s1 = s1.replaceAll("G","g");
            s1 = s1.replaceAll("K","k");
            s1 = s1.replaceAll("L","l");
            s1 = s1.replaceAll("M","m");
            s1 = s1.replaceAll("N","n");
            s1 = s1.replaceAll("O","o");
            s1 = s1.replaceAll("P","p");
            s1 = s1.replaceAll("Q","q");
            s1 = s1.replaceAll("R","r");
            s1 = s1.replaceAll("S","s");
            s1 = s1.replaceAll("T","t");
            s1 = s1.replaceAll("U","u");
            s1 = s1.replaceAll("V","v");
            s1 = s1.replaceAll("W","w");
            s1 = s1.replaceAll("X","x");
            s1 = s1.replaceAll("Y","y");
            s1 = s1.replaceAll("Z","z");
            s1 = s1.replaceAll("\n","");
            s1 = s1.replaceAll("  ,","");
            s1 = s1.replaceAll(",","");
            s1 = s1.replaceAll("\\[","");
            s1 = s1.replaceAll("\\]","");
            bufw.write(s1);
            bufw.newLine();
            bufw.flush();
        }
        lnr.close();
        System.out.print(3);
    }
}