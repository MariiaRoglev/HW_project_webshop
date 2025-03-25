package com.webshop.tests;

public class UserRegData
{
    private String name;
    private String surName;
    private String mail;
    private String password;




    public String getName() {
        return name;
    }

    public UserRegData setName(String name)
    {
        this.name = name;
        return this;
    }

    public String getSurName()
    {
        return surName;
    }

    public UserRegData setSurName(String surName)
    {
        this.surName = surName;
        return this;
    }

    public String getMail()
    {
        return mail;
    }

    public UserRegData setMail(String mail)
    {
        this.mail = mail;
        return this;
    }

    public String getPassword()
    {
        return password;
    }

    public UserRegData setPassword(String password)
    {
        this.password = password;
        return this;
    }
}