/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modeli;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mateosokac
 */
@Entity
@Table(name = "Users")
public class User implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(insertable = true, updatable = true)
    private String firstName; 
    @Column(insertable = true, updatable = true)
    private String lastName;   
    @Column(insertable = true, updatable = true)
    private String email; 
    @Column(insertable = true, updatable = true)
    private String password; 
    @Column(insertable = true, updatable = true)
    private String phone_num; 
    @Column(insertable = true, updatable = true)
    private String gender;
    @Column(insertable = true, updatable = true)
    private String birthday;
    @Column(insertable = true, updatable = true)
    private String location;
    
     
    public User()
    {
    }
    public User(String firstName, String lastName, String email, 
            String password, String gender,String birthday, String location,
            String phone_num)
    { 
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phone_num = phone_num;
        this.birthday = birthday;
        this.gender = gender;
        this.location = location;
    }
   

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
