package serviceImpl;

import bean.UsersEntity;
import db.dbConnection;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import service.Properties;
import service.User;
import java.util.List;
import java.util.Map;

/**
 * Created by zzyo on 2016/5/28.
 */
/*@Service("userService")*/
public class UserImpl implements User {


    Properties prop = new PropertiesImpl();
    private Map<String,String> entry = prop.getProperties("message.properties");

    @Override
    public String register(UsersEntity usersEntity) {
        String err_mess = vaildRegist(usersEntity);

       if(err_mess == entry.get("reg_not"))
       {
           Session session = dbConnection.getSession();
           Transaction transaction = session.beginTransaction();
           session.save(usersEntity);
           transaction.commit();
           transaction = null;
           session.close();
           return entry.get("reg_success");
       }
        else
       {
           return err_mess;
       }
    }

    @Override
    public String login(UsersEntity usersEntity) {

        Transaction transaction = null;
        String hql = "";
        Session session = dbConnection.getSession();
        transaction = session.beginTransaction();
        hql = "from bean.UsersEntity where email = ? and upass = ?";
        Query query = session.createQuery(hql);
        query.setParameter(0,usersEntity.getEmail());
        query.setParameter(1,usersEntity.getUpass());
        List list = query.list();
        transaction.commit();
        transaction = null;
        if(list.size()>0)
        {
            return entry.get("login_success");
        }
        else
        {
            return entry.get("login_fail");
        }
    }

    @Override
    public String logout(UsersEntity usersEntity) {
        return entry.get("logout_success");
    }

    @Override
    public String vaildRegist(UsersEntity usersEntity) {
        Transaction transaction = null;
        String hql = "";
        Session session = dbConnection.getSession();
        transaction = session.beginTransaction();
        hql = "from bean.UsersEntity where email = ? or mac = ?";
        Query query = session.createQuery(hql);
        query.setParameter(0,usersEntity.getEmail());
        query.setParameter(1,usersEntity.getMac());
        List list = query.list();
        transaction.commit();
        transaction = null;
        if(list.size()>0)
        {
            return entry.get("reg_had");
        }
        else
        {
            return entry.get("reg_not");
        }
    }
}
