package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/9/14 0014.
 */
public class BaseDao {
    private static String url=null;
    private static String user=null;
    private static String password=null;
    static {
        try {
        ResourceBundle bundle=ResourceBundle.getBundle("config");
        String driver=bundle.getString("driver");
        url=bundle.getString("url");
        user=bundle.getString("user");
        password=bundle.getString("password");
        Class.forName(driver);

      } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    protected Connection getConn() throws Exception{
        return new Inner().getConn();
    }
    protected void close(ResultSet res,Statement stm,Connection conn){
        try{
            new Inner().close(res, stm, conn);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    private class Inner implements Dao {
        public Connection getConn() throws Exception {
            return DriverManager.getConnection(url,user,password);
        }

        public void close(ResultSet res, Statement stm, Connection conn) throws Exception {
            if (res!=null){
                try {
                    res.close();
                    res=null;
                } catch (Exception e){
                    e.printStackTrace();
                }

            }
            if (stm!=null){
                try {
                    stm.close();
                    stm=null;
                } catch (Exception e2){
                    e2.printStackTrace();
                }

            }
            if (conn!=null){
                try{
                    conn.close();
                    conn=null;
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
