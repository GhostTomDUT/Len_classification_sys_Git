package TrainSet_Get;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by xujob on 15-12-16.
 */
public class TrainSet_get_linux {
        public static void main(String[] args) throws Exception{
            Connection conn = null;
            String url = "jdbc:mysql://localhost:3306/case_xu?"
                    + "user=root&password=123456&useUnicode=true&characterEncoding=utf8";
            String sql;
            int result ;
            //ResultSet context = null;
            try
            {
                com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
                System.out.println("成功加载MySQL驱动程序");
                conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
                FileReader frk = new FileReader("/home/xujob/Documents/XuGuanghao_CaseClassifi_Sys_W4/Data/kw.txt" );
                FileReader frb = new FileReader("/home/xujob/Documents/XuGuanghao_CaseClassifi_Sys_W4/Data/bw.txt" );

                LineNumberReader lnrk = new LineNumberReader(frk);
                LineNumberReader lnrb = new LineNumberReader(frb);

                String linek = null;
                String lineb = null;

                while((linek = lnrk.readLine())!= null)
                {
                    System.out.println("linek="+linek+"/over");

                    if (linek.endsWith("1"))
                    {
                        System.out.println("目前开头是1");
                        lineb = lnrb.readLine();
                        linek = lnrk.readLine();
                        sql = "update alldata set Caterg_2nd = '"
                                +lineb+"',Caterg_3rd = '"+linek+"'where Case_detail like '%"+linek+"%'";
                        System.out.println(sql);
                        result = stmt.executeUpdate(sql);
                    }

                    else
                    {
                        System.out.println("目前开头不是1");
                        sql = "update alldata set Caterg_2nd = '"
                                +lineb+"',Caterg_3rd = '"+linek+"'where Case_detail like '%"+linek+"%'";
                        result = stmt.executeUpdate(sql);
                        System.out.println(sql);
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
