package com.company;

import java.math.BigDecimal;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Book {
    private int ISBN;
    private String title;
    private String publisher;
    private String publishDate;
    private String Fname;
    private String Lname;
    private String category;
    private BigDecimal price;
    private int buyQuantity;
    private int rentQuantity;
    public static ArrayList<String> book1 = new ArrayList<>(1);
    public static ArrayList<String> book2 = new ArrayList<>(1);
    ArrayList<String> cart = new ArrayList<>(3);


    public Book() {

    }
    public static void book1(String sqlStatement1 ) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        UserOptions uspr = new UserOptions();
        // write your code here
        // JDBC driver name and database URL
        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        String DB_URL = "jdbc:mysql://cisvm-winsrv-mysql1.unfcsd.unf.edu:3307/?user=n01407405";
        String username = "n01407405";
        String password = "Fall20207405";
        //  Database credentials
        java.sql.Connection conn = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        Class.forName(JDBC_DRIVER).newInstance();
        conn = DriverManager.getConnection(DB_URL, username, password);
        Statement myState = conn.createStatement();



        try (ResultSet myRs1 = myState.executeQuery(sqlStatement1)) {
            while (myRs1.next()) {
                book1.add(myRs1.getString(1));
                book1.add(myRs1.getString(2));
                book1.add(myRs1.getString(3));
                book1.add(myRs1.getString(4));
                book1.add(myRs1.getString(5));
                book1.add(myRs1.getString(6));
                book1.add(myRs1.getString(7));
                book1.add(myRs1.getString(8));
                book1.add(myRs1.getString(9));



            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        book1.trimToSize();





    }
    public static void book2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        UserOptions uspr = new UserOptions();
        // write your code here
        // JDBC driver name and database URL
        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        String DB_URL = "jdbc:mysql://cisvm-winsrv-mysql1.unfcsd.unf.edu:3307/?user=n01407405";
        String username = "n01407405";
        String password = "Fall20207405";
        //  Database credentials
        java.sql.Connection conn = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        Class.forName(JDBC_DRIVER).newInstance();
        conn = DriverManager.getConnection(DB_URL, username, password);
        Statement myState = conn.createStatement();
        sc = new Scanner(System.in);
        System.out.println("Please enter the title of a book you want to search?");
        sc = new Scanner(System.in);
        String sqlste1 = "SELECT * FROM group2.book_table WHERE Title = ";
        String sqlste2 = sc.nextLine();
        if(sqlste2.contains("back")){
            new UserOptions();
        }
        String sqlStatement1 = sqlste1 + "'" + sqlste2 + "'";
        myState.execute(sqlStatement1);
        System.out.println("ISBN______________title");
            try (ResultSet myRs1 = myState.executeQuery(sqlStatement1)) {
                while (myRs1.next()) {
                    book2.add(myRs1.getString(1));
                    book2.add(myRs1.getString(2));
                    book2.add(myRs1.getString(3));
                    book2.add(myRs1.getString(4));
                    book2.add(myRs1.getString(5));
                    book2.add(myRs1.getString(6));
                    book2.add(myRs1.getString(7));
                    book2.add(myRs1.getString(8));
                    book2.add(myRs1.getString(9));

                }
            }catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            System.out.print(book2+"\n");
            book2.trimToSize();


    }

    public ArrayList<String> getBook2() {
        return book2;
    }

    public void setBook2(ArrayList<String> book2) {
        Book.book2 = book2;
    }

    public ArrayList<String>getBook1() {
        return book1;
    }

    public void setBook1(ArrayList<String> book1) {
        Book.book1 = book1;
    }

    public void MakeCart() {
        System.out.print("              isbn-------title------publishing-------publishDate------AuthorName----AuthorLname-----genre-----qr--qb");
        cart.add("\n---------------------"+"\nbook one is "+book1+"\n");
        cart.add("------------------------");
        cart.add("\nbook two is "+book2+"\n");
        System.out.print("cart"+cart);
        System.out.print('\n');
        Scanner sc = new Scanner(System.in);


    }




    public void ClearCart(){

       /// System.out.print("cart class"+cart);

    }



}
