package com.jee.integration;

import com.jee.bean.util.DataManager;
import com.jee.bean.util.SqlRunner;
import com.jee.model.mapped_superclass.BlogPost;
import com.jee.model.mapped_superclass.Book;
import com.jee.model.mapped_superclass.Publication;
import com.jee.model.single_table.Car;
import com.jee.model.single_table.Motorcycle;
import com.jee.model.table_per_class.SchoolUser;
import com.jee.model.table_per_class.Student;
import com.jee.model.table_per_class.Teacher;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.NamingException;
import java.util.*;

/**
 * Created by Иван on 21.02.2017.
 */
public class JpaInheritanceTest extends BaseTestSupport {
    private DataManager dataManager;
    private SqlRunner sqlRunner;

    @Before
    public void setUp() throws NamingException {
        super.setUp();
        dataManager = (DataManager) getBean(DataManager.class);
        sqlRunner = (SqlRunner) getBean(SqlRunner.class);
    }

    @Test
    public void doWork() throws Exception {
        mappedSuperclassTest();
        tablePerClassTest();
        singleTableTest();
    }

    private void mappedSuperclassTest() throws Exception {
        BlogPost post = new BlogPost();
        post.setUrl("http://test.url");
        post.setPublishingDate(new Date());
        post.setTitle("Title");

        post = (BlogPost) dataManager.persist(post);

        Book book = new Book();
        book.setTitle("Title book");
        book.setPages(1);
        book.setPublishingDate(new Date());

        book = (Book) dataManager.persist(book);

        Assert.assertNotNull(dataManager.find(book));
        Assert.assertNotNull(dataManager.find(post));

        try {
            dataManager.findAll(Publication.class);
            Assert.fail("Mapped superclass cannot use in query");
        } catch (Exception ignore) {
        }

        dataManager.delete(book);
        dataManager.delete(post);

        Assert.assertNull(dataManager.find(book));
        Assert.assertNull(dataManager.find(post));
    }

    private void tablePerClassTest() throws Exception {
        Student student = new Student();
        student.setName("Name");
        student.setLastName("LastName");
        student.setProfileName("Profile1");
        student = (Student) dataManager.persist(student);

        Teacher teacher = new Teacher();
        teacher.setName("Teacher1");
        teacher.setLastName("Teacher2");
        teacher.setEmail("Email1");
        teacher = (Teacher) dataManager.persist(teacher);

        List list = dataManager.findAll(SchoolUser.class);
        Assert.assertTrue(list.size() > 0);

        dataManager.delete(student);
        dataManager.delete(teacher);
    }

    private void singleTableTest() throws Exception {
        Car car = new Car();
        car.setSpeed(1);
        car.setWeight(1);
        car.setWheelCount(1);
        car.setDoorsCount(1);
        car = (Car) dataManager.persist(car);

        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setWheelCount(1);
        motorcycle.setWeight(1);
        motorcycle.setSpeed(1);
        motorcycle.setSport(true);
        motorcycle = (Motorcycle) dataManager.persist(motorcycle);

        List<Map<String, Object>> list = sqlRunner.select("select * from vehicle");
        Set<String> dtypes = new HashSet<>();
        if (list != null) {
            for (Map<String, Object> map : list) {
                if (map.get("DTYPE") != null) {
                    dtypes.add((String) map.get("DTYPE"));
                }
            }
        }
        Assert.assertTrue(dtypes.contains("Motorcycle") && dtypes.contains("Car"));

        dataManager.delete(car);
        dataManager.delete(motorcycle);
    }
}
