package bean;

/**
 * Created by zzyo on 2016/6/2.
 */
public class UtoR {

    private int uid;
    private int rid;
    private int nid;
    private String rela;

    public UtoR() {
    }

    public UtoR(int uid, int rid, int nid, String rela) {
        this.uid = uid;
        this.rid = rid;
        this.nid = nid;
        this.rela = rela;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public String getRela() {
        return rela;
    }

    public void setRela(String rela) {
        this.rela = rela;
    }

    @Override
    public String toString() {
        return "UtoR{" +
                "uid=" + uid +
                ", rid=" + rid +
                ", nid=" + nid +
                ", rela='" + rela + '\'' +
                '}';
    }
}
