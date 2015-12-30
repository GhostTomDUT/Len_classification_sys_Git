package zhou;

import TF_IDF.MainDoc;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by XGHJOB on 2015/11/30.
 */
public class Document_split {


    public static void main(String[] args) throws IOException {
        String line = null;
        String line_old = null;
        String regex1 = "\\d{5,6},";
        String regex2 = ",.{0,3},";
        String regex3 = ",*,\\.*";
        String caseid = null;
        String caseid_pre = null;
        String caseid_old = null;
        String name_eng = null;
        String name_eng_pre = null;
        FileInputStream fis = new FileInputStream("D:\\zhou.txt");
        BufferedReader bufr = new BufferedReader(new InputStreamReader(fis));
        while ((line = bufr.readLine()) != null) {
            Pattern p1 = Pattern.compile(regex1);
            Pattern p2 = Pattern.compile(regex2);
            Pattern p3 = Pattern.compile(regex3);
            Matcher m1 = p1.matcher(line);
            Matcher m2 = p2.matcher(line);
            Matcher m3 = p3.matcher(line);
            while (m1.find()) {
                caseid_pre = m1.group();
                caseid = caseid_pre.substring(0, caseid_pre.length() - 1);
                System.out.println(caseid);
            }
            while (m2.find()) {
                name_eng_pre = m2.group();
                name_eng = name_eng_pre.substring(1, name_eng_pre.length() - 1);
                System.out.println(name_eng);
            }
            while (m3.find()) {

            }
            BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\data\\" + caseid + ","+name_eng + ".txt", true), "gbk"));


            bufw.write(line);
            bufw.newLine();
            bufw.flush();
        }
            String line2 = null;
            Map<String, HashMap<String, Integer>> normal = MainDoc.NormalTFOfAll("D:\\data");
            for (String filename : normal.keySet()) {
                System.out.println("fileName " + filename);
                //System.out.println("TF " + normal.get(filename).toString());
                BufferedWriter bufw2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\data\\result.csv", true), "gbk"));
                String filename2 = filename.substring(8);
                line2 = filename2 + normal.get(filename).toString();
                bufw2.write(line2);
                bufw2.newLine();
                bufw2.flush();
            }
    }}