package demo.spring.model.dao.interf;

import demo.spring.model.entity.Account;

//import java.util.List;

/**
 * Created by raist on 2016/5/10.
 *
 */
public interface AccountDao {
    void moneyIn(int accountId, double money);
    void moneyOut(int accountId, double money);
    Account getAccountById(int id);
//    List getAccountByName(String name);
}
