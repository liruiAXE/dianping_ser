package serlet;

import com.google.gson.Gson;
import database.Category;
import database.CategoryDao;
import database.CategoryDaoImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
public class CategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out=resp.getWriter();
        CategoryDao dao=new CategoryDaoImp();
        Category category=new Category();
        category.setCategoryId("0");
        category.setCategoryNum(dao.getCategoryTotal());
        List<Category> list=dao.getCategoryList();
        list.add(category);
        ResponseObject result=null;
        if (list!=null&&list.size()>0){
            result=new ResponseObject(1,list);
        } else {
            result=new ResponseObject(0,"NO RES");
        }
        out.println(new Gson().toJson(result));
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
