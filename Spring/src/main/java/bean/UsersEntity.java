package bean;

/**
 * Created by zzyo on 2016/5/27.
 */
public class UsersEntity {
    private int uid;
    private String uname;
    private String upass;
    private String email;
    private String mac;
    //private Set<RouterEntity> routerEntities = new HashSet<RouterEntity>();


    public UsersEntity() {
    }

    public UsersEntity(String uname, String upass, String email, String mac) {
        this.uname = uname;
        this.upass = upass;
        this.email = email;
        this.mac = mac;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

/*    public Set<RouterEntity> getRouterEntities() {
        return routerEntities;
    }*/

    /*public void setRouterEntities(Set<RouterEntity> routerEntities) {
        this.routerEntities = routerEntities;
    }*/

    @Override
    public String toString() {
        return "UsersEntity{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upass='" + upass + '\'' +
                ", email='" + email + '\'' +
                ", mac='" + mac + '\''+
                '}';
    }
}
