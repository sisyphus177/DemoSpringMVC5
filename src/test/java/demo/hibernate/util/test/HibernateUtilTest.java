package demo.hibernate.util.test;

import demo.hibernate.util.HibernateUtil;
import demo.spring.model.entity.Account;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.MethodSorters;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by raist on 2016/5/10.
 *
 */
@RunWith(BlockJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HibernateUtilTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void test(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        String hqlStr = "from Account as account";
        Query query = session.createQuery(hqlStr);
        List queryResult = query.list();
        for(Object o:queryResult){
            Account account = (Account) o;
            System.out.println(account.getId()+":"+account.getName()+":"+account.getMoney());
            assertTrue(account.getMoney()>0d);
        }

        transaction.commit();
        session.close();
        sessionFactory.close();
//        assertTrue(1==1);
    }

}