package com.hibernate;

import java.lang.module.Configuration;

public class App
{
    public static void main(String[] args) {
        Alien a = new Alien();
        a.setAid(101);
        a.setAname("Chandana");
        a.setColor("Black");

        Configuration con = new Configuration();

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();
        save(a);

    }
}
