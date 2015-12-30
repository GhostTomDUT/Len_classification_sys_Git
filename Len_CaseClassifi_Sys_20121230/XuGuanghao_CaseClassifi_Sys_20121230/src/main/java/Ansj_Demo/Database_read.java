package Ansj_Demo;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.io.FileReader;
import java.io.LineNumberReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by XGHJOB on 2015/12/16.
 */
public class Database_read {

    public static void main(String[] args) throws Exception{
        int num = 0;
        List storehouse= new ArrayList(num);
        Connection conn = null;
        String sql;
        String url = "jdbc:mysql://localhost:3306/case_record_mysql?"
                + "user=root&password=mysql&useUnicode=true&characterEncoding=utf8";
        try
        {
            com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
            System.out.println("成功加载MySQL驱动程序");
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            sql ="select * from alldata limit 0,1000";
            ResultSet result = stmt.executeQuery(sql);

            while (result.next())//这里写的是while，报错java.sql.SQLException: Operation not allowed after ResultSet closed。
                //一个可能的解释是while里面 自到了result.close().
                {
                    int Id = result.getInt("Id");
                    String Channel = result.getString("Channel");
                    String Case_detail = result.getString("Case_detail");
                    storehouse.add(Case_detail);
                    //storehouse.add("/");
                    System.out.println(Id + Channel + Case_detail);
                    num++;//数据条数
                    System.out.println(num);
                }
            for(int x = 0;x <num;x++)
            {
                System.out.println(x);
                List<Term> words = ToAnalysis.parse(storehouse.get(x).toString());
                sql = "update alldata set Result_split='" + words + "'where Id =" + (x+1);
                System.out.println(sql);
                stmt.executeUpdate(sql);
            }
        }
        catch (Exception e)
        {
            System.out.println("Mysql操作错误");
//            Statement stmt = conn.createStatement();
//            sql = "drop table test2";
//            int result = stmt.executeUpdate(sql);
//            System.out.println("已经删除原有表");
            e.printStackTrace();
        }
        finally
        {
            conn.close();

        }
    }
}