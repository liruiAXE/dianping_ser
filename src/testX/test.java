package testX;

import database.*;

import java.util.List;

/**
 * Created by Administrator on 2016/9/14 0014.
 */
public class test {
    public static void main(String[] args){
        CategoryDao categoryDao=new CategoryDaoImp();
        List<Category> list=categoryDao.getCategoryList();
        System.out.println(list.toString());
        int tot=categoryDao.getCategoryTotal();
        System.out.println("total : "+tot);
    }
}
