package com.company;


import java.sql.SQLException;

public class connection {

    public static void main(String[] args) throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        UserOptions up = new UserOptions();
        System.out.println("Connecting to a selected database...");
        System.out.println("Connected database successfully...");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++ \n" +
                "+                                       +");
        System.out.println("+  welcom to Library database interface + \n" +
                "+                                       +");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");

        for (;;) {
            up.getConnection();
            System.out.println("---------------------------------------------------------------------------------------------------------------------");

        }


    }}
