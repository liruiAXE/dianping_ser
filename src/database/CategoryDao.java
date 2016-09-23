package database;

import java.util.List;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
public interface CategoryDao {
    List<Category> getCategoryList();
    int getCategoryTotal();
}
