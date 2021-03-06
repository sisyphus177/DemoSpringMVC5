package demo.spring.model.service;

import demo.spring.model.dao.interf.AccountDao;
import demo.spring.model.entity.Account;
import demo.spring.model.service.interf.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
//import java.util.List;

/**
 * Created by raist on 2016/5/16.
 *
 */
@Service("accountServiceHibernateTemplateImpl")
public class AccountServiceHibernateTemplateImpl implements AccountService {

    private AccountDao accountDao;

    @Resource(name = "accountDaoHibernateTemplateImpl")
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, transactionManager = "hibernateTransactionManager")
    public void transfer(int from, int to, double money) {
        accountDao.moneyOut(from,money);
        accountDao.moneyIn(to,money);
    }

    public Account showMoneyById(final int id) {
        Account account = accountDao.getAccountById(id);
        if(account==null){
            System.out.println("No account found for ID:"+id);
        }else{
            System.out.println("ID:"+account.getId()+";Name:"+account.getName()+";Money:"+account.getMoney());
        }
        return account;
    }

//    public void showMoneyByName(final String name) {
//        List list = accountDao.getAccountByName(name);
//        if(list==null||list.size()==0){
//            System.out.println("AccountServiceHibernateTemplateImpl");
//            System.out.println("No account found for name:"+name);
//        }else{
//            for (Object obj:
//                    list) {
//                Account account = (Account)obj;
//                System.out.println("ID:"+account.getId()+";Name:"+account.getName()+";Money:"+account.getMoney());
//            }
//        }
//    }
}
