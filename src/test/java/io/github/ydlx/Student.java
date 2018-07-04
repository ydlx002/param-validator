package io.github.ydlx;


import io.github.ydlx.annotation.EnumType;
import io.github.ydlx.annotation.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Student implements Serializable {


    @NotNull
    private String name;

    @EnumType(enums = {"test","test1"})
    private String address;


    private BigDecimal weight;

    private String friendName;
    private Boolean isHaveFriend(){
        return friendName != null?true:false;
    }

    private Date birthday;

    private String email;

    private String spellName;


    public String getSpellName() {
        return spellName;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
