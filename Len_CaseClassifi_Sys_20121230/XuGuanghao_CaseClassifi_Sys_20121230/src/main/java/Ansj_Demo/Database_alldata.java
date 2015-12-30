package Ansj_Demo;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by XGHJOB on 2015/12/16.
 */
public class Database_alldata {

    public static void main(String[] args) throws Exception{
        int num = 0;
        int Id_x = 0;
        int downmark =0;
        int upmark = 3000000;
        List storehouse= new ArrayList();
        Connection conn = null;
        String sql;
        String url = "jdbc:mysql://localhost:3306/case_xu?"
                + "user=root&password=123456&useUnicode=true&characterEncoding=utf8";
        try
            {
                com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
                System.out.println("成功加载MySQL驱动程序");
                conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
//                sql = "UPDATE alldata set Case_detail = replace (Case_detail,'''',' ') ";
//                System.out.println(sql);
//                stmt.executeQuery(sql);
                for (int i = downmark;i < upmark/100;i++)
                {
                    sql = "select * from alldata limit "+ i*100+","+100;
                    System.out.println(sql);
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
                            System.out.println("num="+num);
                         }
                    for (int x = 0; x <100; x++)
                        {
                            System.out.println("Id_x="+Id_x);

                            List<Term> words = ToAnalysis.parse(storehouse.get(x).toString());
                            sql = "update alldata set Result_split='" + words + "'where Id =" + (Id_x+1);
                            System.out.println(sql);
                            stmt.executeUpdate(sql);
                            Id_x++;
                         }
                    storehouse.clear();
                    System.out.println(result);
                    result=null;
                    System.out.println(result);
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