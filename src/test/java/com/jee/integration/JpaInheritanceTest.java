package com.jee.integration;

import com.jee.bean.util.DataManager;
import com.jee.model.mapped_superclass.BlogPost;
import com.jee.model.mapped_superclass.Book;
import com.jee.model.mapped_superclass.Publication;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.NamingException;
import java.util.Date;

/**
 * Created by Иван on 21.02.2017.
 */
public class JpaInheritanceTest extends BaseTestSupport {
    private DataManager dataManager;

    @Before
    public void setUp() throws NamingException {
        super.setUp();
        dataManager = (DataManager) getBean(DataManager.class);
    }

    @Test
    public void mappedSuperclassTest() throws Exception {
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
}
