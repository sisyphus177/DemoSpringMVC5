package demo.spring.model.dao;

import demo.spring.model.dao.interf.AccountDao;
import demo.spring.model.entity.Account;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

//import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import java.util.List;

/**
 * Created by raist on 2016/5/19.
 *
 */
@Repository("accountDaoHibernateTemplateImpl")
public class AccountDaoHibernateTemplateImpl implements AccountDao{

    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private HibernateTemplate hibernateTemplate;

//    @Resource(name = "hibernateTemplate")
//    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
//        this.hibernateTemplate = hibernateTemplate;
//    }

    @PostConstruct
    private void initialize() {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public void moneyIn(final int accountId, final double money) {
        hibernateTemplate.execute((HibernateCallback<Object>) session -> {

            String hqlStr = "from Account as account where account.id=:accountId";
            Query query = session.createQuery(hqlStr);
            query.setInteger("accountId",accountId);
            Account account = (Account)query.uniqueResult();
            account.setMoney(account.getMoney()+money);
            session.save(account);

            return account;
        });
    }

    public void moneyOut(final int accountId, final double money) {
        hibernateTemplate.execute((HibernateCallback<Object>) session -> {

            String hqlStr = "from Account as account where account.id=:accountId";
            Query query = session.createQuery(hqlStr);
            query.setInteger("accountId",accountId);
            Account account = (Account)query.uniqueResult();
            account.setMoney(account.getMoney()-money);
            session.save(account);

            return account;
        });
    }

    public Account getAccountById(final int id) {
        return (Account) hibernateTemplate.execute(session -> {
            String hqlStr = "from Account as account where account.id=:id";
            Query query = session.createQuery(hqlStr);
            query.setInteger("id",id);
            return query.uniqueResult();
        });
    }

//    public List getAccountByName(final String name) {
//        return (List) hibernateTemplate.execute((HibernateCallback<Object>) session -> {
//            String hqlStr = "from Account as account where account.name like :name";
//            Query query = session.createQuery(hqlStr);
//            query.setString("name",name);
//            return query.list();
//        });
//    }
}
