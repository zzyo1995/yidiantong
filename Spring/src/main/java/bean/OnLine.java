package bean;

/**
 * Created by zzyo on 2016/6/2.
 */
public class OnLine {

    private int uid;
    private int rid;

    public OnLine() {
    }

    public OnLine(int uid, int rid) {
        this.uid = uid;
        this.rid = rid;
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

    @Override
    public String toString() {
        return "OnLine{" +
                "uid='" + uid + '\'' +
                ", rid='" + rid + '\'' +
                '}';
    }
}
