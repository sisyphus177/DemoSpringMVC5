package demo.spring.model.dao;


import demo.spring.model.dao.interf.AccountDao;
import demo.spring.model.entity.Account;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
//import java.util.List;

/**
 * Created by raist on 2016/5/16.
 *
 */
@Repository("accountDaoHibernateImpl")
public class AccountDaoHibernateImpl implements AccountDao{

    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void moneyIn(int accountId, double money) {
        Session session = sessionFactory.getCurrentSession();

        String hqlStr = "from Account as account where account.id=:accountId";
        Query query = session.createQuery(hqlStr);
        query.setInteger("accountId",accountId);
        Account account = (Account)query.uniqueResult();
        account.setMoney(account.getMoney()+money);
        session.save(account);
    }

    public void moneyOut(int accountId, double money) {
        Session session = sessionFactory.getCurrentSession();

        String hqlStr = "from Account as account where account.id=:accountId";
        Query query = session.createQuery(hqlStr);
        query.setInteger("accountId",accountId);
        Account account = (Account)query.uniqueResult();
        account.setMoney(account.getMoney()-money);
        session.save(account);
    }

    public Account getAccountById(int id) {
        Session session = sessionFactory.getCurrentSession();

        String hqlStr = "from Account as account where account.id=:id";
        Query query = session.createQuery(hqlStr);
        query.setInteger("id",id);
        return (Account)query.uniqueResult();
    }

//    public List getAccountByName(String name) {
//        Session session = sessionFactory.getCurrentSession();
//
//        String hqlStr = "from Account as account where account.name like :name";
//        Query query = session.createQuery(hqlStr);
//        query.setString("name",name);
//        return query.list();
//    }
}
