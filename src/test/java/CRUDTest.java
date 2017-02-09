import com.jee.bean.UserBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Иван on 07.02.2017.
 */
public class CRUDTest {
    private static EJBContainer ejbContainer;
    private static Context ctx;

    private static UserBean userBean;

    @After
    public void tearDown() {
        ejbContainer.close();
    }

    @Before
    public void setUp() {
        Map<String, Object> properties = new HashMap<String, Object>();
        //properties.put(EJBContainer.MODULES, new File("build/jar"));
        properties.put(EJBContainer.MODULES, new File("target/classes"));
        ejbContainer = EJBContainer.createEJBContainer(properties);
    }

    @Test
    public void dowWork() {
    }
}

