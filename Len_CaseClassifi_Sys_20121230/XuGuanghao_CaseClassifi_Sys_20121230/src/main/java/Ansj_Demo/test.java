package Ansj_Demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XGHJOB on 2015/12/16.
 */
public class test {
    public static void main(String[] args) throws Exception {
    List mylist = new ArrayList();
        mylist.add("a");
        mylist.add("b");
        System.out.println(mylist.get(1).toString());
        mylist.clear();
        mylist.add("c");
        System.out.println(mylist.get(0).toString());

    }

}
