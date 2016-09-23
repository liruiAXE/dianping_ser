package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Administrator on 2016/9/14 0014.
 */
public interface Dao {
    Connection getConn() throws Exception;
    void close (ResultSet res, Statement stm,Connection conn) throws Exception;
}
