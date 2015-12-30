package Ansj_Demo;

import org.ansj.splitWord.analysis.*;

import java.util.List;


/**
 * Created by XGHJOB on 2015/10/20.
 */
public class ansjdemo {

        public static void main(String[] args)
        {
            String words = "中国是世界四大文明古国之一.";
            List x =ToAnalysis.parse(words);
            System.out.println(x.toString());
            x.add(1,1);
            System.out.println(x.toString());
        }

    }
