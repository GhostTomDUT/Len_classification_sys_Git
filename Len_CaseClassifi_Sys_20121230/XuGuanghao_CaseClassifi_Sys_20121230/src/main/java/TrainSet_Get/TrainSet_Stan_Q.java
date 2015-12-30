package TrainSet_Get;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by XGHJOB on 2015/11/18.
 */
public class TrainSet_Stan_Q {
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
            FileReader frk = new FileReader("H:\\Data_Mining\\Java\\workspace\\XuGuanghao_CaseClassifi_Sys_W4\\Data\\k1.csv" );
            FileReader frb = new FileReader("H:\\Data_Mining\\Java\\workspace\\\\XuGuanghao_CaseClassifi_Sys_W4\\Data\\b1.csv" );
            File path=new File("D:\\test");//新建的数据集的保存位置

            LineNumberReader lnrk = new LineNumberReader(frk);
            LineNumberReader lnrb = new LineNumberReader(frb);
                //采用 LineNumberReader来读写以便获得行数，没有采用缓冲区
                //BufferedReader bufr = new BufferedReader(fr);
            String linek = null;
            String lineb = null;
                //lnr.setLineNumber(100);
    //            if (result != -1)
    //            {
    //                System.out.println("创建数据表成功");
            while((linek = lnrk.readLine())!= null)
            {
                System.out.println("linek="+linek+"/over");

                if (linek.endsWith("1"))
                {
                    System.out.println("目前开头是1");
                    lineb = lnrb.readLine();
//                    File dir=new File(path,lineb+".txt");
//                    if(!dir.exists()){
//                        dir.createNewFile();
//                        System.out.println("训练集创建成功");
//                    }
                    System.out.println("lineb="+lineb);
                    sql = "update Case分类语料库.dbo.Case文本语料库 set Categ_2nd = '"
                            +lineb+"',Categ_3rd = '"+lineb+"'where Case_detail like '%"+lineb+"%'";
                    result = stmt.executeUpdate(sql);
//                    context = stmt.executeQuery(sql);
//                    OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(lineb+".txt"),"UTF-8");
//                    System.out.println(context.toString());
//                    osw.write(context.toString());
//                    osw.flush();

                    linek = lnrk.readLine();
                    sql = "update Case分类语料库.dbo.Case文本语料库 set Categ_2nd = '"
                            +lineb+"',Categ_3rd = '"+linek+"'where Case_detail like '%"+linek+"%'";
                    result = stmt.executeUpdate(sql);
//                    context = stmt.executeQuery(sql);
//                    osw.write(context.toString());
//                    osw.flush();

                }

                else
                {
                    System.out.println("目前开头不是1");
                    sql = "update Case分类语料库.dbo.Case文本语料库 set Categ_2nd = '"
                            +lineb+"',Categ_3rd = '"+linek+"'where Case_detail like '%"+linek+"%'";
                    result = stmt.executeUpdate(sql);
//                    context = stmt.executeQuery(sql);
//                    OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(lineb+".txt"),"UTF-8");
//                    osw.write(context.toString());
//                    osw.flush();
                }
            }
            System.out.println("类别已经标注完成了");
            lnrk.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("存在操作错误");
//            Statement stmt = conn.createStatement();
//            sql = "drop table test2";
//            result = stmt.executeUpdate(sql);
            System.out.println("已经停止了");

        }
        finally
        {
            conn.close();

        }
    }
}
