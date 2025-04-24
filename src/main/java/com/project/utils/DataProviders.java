package com.project.utils;

import com.project.models.UserRegData;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders
{

    @DataProvider//add some contacts
    public Iterator<Object[]> createNewAccount()
    {
        List<Object[]> list =new ArrayList<>();
        list.add(new Object[]{"John","Black","ecrfv1!@gmail.com","kkk1mmm"});
        list.add(new Object[]{"John","White","edcrfv2!@gmail.com","mmm1kkk"});
        list.add(new Object[]{"John","Green","edcrfv3!@gmail.com","lll1ppp1mmm"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]>createNewAccountCSV() throws IOException//to read data from CSV file. Read row/row and put it into variable
    {
        List<Object[]> list=new ArrayList<>();

        BufferedReader reader=new BufferedReader(new FileReader(new File("src/test/resources/Untitled spreadsheet - Sheet1.csv")));//from where to read
        String line = reader.readLine();//read and put into variable

        while (line!=null)
        {
            String[] split = line.split(",");
            list.add(new Object[]{new UserRegData().setName(split[0]).setSurName(split[1]).setMail(split[2]).setPassword(split[3])});
            line=reader.readLine();
        }

        return list.iterator();
    }




}
