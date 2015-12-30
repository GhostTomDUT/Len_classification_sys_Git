package Ansj_Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by XGHJOB on 2015/11/9.
 */
public class Demo5 {


        public static void main(String[] args) throws Exception{
            int num = 0;
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
                sql ="select * from alldata limit 1,2";
                ResultSet result = stmt.executeQuery(sql);
                while(result.next()){
                    int Id = result.getInt("Id");
                    String Channel = result.getString("Channel");
                    String Case_detail = result.getString("Case_detail");
                    System.out.println(" " + Id + " " + Channel +" " + Case_detail);
                    num ++;//数据条数
                }

            }
            catch (Exception e)
            {
                System.out.println("Mysql操作错误");
//            Statement stmt = conn.createStatement();
//            sql = "drop table test2";
//            int result = stmt.executeUpdate(sql);
//            System.out.println("已经删除原有表");

            }
            finally
            {
                conn.close();

            }
        }
    }