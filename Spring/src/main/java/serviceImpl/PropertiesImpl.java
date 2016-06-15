package serviceImpl;

import service.Properties;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by zzyo on 2016/5/30.
 */
public class PropertiesImpl implements Properties {

    @Override
    public Map<String,String> getProperties(String path) {
        Map<String,String> map = new HashMap<String, String>();
        Map.Entry entry = null;
        java.util.Properties Properties = new java.util.Properties();
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(path);
        try {
            Properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Iterator iterator = Properties.entrySet().iterator();
        while(iterator.hasNext())
        {
            entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
            map.put((String) entry.getKey(),(String) entry.getValue());
        }
        return map;
    }
}
