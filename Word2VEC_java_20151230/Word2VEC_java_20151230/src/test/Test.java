package test;

import java.io.IOException;

import com.ansj.vec.Word2VEC;

public class Test {
    public static void main(String[] args) throws IOException {
        Word2VEC w1 = new Word2VEC() ;
        w1.loadGoogleModel("vectors.bin") ;
        
        System.out.println(w1.distance("笔记本"));
        
        System.out.println(w1.distance("毛泽东"));
        
        System.out.println(w1.distance("邓小平"));
        
        
        System.out.println(w1.distance("魔术队"));
        
        System.out.println(w1.distance("魔术"));
        
    }
}
