package demo.spring.model.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by raist on 2016/5/10.
 *
 */
@XmlRootElement(name = "account")
public class Account {
    private int id;
    private String name;
    private Double money;

    @XmlElement(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "money")
    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

//        if (id != account.id) return false;
//        if (name != null ? !name.equals(account.name) : account.name != null) return false;
//        if (money != null ? !money.equals(account.money) : account.money != null) return false;

        return id == account.id && (name != null ? name.equals(account.name) : account.name == null && (money != null ? money.equals(account.money) : account.money == null));

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (money != null ? money.hashCode() : 0);
        return result;
    }

}
