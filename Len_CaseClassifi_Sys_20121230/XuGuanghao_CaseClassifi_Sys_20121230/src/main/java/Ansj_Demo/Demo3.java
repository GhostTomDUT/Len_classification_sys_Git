package Ansj_Demo;

import org.ansj.splitWord.analysis.ToAnalysis;

import java.io.FileReader;
import java.io.LineNumberReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

/**
 * Created by XGHJOB on 2015/10/20.
 */
public class Demo3 {
    public static void main(String[] args) throws Exception{
        Connection conn =null;
        String sql;
        String url = "jdbc:sqlserver://localhost:1433; DatabaseName=Test";
        String userName = "Java_user";
        String userPwd = "123456";
        try
        {
            com.microsoft.sqlserver.jdbc.SQLServerDriver driver = new com.microsoft.sqlserver.jdbc.SQLServerDriver();
            System.out.println("成功加载SQL Server驱动程序");
            conn = DriverManager.getConnection(url, userName, userPwd);
            System.out.println("Connection Successful!");
            Statement stmt = conn.createStatement();
            sql ="create table test2(ID int primary key not null identity (1,1),text varchar(1000),ansj varchar(1000))";
            int result = stmt.executeUpdate(sql);
            FileReader fr = new FileReader("Demo1.txt" );
            //Demo.txt编码格式应该是ANSI,IDEA的格式为UTF-8,//sql server不存在这个情况
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
                //    System.out.println("1");
                    List x = ToAnalysis.parse(line);
               //     System.out.println("2");
                    sql = "insert into Test.dbo.test2(text,ansj) values('"+line.toString()+"','"+x.toString()+"')";
                //    System.out.println("3");
                    result = stmt.executeUpdate(sql);
                 //   System.out.println("4");
                    System.out.println(lnr.getLineNumber()+":"+line+":"+x);
                 //   System.out.println("5");
                }
                System.out.println("sql server表已经创建完成了");
                lnr.close();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("存在操作错误");
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