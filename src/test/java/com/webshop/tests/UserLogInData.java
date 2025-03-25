package com.webshop.tests;

public class UserLogInData
{
    private String mail;
    private String PWD;



    public UserLogInData setMail(String mail)
    {
        this.mail = mail;
        return this;
    }

    public UserLogInData setPWD(String PWD)
    {
        this.PWD = PWD;
        return this;
    }

    public String getPWD()
    {
        return PWD;
    }

    public String getMail()
    {
        return mail;
    }

}