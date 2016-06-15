package controller;

import bean.UsersEntity;
import db.dbConnection;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zzyo on 2016/5/27.
 */
@Controller
@RequestMapping("/")
public class common {

    /*@Resource
    private User userService;*/

    @RequestMapping(value = "listusers", method = RequestMethod.GET)
    public String listusers(ModelMap map) {
        Session session = dbConnection.getSession();
        List<UsersEntity> usersEntityList = session.createCriteria(UsersEntity.class).list();
        map.addAttribute("users", usersEntityList);
        session.close();
        return "listusers";
    }

    @RequestMapping(value = "regist", method = RequestMethod.GET)
    public String getRegist() {
        return "regist";
    }

    @RequestMapping(value = "regist", method = RequestMethod.POST)
    @ResponseBody
    public Object regist(@RequestBody UsersEntity usersEntity) {
            /*System.out.println(usersEntity.toString());
            UsersEntity users =  new UsersEntity("zzyo","zzyo","1111@qq.com","1111");
            User newuser = new UserImpl();
            System.out.println(newuser.register(users));*/
        String code = doRegister(usersEntity);
        System.out.println(code);
        Map map=new HashMap();
        map.put("code", code);
        return map;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String getLogin() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Object login(@RequestBody UsersEntity usersEntity) {
        /*usersEntity.setUid(9);
        usersEntity.setUname("zzyo");
        usersEntity.setMac("11111111111111111");
        System.out.println(usersEntity.toString());*/
       /* UsersEntity usersEntity1 =  new UsersEntity("zzyo","zzyo","zzyo199@qq.com","221");*/
        /*System.out.println(usersEntity.toString());
        User user = new UserImpl();
        user.login(usersEntity);*/
        /*System.out.println(user.login(usersEntity));*/
        /*System.out.println(userService.login(usersEntity));*/
        String code = vaildLogin(usersEntity);
        System.out.println(code);
        Map map=new HashMap();
        map.put("code", code);
        return map;
    }


    public String vaildLogin(UsersEntity usersEntity) {

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
            return "login_success";
        }
        else
        {
            return "login_fail";
        }
    }

    public String doRegister(UsersEntity usersEntity) {
        String err_mess = vaildRegist(usersEntity);

        if(err_mess == "reg_not")
        {
            Session session = dbConnection.getSession();
            Transaction transaction = session.beginTransaction();
            session.save(usersEntity);
            transaction.commit();
            transaction = null;
            session.close();
            return "reg_success";
        }
        else
        {
            return err_mess;
        }
    }

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
            return "reg_had";
        }
        else
        {
            return "reg_not";
        }
    }


}
