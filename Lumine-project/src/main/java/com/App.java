package main.java.com;

import main.java.com.View.*;

import javax.swing.*;
import java.security.Principal;

public class App extends JFrame {
    public static void main(String[] args) {

        JFrame jf = new JFrame();
        jf.setTitle("Lumine Glam");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setContentPane(new Login().JPanelLogin);
        jf.setSize(850,750);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

    }
}

/*
create database lumineGlam;
use lumineGlam;

create table users(
idUser int primary key auto_increment,
userName varchar (50) not null,
password varchar(10)
);

select * from users;
insert into users(userName, password) values
("pedrorzd","3643");
insert into users(userName, password) values
("thiagin69","12345");

 */