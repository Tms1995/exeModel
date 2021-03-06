package test;

import cn.superid.jpa.annotation.NotTooSimple;
import cn.superid.jpa.orm.Dao;
import cn.superid.jpa.orm.ExecutableModel;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by zp on 2016/7/20.
 */
@Entity
@Table(name = "user")
public class User  extends ExecutableModel{
   public static Dao<User> dao = new Dao(User.class);
    private int id;
    private String name;
    private int age;
    private String details;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @NotTooSimple
    @Basic
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
