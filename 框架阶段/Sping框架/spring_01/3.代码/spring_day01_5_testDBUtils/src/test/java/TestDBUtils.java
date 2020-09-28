import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class TestDBUtils {


    @Test
    public void testFindAll(){
        UserDao userDao = new UserDao();
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            System.out.println(user.getUsername());
        }
    }

    @Test
    public void testFindById(){
        UserDao userDao = new UserDao();
        User user = userDao.findById(1);
        System.out.println(user.getUsername());
    }

    @Test
    public void testSave() {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setUsername("李璐");
        user.setBirthday(new Date());
        user.setAddress("北京");
        user.setSex("女");

        userDao.save(user);
    }
    @Test
    public void testUpdate() {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setId(14);
        user.setUsername("李璐");
        user.setBirthday(new Date());
        user.setAddress("北京");
        user.setSex("男");

        userDao.update(user);
    }

    @Test
    public void testDel() {
        UserDao userDao = new UserDao();
        userDao.del(13);
    }

    @Test
    public void testgetTotalCount() {
        UserDao userDao = new UserDao();
        Long totalCount = userDao.getTotalCount();
        System.out.println(totalCount);
    }
}
