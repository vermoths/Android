package jy16.marketshow.bean;

/**
 * Created by Vermoths on 2017/11/2.
 */

public class Account {
    private Long id;
    private String name;
    private Integer balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
     return "[序号: " + id + ", 商品名称姓名: " + name + ", 余额: " + balance + "]";
    }

    public Account(Long id, String name, Integer balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Account(String name, Integer balance) {
        this.name = name;
        this.balance = balance;
    }
    public Account() {
        super();
    }
}
