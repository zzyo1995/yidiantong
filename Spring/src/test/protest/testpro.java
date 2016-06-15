package protest;

import org.junit.Test;
import service.Properties;
import serviceImpl.PropertiesImpl;

/**
 * Created by zzyo on 2016/5/30.
 */
public class testpro {

    @Test
    public void testpro()
    {
        Properties prop = new PropertiesImpl();
        prop.getProperties("message.properties");
    }
}
