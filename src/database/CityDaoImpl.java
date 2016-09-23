package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/14 0014.
 */
public class CityDaoImpl extends BaseDao implements CityDao {
    public List<City> getCity() {
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        List<City> cities=new ArrayList<City>();
        try{
            connection=getConn();
            statement=connection.createStatement();
            resultSet=statement.executeQuery("SELECT * FROM city ORDER BY city_sortkey");
            while (resultSet.next()){
                City city=new City();
                city.setCity_id(resultSet.getString("city_id"));
                city.setCity_name(resultSet.getString("city_name"));
                city.setCity_sortkey(resultSet.getString("city_sortkey"));
                System.out.println(city.toString());
                cities.add(city);
            }
        } catch (Exception e){
            e.printStackTrace();
            return null;
        } finally {
            close(resultSet,statement,connection);
        }
        System.out.println("list size= "+cities.size());
        return cities;
    }
}
