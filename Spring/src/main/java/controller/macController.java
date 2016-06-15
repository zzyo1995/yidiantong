package controller;

import db.dbConnection;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zzyo on 2016/6/2.
 */
@Controller
public class macController {


    @RequestMapping(value = "/mac",method = RequestMethod.GET)
    public String mac()
    {
        return "mac";
    }


    @RequestMapping(value = "/mac", method = RequestMethod.POST)
    public Object getMAC(@RequestParam String umac, @RequestParam String nmac, @RequestParam String rmac) {
        String name = null;
        name = getName(umac, nmac, rmac);
        System.out.println(name);
        Map map = new HashMap();
        map.put("name", name);
        return map;
    }

    public String getName(String umac, String nmac, String rmac) {
        int uid,rid,nid;
        String rela;
        Transaction transaction = null;
        String hql = "";
        Session session = dbConnection.getSession();
        transaction = session.beginTransaction();

        hql = "select uid from bean.UsersEntity where mac = :umac";
        Query query = session.createQuery(hql);
        query.setParameter("umac", umac);
        List list = query.list();
        uid = (Integer) list.get(0);

        hql = "select uid from bean.UsersEntity where mac = :nmac";
        query = session.createQuery(hql);
        query.setParameter("nmac", nmac);
        list = query.list();
        if (list.size() > 0) {
            nid = (Integer) list.get(0);
        } else {
            return "Unknown Person";
        }

        hql = "select rid from bean.RouterEntity where mac = :rmac";
        query = session.createQuery(hql);
        query.setParameter("rmac", rmac);
        list = query.list();
        rid = (Integer) list.get(0);

        hql = "select rela from bean.UtoR where uid = :uid and nid = :nid and rid = :rid";
        query = session.createQuery(hql);
        query.setParameter("uid", uid);
        query.setParameter("nid", nid);
        query.setParameter("rid", rid);
        list = query.list();
        if (list.size() > 0) {
            rela = (String) list.get(0);
        } else {
            return "Unknown Person";
        }

        transaction.commit();
        transaction = null;

        return rela;
    }
}
