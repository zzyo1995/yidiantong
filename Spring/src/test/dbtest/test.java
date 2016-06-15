package dbtest;

import bean.RouterEntity;
import bean.UsersEntity;
import controller.common;
import db.dbConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import service.User;
import serviceImpl.UserImpl;

/**
 * Created by zzyo on 2016/5/28.
 */
public class test {

    @Test
    public void testdb()
    {
        UsersEntity usersEntity = new UsersEntity("吴江","test","test@qq.com","20-68-9D-19-64-98");
        UsersEntity usersEntity1 = new UsersEntity("test1","test1","test1@qq.com","20-68-9D-19-64-99");
        RouterEntity routerEntity = new RouterEntity("软件过程管理","15-4D-D3-22-E3");
        RouterEntity routerEntity1 = new RouterEntity("class1","15-4D-D3-22-E5");

        Session session = dbConnection.getSession();

        Transaction transaction = session.beginTransaction();
        session.save(routerEntity);
        session.save(routerEntity1);
        session.save(usersEntity);
        session.save(usersEntity1);
        transaction.commit();

        session.close();
    }

    @Test
    public void testlogin()
    {
        UsersEntity usersEntity =  new UsersEntity("zzyo","zzyo","zzyo1995@qq.com","");
        User newuser = new UserImpl();
        /*System.out.println(newuser.login(usersEntity));*/
    }

    @Test
    public void testRegist()
    {
        UsersEntity usersEntity =  new UsersEntity("zzyo","zzyo","zzyo199@qq.com","221");
        User newuser = new UserImpl();
        System.out.println(newuser.register(usersEntity));
        /*common com = new common();
        System.out.println(com.regist());*/

    }
}
