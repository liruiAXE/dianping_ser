package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
public class CategoryDaoImp extends BaseDao implements CategoryDao {


    public List<Category> getCategoryList() {
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        List<Category> result=null;
        try {
            connection=getConn();
            statement=connection.createStatement();
            resultSet=statement.executeQuery("SELECT category_id ,COUNT(category_id) number from product GROUP BY category_id ORDER BY category_id");
            result=new ArrayList<Category>();
            while (resultSet.next()){
                Category category=new Category();
                category.setCategoryId(resultSet.getString("category_id"));
                category.setCategoryNum(resultSet.getInt("number"));
                result.add(category);
            }
        } catch (Exception e){
            e.printStackTrace();
            return null;
        } finally {
            close(resultSet,statement,connection);
        }
        return result;
    }

    public int getCategoryTotal() {
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        int tot=-1;
        try{
            connection=getConn();
            statement=connection.createStatement();
            resultSet=statement.executeQuery("SELECT COUNT(category_id) sum from product ");
            if (resultSet.next()){
                tot=resultSet.getInt("sum");
            }
        } catch (Exception e){
            e.printStackTrace();
            return -1;
        } finally {
            close(resultSet,statement,connection);
        }
        return tot;

    }
}
