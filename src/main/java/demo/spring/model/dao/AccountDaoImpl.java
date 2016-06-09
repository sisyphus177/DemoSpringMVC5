package demo.spring.model.dao;

import demo.spring.model.dao.interf.AccountDao;
import demo.spring.model.entity.Account;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Types;

//import org.springframework.dao.DataAccessException;
//import org.springframework.jdbc.core.ResultSetExtractor;
//import org.springframework.jdbc.core.RowMapper;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;

/**
 * Created by raist on 2016/5/10.
 *
 */
@Repository("accountDaoImpl")
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao{

    @Resource(name = "dataSource")
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public void moneyIn(int accountId, double money) {
        String sql = "update transactiontest.account set money = money + ? where id = ?";
//        this.getJdbcTemplate().update(sql,money,accountId);
        this.getJdbcTemplate().update(sql,new Object[]{money,accountId},new int[]{Types.DOUBLE,Types.INTEGER});
    }

    public void moneyOut(int accountId, double money) {
        String sql = "update transactiontest.account set money = money - ? where id = ?";
//        this.getJdbcTemplate().update(sql,money,accountId);
        this.getJdbcTemplate().update(sql,new Object[]{money,accountId},new int[]{Types.DOUBLE,Types.INTEGER});
    }

    public Account getAccountById(int id) {
        String sql = "select * from transactiontest.account where id = ?";
        return this.getJdbcTemplate().query(sql, new Object[]{id}, new int[]{Types.INTEGER}, resultSet -> {
            if (resultSet.next()){
                Account account = new Account();
                account.setId(resultSet.getInt("id"));
                account.setName(resultSet.getString("name"));
                account.setMoney(resultSet.getDouble("money"));
                return account;
            } else {
                return null;
            }
        });
    }

//    public List getAccountByName(String name) {
//        String sql = "select * from transactiontest.account where name like ?";
//        return this.getJdbcTemplate().query(sql, new Object[]{name}, new int[]{Types.VARCHAR}, (resultSet, i) -> {
//            System.out.println("RowMapper ResultSet=>"+resultSet.toString()+";RowNum=>"+i);
//
//            Account account = new Account();
//            account.setMoney(resultSet.getDouble("money"));
//            account.setName(resultSet.getString("name"));
//            account.setId(resultSet.getInt("id"));
//            return account;
//        });
//    }
}
