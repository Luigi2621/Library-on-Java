/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.models;

/**
 *
 * @author luisc
 */
public class Users {
    private int id;
    private String name;
    private String last_name_1;
    private String last_name_2;
    private String domicilio;
    private String tel;
    private int sanctions;
    private int sanc_money;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLast_name_1(String last_name_1) {
        this.last_name_1 = last_name_1;
    }

    public void setLast_name_2(String last_name_2) {
        this.last_name_2 = last_name_2;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setSanctions(int sanctions) {
        this.sanctions = sanctions;
    }

    public void setSanc_money(int sanc_money) {
        this.sanc_money = sanc_money;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLast_name_1() {
        return last_name_1;
    }

    public String getLast_name_2() {
        return last_name_2;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getTel() {
        return tel;
    }

    public int getSanctions() {
        return sanctions;
    }

    public int getSanc_money() {
        return sanc_money;
    }
}
