package bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zzyo on 2016/5/27.
 */
public class RouterEntity {

    private int rid;
    private String gname;
    private String mac;
    private Set<UsersEntity> usersEntities = new HashSet<UsersEntity>();

    public RouterEntity() {
    }

    public RouterEntity(String gname, String mac) {
        this.gname = gname;
        this.mac = mac;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Set<UsersEntity> getUsersEntities() {
        return usersEntities;
    }

    public void setUsersEntities(Set<UsersEntity> usersEntities) {
        this.usersEntities = usersEntities;
    }

    @Override
    public String toString() {
        return "RouterEntity{" +
                "rid=" + rid +
                ", gname='" + gname + '\'' +
                ", mac='" + mac + '\'' +
                ", usersEntities=" + usersEntities +
                '}';
    }
}
