package main.java.Word_Freq;
        import java.util.HashMap;
        import java.util.Map;
        import java.util.*;
        import java.io.*;
public class Words_Freq {
    public static void main(String[] args) throws Exception {
        Map hashMap = null;
        BufferedReader infile = null;
        StringTokenizer st = null;
        String filename = "Demo3.txt";
        String string;
        String file = null;
// 打开一篇文章，名字是Test.txt .
        infile = new BufferedReader(new FileReader(filename));
            while ((string = infile.readLine()) != null) {
                file += string;
//都出整篇文章，存入String 中。
            }
            hashMap = new HashMap();


//取出文章中的单词，"," "." "!" " "为各个单词的分界符。
            st = new StringTokenizer(file, " ,.!");
            while (st.hasMoreTokens()) ;
            String key = st.nextToken();
             if (hashMap.get(key) != null) {
                 int value =((Integer)hashMap.get(key)).intValue();
                     value++;
                    hashMap.put(key, new Integer(value));
    } else {
                hashMap.put(key, new Integer(1));
            }

//按照单词的字母次序输出。
 Map treeMap = new TreeMap(hashMap);
Set entrySet = treeMap.entrySet();
Iterator iterator = entrySet.iterator();
 while (iterator.hasNext()) {
System.out.println(iterator.next());
            }
}
}


