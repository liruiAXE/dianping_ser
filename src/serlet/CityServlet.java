package serlet;

import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.HttpServer;
import database.City;
import database.CityDao;
import database.CityDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;



/**
 * Created by Administrator on 2016/9/14 0014.
 */

public class CityServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out=resp.getWriter();
        CityDao dao=new CityDaoImpl();
        List<City> list=dao.getCity();
        if (list==null){
            out.println("list==null");
        }
        ResponseObject result=null;
        if (list!=null && list.size()>0){
            result=new ResponseObject(1,list);
        } else {
            out.println("0");
            result=new ResponseObject(0,"没有城市数据");
        }

//        for (int i=0;i<list.size();i++){
//            out.println(list.get(i).toString());
//        }
        String jsonString=new GsonBuilder().create().toJson(result);
        System.out.println("jsonString:     "+jsonString);
        out.println(jsonString);

        out.flush();
        out.close();
    }

}
