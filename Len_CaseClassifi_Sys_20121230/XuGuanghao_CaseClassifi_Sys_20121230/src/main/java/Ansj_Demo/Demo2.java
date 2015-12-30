package Ansj_Demo;

import java.io.FileReader;
import java.io.LineNumberReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by XGHJOB on 2015/10/20.
 */
public class Demo2 {
    public static void main(String[] args) throws Exception{
        Connection conn = null;
        String sql;
        String url = "jdbc:mysql://localhost:3306/test?"
                + "user=root&password=mysql&useUnicode=true&characterEncoding=gbk";
        try
        {
            com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
            System.out.println("成功加载MySQL驱动程序");
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            sql ="create table test2(ID INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,text varchar(200),ansj varchar(200),primary key(ID))";
            int result = stmt.executeUpdate(sql);
            FileReader fr = new FileReader("Demo.txt" );
            //Demo.txt编码格式应该是ANSI,IDEA的格式为UTF-8,
            //可以正常读取显示，原因未知
            LineNumberReader lnr = new LineNumberReader(fr);
            //采用 LineNumberReader来读写以便获得行数，没有采用缓冲区
            //BufferedReader bufr = new BufferedReader(fr);
            String line = null;
            //lnr.setLineNumber(100);
            if (result != -1)
            {
                System.out.println("创建数据表成功");
                while((line = lnr.readLine()) != null)
                {

                    sql = "insert into test.test2(text,ansj) values('"+line.toString()+"','"+line.toString()+"')";
                    result = stmt.executeUpdate(sql);
                    System.out.println(lnr.getLineNumber()+":"+line);
                }
                System.out.println("Mysql表已经创建完成了");
                lnr.close();
            }
        }
        catch (Exception e)
        {
            System.out.println("Mysql操作错误");
            Statement stmt = conn.createStatement();
            sql = "drop table test2";
            int result = stmt.executeUpdate(sql);
            System.out.println("已经删除原有表");

        }
        finally
        {
            conn.close();

        }
    }
}