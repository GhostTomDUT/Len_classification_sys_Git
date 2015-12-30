package main.java.Ansj_Demo;

import org.ansj.domain.Term;
import org.ansj.recognition.NatureRecognition;
import org.ansj.splitWord.analysis.*;

import java.util.List;
import org.ansj.util.FilterModifWord;

/**
 * Created by XGHJOB on 2015/10/20.
 */
public class Demo4 {

    public static void main(String[] args)
    {
//        String words = "中国是世界四大文明古国之一的的的。";
//        List x =ToAnalysis.parse(words);
//        System.out.println(x.toString());
//        List y =  FilterModifWord.modifResult(x);
//        System.out.println(y.toString());
//        List  parseResultList = ToAnalysis.parse("your五一，不然劳动节快乐");
//        System.out.println(parseResultList);
//        List parseResultList2 = FilterModifWord.modifResult(parseResultList);
//        System.out.println(parseResultList2);

                //加入停用词
        FilterModifWord.insertStopWord("的") ;
                //加入过滤词性词性
        FilterModifWord.insertStopNatures("v") ;
        List<Term> words =  ToAnalysis.parse("中国是世界上的四大文明古国之一。");
        new NatureRecognition(words).recognition() ;
        System.out.println(words);//修正词性并且过滤停用
        List<Term> parse = FilterModifWord.modifResult(words);
        System.out.println(parse);

            }
        }
