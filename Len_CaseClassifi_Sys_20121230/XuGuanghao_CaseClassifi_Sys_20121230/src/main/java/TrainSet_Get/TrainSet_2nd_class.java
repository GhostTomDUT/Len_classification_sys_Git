package TrainSet_Get;

import java.io.FileReader;
import java.io.LineNumberReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by XGHJOB on 2015 /11/23.
 */
public class TrainSet_2nd_class {

    public static void main(String[] args) throws Exception{
        String url = "jdbc:sqlserver://localhost:1433; DatabaseName=Case分类语料库";
        String userName = "Java_user";
        String userPwd = "123456";
        String sql;
        int result ;
        //ResultSet context = null;
        Connection conn =null;
        try
        {
            com.microsoft.sqlserver.jdbc.SQLServerDriver driver = new com.microsoft.sqlserver.jdbc.SQLServerDriver();
            System.out.println("成功加载SQL Server驱动程序");
            conn = DriverManager.getConnection(url, userName, userPwd);
            System.out.println("Connection Successful!");
            Statement stmt = conn.createStatement();
            FileReader frb = new FileReader("H:\\Data_Mining\\Java\\workspace\\XuGuanghao_CaseClassifi_Sys_W4\\Data\\b1.csv" );
            LineNumberReader lnrb = new LineNumberReader(frb);
            String lineb = null;
            while((lineb = lnrb.readLine())!= null)
            {
                System.out.println("lineb="+lineb+"/over");
                System.out.println("lineb="+lineb);
                sql = "update Case分类语料库.dbo.Case文本语料库 set Categ_Marked = '"
                            +lineb+"',Model_Lang = '"+lineb+"'where Case_detail like '%"+lineb+"%'";
                    result = stmt.executeUpdate(sql);
            }

            System.out.println("类别已经标注完成了");
            lnrb.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("存在操作错误");
            System.out.println("已经停止了");

        }
        finally
        {
            conn.close();

        }
    }
}
