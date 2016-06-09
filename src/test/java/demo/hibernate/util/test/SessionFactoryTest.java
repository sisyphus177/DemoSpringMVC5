package demo.hibernate.util.test;

import demo.spring.model.entity.Account;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by raist on 2016/5/16.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SessionFactoryTest {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Test
    public void test(){
        list(sessionFactory);
    }

    private void list(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hqlStr = "from Account as account";
        Query query = session.createQuery(hqlStr);
        List queryResult = query.list();
        for(Object o:queryResult){
            Account account = (Account) o;
            System.out.println(account.getId()+":"+account.getName()+":"+account.getMoney());
        }
        transaction.commit();
        session.close();
    }
}
