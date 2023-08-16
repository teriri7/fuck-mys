package pm.geetest.utils;

import java.util.Map;

public class R {
    private int code;
    private String message;
    private Map<String, Object> data;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    private R() {
    }

    public static R OK(Map<String, Object> d) {
        R r = new R();
        r.setCode(0);
        r.setMessage("OK");
        r.setData(d);
        return r;
    }

    public static R ERROR(String msg) {
        R r = new R();
        r.setCode(-1);
        r.setMessage(msg);
        r.setData(null);
        return r;
    }
}
