package test;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import love.cq.util.IOUtil;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;


public class prework_w2v  {


        public static final String TAG_START_CONTENT = "<content>";
        public static final String TAG_END_CONTENT = "</content>";

        public static void main(String[] args) {
            String temp = null ;

            BufferedReader reader = null;
            PrintWriter pw = null;
            try {
                reader = IOUtil.getReader("corpus/alldata_wechat_toge", "UTF-8") ;
                ToAnalysis.parse("test 123 孙") ;
                pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream
                        ("corpus/resultbig.txt"), "UTF-8"), true);
                long start = System.currentTimeMillis()  ;
                int allCount =0 ;
                int termcnt = 0;
                Set<String> set = new HashSet<String>();
                while((temp=reader.readLine())!=null){
                    temp = temp.trim();
                    if (temp.startsWith(TAG_START_CONTENT)) {
                        int end = temp.indexOf(TAG_END_CONTENT);
                        String content = temp.substring(TAG_START_CONTENT.length(), end);
                        //System.out.println(content);
                        if (content.length() > 0) {
                            allCount += content.length() ;
                            List<Term> result = ToAnalysis.parse(content);
                            for (Term term: result) {
                                String item = term.getName().trim();
                                if (item.length() > 0) {
                                    termcnt++;
                                    pw.print(item.trim() + " ");
                                    set.add(item);
                                }
                            }
                            pw.println();
                        }
                    }
                }
                long end = System.currentTimeMillis() ;
                System.out.println("共" + termcnt + "个term，" + set.size() + "个不同的词，共 "
                        +allCount+" 个字符，每秒处理了:"+(allCount*1000.0/(end-start)));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (null != reader) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (null != pw) {
                    pw.close();
                }
            }
        }
    }