package demo.spring.model.service.interf;

import demo.spring.model.entity.Account;

/**
 * Created by raist on 2016/5/10.
 *
 */
public interface AccountService {
    void transfer(int from, int to, double money);
    Account showMoneyById(int id);
//    void showMoneyByName(String name);
}
