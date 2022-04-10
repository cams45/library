package com.company;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class UserOptions {


    private static final ArrayList<String> isbn = new ArrayList<>();
    private static final ArrayList<String> title = new ArrayList<>();
    private static final ArrayList<String> categorie = new ArrayList<>();
    private static final ArrayList<String> publisher = new ArrayList<>();
    private static final ArrayList<String> PublisherDAte = new ArrayList<>();
    private static final ArrayList<String> key1 = new ArrayList<>();
    private static final ArrayList<String> key2 = new ArrayList<>();
    static Book book = new Book();
    static LocalDate localDate = LocalDate.now();
    public static String DueDAte;
    public static double PaymentAmt;
    public static String PaymentType = "";
    public static String email = "";
    public static String rentbuychoice = "";
    public static String TitleOfBook = "";
    public static Double price = 14.99;
    public static Double change = PaymentAmt - price;
    public static String accountID = "";



    public java.sql.Connection getConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Scanner sc = new Scanner(System.in);
        final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://cisvm-winsrv-mysql1.unfcsd.unf.edu:3307/?user=n01407405";
        String username = "n01407405";
        String password = "Fall20207405";
        java.sql.Connection conn = null;
        Statement stmt = null;
        Class.forName(JDBC_DRIVER).newInstance();
        conn = DriverManager.getConnection(DB_URL, username, password);
        Statement myState = conn.createStatement();
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.print("Please enter one of the following commands \n " );
        System.out.println("1 - users\n" +
                           "2 - admin\n");
        System.out.println("-----------------------------------------------------------------------------------------------");
        String choise = "";
        choise = sc.next();
        switch (choise) {
            case "1":
                UserOptions();
                break;
            case "2":
                adminOptions();
                break;
        }
        return conn;
    }




    /////////////////////////////////////////connection methods////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////Misc methods/////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////Misc methods/////////////////////////////////////////////////////////////////////////////



    public static void receipt(){
        Random rand = new Random ();
        int randomcard = rand.nextInt(9999)+1000;
        int randomaprovalcode = rand.nextInt( 999999999)+1000000000;
        double rentprice = 4.00;
        double buybookprice = 15.99;

        if(rentbuychoice.contains("rent")){
            change = PaymentAmt - buybookprice;
            change = PaymentAmt - rentprice;
            System.out.print("     \n     Osprey Library      \n" +
                    "     Address: 1 University of North Fl Drive \n" +
                    "     Student Union #58W, Jacksonville, FL 32224\n"+
                    "     Phone: 223-232-1123\n");
            System.out.print("---------------------------------------------------\n");
            System.out.print("User paid with:                               "+PaymentType+"\n");
            System.out.print("---------------------------------------------------\n");
            System.out.print("description                                   "+TitleOfBook+"\n");
            System.out.print("Item                                          "+rentprice+"\n");
            System.out.print("---------------------------------------------------"+"\n");
            System.out.print("Total                                         $4.00"+"\n");
            System.out.print("Payment Ammount                             $"+PaymentAmt+"\n");
            System.out.print("change                                        "+change+"\n");
            System.out.print("---------------------------------------------------\n");
            System.out.print("Bank card                              XXXX_XXXX-XXXX"+randomcard+"\n");
            System.out.print("Approval Code                                 "+randomaprovalcode+"\n");
            System.out.print("---------------------------------------------------\n");
            System.out.print("                  Thank you\n");
            System.out.print("                  "+localDate+"\n");
            book.ClearCart();
            System.out.print("empyting cart...\n");
        }
        else{ rentbuychoice.contains("buy");
            change = PaymentAmt - 14.99;
            change = PaymentAmt - buybookprice;
            System.out.print("     \n     Osprey Library      \n" +
                    "     Address: 1 University of North Fl Drive \n" +
                    "     Student Union #58W, Jacksonville, FL 32224\n"+
                    "     Phone: 223-232-1123\n");
            System.out.print("---------------------------------------------------\n");
            System.out.print("User paid with:                               "+PaymentType+"\n");
            System.out.print("---------------------------------------------------\n");
            System.out.print("description                                   "+TitleOfBook+"\n");
            System.out.print("Item                                          $"+buybookprice+"\n");
            System.out.print("---------------------------------------------------"+"\n");
            System.out.print("Total                                         $15.99"+"\n");
            System.out.print("Payment Ammount                             $"+PaymentAmt+"\n");
            System.out.print("change                                        "+change+"\n");
            System.out.print("---------------------------------------------------\n");
            System.out.print("Bank card                              XXXX_XXXX-XXXX"+randomcard+"\n");
            System.out.print("Approval Code                                 "+randomaprovalcode+"\n");
            System.out.print("---------------------------------------------------\n");
            System.out.print("                  Thank you\n");
            System.out.print("                  "+localDate+"\n");
            book.ClearCart();
            System.out.print("empyting cart...\n");
        }






    }
    public void CreateDate(String DueDAte) {
        Calendar cal = Calendar.getInstance();
        long dueDate  = cal.getTime().getTime() + 432000000;
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        DueDAte = format1.format(dueDate);
        setDueDate(DueDAte);
    }
    public static String getDueDate(String DueDAte) {
        return DueDAte;
    }
    public void setDueDate(String DueDAte) {
        UserOptions.DueDAte = DueDAte;
    }


    public static void rentbook()throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
    String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    String DB_URL = "jdbc:mysql://cisvm-winsrv-mysql1.unfcsd.unf.edu:3307/?user=n01407405";
    String username = "n01407405";
    String password = "Fall20207405";
    java.sql.Connection conn = null;
    Statement stmt = null;
    Scanner sc = new Scanner(System.in);
    Class.forName(JDBC_DRIVER).newInstance();
    conn = DriverManager.getConnection(DB_URL, username, password);
    Statement myState = conn.createStatement();
    sc = new Scanner(System.in);
    sc = new Scanner(System.in);
    String sqlste1 = "UPDATE group2.book_table SET RentQuantity = RentQuantity - 1 WHERE  title = ";
    String sqlste2 = sc.nextLine();
    String sqlStatement1 = sqlste1 + "'" + sqlste2 + "'";
    myState.executeUpdate(sqlStatement1);
}
    public static void buybook()throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        String DB_URL = "jdbc:mysql://cisvm-winsrv-mysql1.unfcsd.unf.edu:3307/?user=n01407405";
        String username = "n01407405";
        String password = "Fall20207405";
        java.sql.Connection conn = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        Class.forName(JDBC_DRIVER).newInstance();
        conn = DriverManager.getConnection(DB_URL, username, password);
        Statement myState = conn.createStatement();
        sc = new Scanner(System.in);
        sc = new Scanner(System.in);
        String sqlste1 = "UPDATE group2.book_table SET BuyQuantity = BuyQuantity - 1 WHERE  title = ";
        String sqlste2 = sc.nextLine();
        String sqlStatement1 = sqlste1 + "'" + sqlste2 + "'";
        myState.executeUpdate(sqlStatement1);
    }
    public void getUserInfo() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {


        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.print("are you paying cash or Credit or debit-back to return");
        PaymentType = sc.nextLine();
        String choise = "";

        if(PaymentType.contains("back")){
            UserOptions();
        }

        System.out.print("how much are you paying");
        PaymentAmt = sc.nextDouble();


        System.out.print("what is your emaillll");
        email = sc2.nextLine();
        if(email.contains("back")){
            UserOptions();
        }


        System.out.print("what is your AccountID");
        accountID = sc2.next();
        if(accountID.contains("back")){
            UserOptions();
        }



    }
    public static void insertdbd(String DueDAte,String accountID)throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
        int linec = 1;
        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        String DB_URL = "jdbc:mysql://cisvm-winsrv-mysql1.unfcsd.unf.edu:3307/?user=n01407405";
        String username = "n01407405";
        String password = "Fall20207405";
        java.sql.Connection conn = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        Class.forName(JDBC_DRIVER).newInstance();
        conn = DriverManager.getConnection(DB_URL, username, password);
        Statement myState = conn.createStatement();
        Random rand = new Random();
        int randomIDMaker = rand.nextInt(99999)+100000;
        int randomISBNMaker = rand.nextInt( 99999)+99999;
        int Order = randomIDMaker;
        String TransactionDate = String.valueOf(localDate);
        int ISBN = randomISBNMaker;
        String RentalDate = String.valueOf(localDate);
        String Duedate = DueDAte;
        String sqlpt1 = "INSERT INTO group2.transaction_table VALUES (";
        String sqlpt2 = "'"+Order+"','"+PaymentAmt+"','"+PaymentType+"','"+TransactionDate+"','"+email+"','"+RentalDate+"','"+Duedate+"','"+ISBN+"','"+rentbuychoice+"','"+accountID+"')";
        String sqlStatment = sqlpt1 + sqlpt2;
        myState.executeUpdate(sqlStatment);
}
    public static void insertdbdBUY(String DueDAte,String accountID)throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
        int linec = 1;
        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        String DB_URL = "jdbc:mysql://cisvm-winsrv-mysql1.unfcsd.unf.edu:3307/?user=n01407405";
        String username = "n01407405";
        String password = "Fall20207405";
        java.sql.Connection conn = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        Class.forName(JDBC_DRIVER).newInstance();
        conn = DriverManager.getConnection(DB_URL, username, password);
        Statement myState = conn.createStatement();
        Random rand = new Random();
        int randomIDMaker = rand.nextInt(99999)+100000;
        int randomISBNMaker = rand.nextInt( 99999)+99999;
        int Order = randomIDMaker;
        String TransactionDate = String.valueOf(localDate);
        int ISBN = randomISBNMaker;
        String RentalDate = "0000-00-00";
        String Duedate = "0000-00-00";
        String sqlpt1 = "INSERT INTO group2.transaction_table VALUES (";
        String sqlpt2 = "'"+Order+"','"+PaymentAmt+"','"+PaymentType+"','"+TransactionDate+"','"+email+"','"+RentalDate+"','"+Duedate+"','"+ISBN+"','"+rentbuychoice+"','"+accountID+"')";
        String sqlStatment = sqlpt1 + sqlpt2;
        System.out.print(Duedate+ " --------"+DueDAte);
        System.out.print(sqlStatment);
        myState.executeUpdate(sqlStatment);
    }





    public void  UserOptions() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        System.out.println("Welcome to user options");
        CreateDate(DueDAte+"\n");
        for(;;) {

            System.out.println("Press 1-Search \n"
                    + "Press 2-Checkout (view cart) \n"
                    + "Press 3-Return a book \n"
                    + "Press 4-Check Balance/Late Fee/pay Balance\n");



            Scanner sc = new Scanner(System.in);
            String choise = "";
            choise = sc.next();

            if(choise.contains("back")){
                break;
            }


            switch (choise) {

                case "1":
                    SearchForBook();
                    break;
                case "2":
                    rent_buy(book.getBook1(),book.getBook2());
                    break;
                case "3":
                    System.out.print("Please enter the title of the book you want to return(type back to return): ");
                    ReturnBook();
                    break;
                case "4":
                    AccountBalance();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choise);
            }
        }

    }
    /////////////////////////////////////////////////////////Methods for UserOptions//////////////////////////////////////////////////
    public void SearchForBook() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        String DB_URL = "jdbc:mysql://cisvm-winsrv-mysql1.unfcsd.unf.edu:3307/?user=n01407405";
        String username = "n01407405";
        String password = "Fall20207405";
        java.sql.Connection conn = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        Class.forName(JDBC_DRIVER).newInstance();
        conn = DriverManager.getConnection(DB_URL, username, password);
        Statement myState = conn.createStatement();
        System.out.println("Please enter the title of a book you want to search-type back to return");
        sc = new Scanner(System.in);
        String sqlste1 = "SELECT * FROM group2.book_table WHERE Title = ";
        String sqlste2 = sc.nextLine();
        if(sqlste2.contains("back")){
            UserOptions();
        }
        String sqlStatement1 = sqlste1 + "'"+sqlste2+"'";
        TitleOfBook = sqlste2;
        myState.execute(sqlStatement1);
        System.out.println("ISBN______________title");
        try (ResultSet myRs = myState.executeQuery(sqlStatement1)) {
            while (myRs.next()) {
                System.out.println(myRs.getString("ISBN")                      +"       "+
                                myRs.getString("Title")                     +"       "+
                                myRs.getString("Publisher")                 +"       "+
                                myRs.getString("PublisherDate")             +"       "+
                                myRs.getString("FirstName")                 +"       "+
                                myRs.getString("Lastname")                  +"       "+
                                myRs.getString("Genre")    +"       "+
                                myRs.getString("RentQuantity")              +"       "+
                                myRs.getString("BuyQuantity")              +"       "+
                                ""+"\n-----------------------------------------------------------");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.print("would you like to add this book to your cart\n-yes/no/back");
        String usrchoice = sc.nextLine();
        if(usrchoice.contains("back")){
            UserOptions();
        }


        if(usrchoice.contains("no")){
            System.out.print(TitleOfBook+" Was not added to cart");
        }


        if (usrchoice.contains("yes"));
        {
            Book.book1(sqlStatement1);
        }



Scanner Scan = new Scanner(System.in);
        System.out.print("\nwould you like to add another book to your cart-y/n\n");
        String secondusrchoice = Scan.nextLine();



        if (secondusrchoice.contains("no")) {

        UserOptions();


        } else {secondusrchoice.contains("yes");
            Book.book2();

        }




         }
    public void rent_buy(ArrayList<String> book1, ArrayList<String> book2) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        int linec = 1;
        Book book = new Book();
        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        String DB_URL = "jdbc:mysql://cisvm-winsrv-mysql1.unfcsd.unf.edu:3307/?user=n01407405";
        String username = "n01407405";
        String password = "Fall20207405";
        java.sql.Connection conn = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        Class.forName(JDBC_DRIVER).newInstance();
        conn = DriverManager.getConnection(DB_URL, username, password);
        Statement myState = conn.createStatement();
        sc = new Scanner(System.in);
        String paymenttpe = "";
        String choice = "";
        System.out.print("\n===================book table========================================\n");
        System.out.println("isbn____Fname____LName____genre_________title");
        try (ResultSet myRs = myState.executeQuery("SELECT * FROM group2.book_table;")) {
            while (myRs.next()) {
                System.out.println(myRs.getString("ISBN")   + "  " + ","
                        + myRs.getString("FirstName")       + "  " + ","
                        + myRs.getString("Lastname")        + "  " + ","
                        + myRs.getString("Genre")+ "  " + ","
                        + myRs.getString("Title")+"\n-----------------------------------------------------------");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


            System.out.println("please enter rent or buy-back to return");
            choice = sc.nextLine();
        if(choice.contains("back")){
            UserOptions();
        }
            rentbuychoice = choice;
            switch (choice) {
                case "rent":
                    System.out.println("heres your cart ");
                    book.MakeCart();
                    System.out.print("please enter a book for rent");
                    rentbook();
                    System.out.print("do you have a second book?");
                    choice = sc.nextLine();
                    if(choice.contains("yes")){
                        System.out.print("please enter a book for rent");
                        rentbook();
                    } else if(choice.contains("no")){

                    }
                    getUserInfo();
                    insertdbd(DueDAte,accountID);
                    receipt();

                    break;
                case "buy":
                    System.out.println("heres your cart ");
                    book.MakeCart();
                    System.out.print("please enter a book for buy");
                    buybook();
                    System.out.print("do you have a second book?");
                    choice = sc.nextLine();
                    if(choice.contains("yes")){
                        System.out.print("please enter a book for buy");
                        buybook();
                    } else if(choice.contains("no")){

                    }
                    getUserInfo();
                    insertdbdBUY(DueDAte,accountID);
                    receipt();
                    break;
            }
    }
    public void ReturnBook() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        String DB_URL = "jdbc:mysql://cisvm-winsrv-mysql1.unfcsd.unf.edu:3307/?user=n01407405";
        String username = "n01407405";
        String password = "Fall20207405";
        java.sql.Connection conn = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        Class.forName(JDBC_DRIVER).newInstance();
        conn = DriverManager.getConnection(DB_URL, username, password);
        Statement myState = conn.createStatement();
        sc = new Scanner(System.in);
        sc = new Scanner(System.in);
        String sqlste1 = "UPDATE group2.book_table SET RentQuantity = RentQuantity + 1 WHERE  title = ";
        String sqlste2 = sc.nextLine();
        if(sqlste2.contains("back")){
            UserOptions();
        }
        String sqlStatement1 = sqlste1 + "'" + sqlste2 + "'";
        myState.executeUpdate(sqlStatement1);
        Book book = new Book();
        book.ClearCart();
    }
    public void AccountBalance() throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
        final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://cisvm-winsrv-mysql1.unfcsd.unf.edu:3307/?user=n01407405";
        String username = "n01407405";
        String password = "Fall20207405";
        java.sql.Connection conn = null;
        Statement stmt = null;
        Class.forName(JDBC_DRIVER).newInstance();
        conn = DriverManager.getConnection(DB_URL, username, password);
        Statement myState = conn.createStatement();
        System.out.println("please enter your name");
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(System.in);
        String sqlste1 = "SELECT * FROM group2.user_account_table WHERE LastName =";
        String sqlste2 = sc.nextLine();
        if(sqlste2.contains("back")){
            UserOptions();
        }
        String sqlStatement1 = sqlste1 + "'"+sqlste2+"'";
        System.out.println("ISBN______________title");
        try (ResultSet myRs = myState.executeQuery(sqlStatement1 )) {
            while (myRs.next()) {
                System.out.println(
                        myRs.getString(1)                      +"       "+
                                myRs.getString(2)                     +"       "+
                                myRs.getString(3)                 +"       "+
                                myRs.getString(4)             +"       "+
                                myRs.getString(5)                 +"       "+
                                myRs.getString(6)                  +"       "+
                                myRs.getString(7)    +"       "+
                                myRs.getString(8)              +"       "+
                                ""+"\n-----------------------------------------------------------");
            }


                System.out.print("do you want to pay your balance?-y/n ");
                sc = new Scanner(System.in);
                String chs = sc.nextLine();

            if(chs.contains("yes")){
                    System.out.print("please enter the amount you want to pay\n");
                    float useramt = 0;
                    useramt = sc.nextFloat();
                    System.out.print("thank you for your payment!");


                String sqlste3 = "UPDATE group2.user_account_table SET AccountBalance = AccountBalance -"+useramt+" WHERE LastName ='"+sqlste2+"'";
                myState.executeUpdate(sqlste3);

            } else if(chs.contains("no")){

            }







    }}
/////////////////////////////////////////////////////////Methods for UserOptions/////////////////////////////////////////////////////
    public static void updateQuery()throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException{
        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        String DB_URL = "jdbc:mysql://cisvm-winsrv-mysql1.unfcsd.unf.edu:3307/?user=n01407405";
        String username = "n01407405";
        String password = "Fall20207405";
        java.sql.Connection conn = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        Class.forName(JDBC_DRIVER).newInstance();
        conn = DriverManager.getConnection(DB_URL, username, password);
        Statement myState = conn.createStatement();
        sc = new Scanner(System.in);
        sc = new Scanner(System.in);
        String sqlste1 = "UPDATE group2.book_table SET RentQuantity = RentQuantity + 1;";
        System.out.print(sqlste1);
        String sqlStatement1 = sqlste1;
        try {
            myState.executeUpdate(sqlStatement1);
            System.out.println(myState.execute(sqlStatement1));
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void  adminOptions() throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {

        for ( ;; ) {
            System.out.println("Welcome to admin options");
            System.out.println("press 1-Locate title \n"
                    + "press 2-Update inventory (add/delete/update titles) \n"
                    + "press 3-Check user balance and apply late fees\n"
                    + "press 4-Generate Reports");
            Scanner sc = new Scanner(System.in);
            String choise = "";
            choise = sc.next();
            if (choise.contains("back")) {
                break;
            }
            switch (choise) {
                case "1":
                    System.out.print("Admin chose locate title");
                    Invetory();
                    break;
                case "2":
                    System.out.print("Update inventory (add/delete/update titles)");
                    ExicuteQuery();
                    break;
                case "3":
                    System.out.print("Check user balance and apply late fees");
                    latefees();
                    userLogs();
                    break;
                case "4":
                    System.out.print("Admin chose generate reports");
                    ShowAllTables();
                    System.out.println("+====================+");
                    System.out.println("+all tables generated+");
                    System.out.println("+====================+");
                    System.out.print("would you like to enter a query?-yes/no\n");
                    choise = sc.next();

                    if(choise.contentEquals("yes")){
                        ExicuteQuery();
                    } else if(choise.contentEquals("no")){
                        break;
                    }



                    break;
            } } }
    /////////////////////////////////////////////////////////Methods for AdminOptions/////////////////////////////////////////////////////
    public void ExicuteQuery() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://cisvm-winsrv-mysql1.unfcsd.unf.edu:3307/?user=n01407405";
        String username = "n01407405";
        String password = "Fall20207405";
        java.sql.Connection conn = null;
        Statement stmt = null;
        Class.forName(JDBC_DRIVER).newInstance();
        conn = DriverManager.getConnection(DB_URL, username, password);
        Statement myState = conn.createStatement();
        System.out.println("please enter a query statement-back to return ");
        Scanner sc = new Scanner(System.in);
        String sqlste1 = sc.nextLine();
        if (sqlste1.contains("back")) {
           adminOptions();
        }
        String sqlStatement1 = sqlste1;
        try {
            myState.executeUpdate(sqlStatement1);
            System.out.println(myState.execute(sqlStatement1));
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }




    }
    public static void Invetory() throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
        final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://cisvm-winsrv-mysql1.unfcsd.unf.edu:3307/?user=n01407405";
        String username = "n01407405";
        String password = "Fall20207405";
        java.sql.Connection conn = null;
        Statement stmt = null;
        Class.forName(JDBC_DRIVER).newInstance();
        conn = DriverManager.getConnection(DB_URL, username, password);
        Statement myState = conn.createStatement();

        int linec = 1;
        System.out.println("isbn____Fname____LName____genre_________title");
        try (ResultSet myRs = myState.executeQuery("SELECT * FROM group2.book_table;")) {
            while (myRs.next()) {
                System.out.println("book:"+linec);
                System.out.println(myRs.getString("ISBN")   + "  " + ","
                        + myRs.getString("FirstName")       + "  " + ","
                        + myRs.getString("Lastname")        + "  " + ","
                        + myRs.getString("Genre")+ "  " + ","
                        + myRs.getString("Title")+"\n-----------------------------------------------------------");
                linec++;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
    public void userLogs()throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
        final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://cisvm-winsrv-mysql1.unfcsd.unf.edu:3307/?user=n01407405";
        String username = "n01407405";
        String password = "Fall20207405";
        java.sql.Connection conn = null;
        Statement stmt = null;
        Class.forName(JDBC_DRIVER).newInstance();
        conn = DriverManager.getConnection(DB_URL, username, password);
        Statement myState = conn.createStatement();
        System.out.println("Check user balance and apply late fees\n");
        int linec = 1;
        System.out.println("AccountID____AccountBalance____LName_________________Phone#");
        try (ResultSet myRs = myState.executeQuery("SELECT * FROM group2.user_account_table;")) {
            while (myRs.next()) {
                System.out.println(myRs.getString("AccountID")   + "             " + "$"
                        + myRs.getString("AccountBalance")       + "             " + ","
                        + myRs.getString("LastName")                + "             " + ","
                        + myRs.getString("Phone")+"\n----------------------------------------------------------------------");
                linec++;

            }




        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);

        System.out.print("would you like to run a query\n");
        String adminChoice = sc.next();
        if(adminChoice.contentEquals("yes")){

            System.out.print("please enter your desired query");
            ExicuteQuery();


        }else if (adminChoice.equals(" no")) {
            System.out.print("returning...");
        }



    }
    public void ShowAllTables()throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException{
        int linec = 1;
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
        System.out.print("\n===================book table========================================\n");
        System.out.println("ISBN____FirstName____Lastname____genre_________BuyQuantity_______RentQuantity________Title");
        try (ResultSet myRs = myState.executeQuery("SELECT * FROM group2.book_table;")) {
            while (myRs.next()) {
                System.out.println(myRs.getString("ISBN")   + "  " + ","
                        + myRs.getString("FirstName")       + "  " + ","
                        + myRs.getString("Lastname")        + "  " + ","
                        + myRs.getString("Genre")           + "  " + ","
                        + myRs.getString("BuyQuantity")        + "  " + ","
                        + myRs.getString("RentQuantity")           + "  " + ","
                        + myRs.getString("Title")+"\n-----------------------------------------------------------");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        System.out.print("\n\n===================author_table========================================\n");
        System.out.print("\n\n==company=========firstName=============lastName ============\n");

        try (ResultSet myRs1 = myState.executeQuery("SELECT * FROM group2.author_table;")) {
            while (myRs1.next()) {
                System.out.println(myRs1.getString("company")   + "  " + ","
                        + myRs1.getString("firstName")       + "  " + ","
                        + myRs1.getString("lastName")        + "  " + ","
                        +"\n-----------------------------------------------------------");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



        System.out.print("\n\n===================category_table========================================\n");
        System.out.print("\n\n==Genre=========Format\n");

        try (ResultSet myRs3 = myState.executeQuery("SELECT * FROM group2.category_table;")) {
            while (myRs3.next()) {
                System.out.println(myRs3.getString("Genre")   + "  " + ","
                        + myRs3.getString("Format")       + "  " + ","
                        +"\n-----------------------------------------------------------");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }




        System.out.print("\n\n===================transaction_table========================================\n");
        System.out.print("\n\n==OrderNumber=========PaymentAmt=============PaymentType ============TransactionDate===================Email==========RentDate ============DueDate===================ISBN=========rentbuy===================AccountID=========\n");
        try (ResultSet myRs4 = myState.executeQuery("SELECT * FROM group2.transaction_table;")) {
            while (myRs4.next()) {
                System.out.println(myRs4.getString("OrderNumber")   + "  " + ","
                        + myRs4.getString("PaymentAmt")             + "  " + ","
                        + myRs4.getString("PaymentType")            + "  " + ","
                        + myRs4.getString("TransactionDate")        + "  " + ","
                        + myRs4.getString("Email")                  + "  " + ","
                        + myRs4.getString("RentDate")               + "  " + ","
                        + myRs4.getString("DueDate")                + "  " + ","
                        + myRs4.getString("ISBN")                   + "  " + ","
                        + myRs4.getString("rentbuy")                + "  " + ","
                        + myRs4.getString("AccountID")
                        +"\n-----------------------------------------------------------");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }




        System.out.print("\n\n===================user_account_table========================================\n");
        System.out.print("\n\n==email=========AccountID=============AccountBalance ============PassWord===================LastName==========FirstName ============Creation_Date===================Phone=========\n");
        try (ResultSet myRs5 = myState.executeQuery("SELECT * FROM group2.user_account_table;")) {
            while (myRs5.next()) {
                System.out.println(myRs5.getString("email")        + "  " + ","
                        + myRs5.getString("AccountID")             + "  " + ","
                        + myRs5.getString("AccountBalance")        + "  " + ","
                        + myRs5.getString("PassWord")              + "  " + ","
                        + myRs5.getString("LastName")              + "  " + ","
                        + myRs5.getString("FirstName")              + "  " + ","
                        + myRs5.getString("Creation_Date")              + "  " + ","
                        + myRs5.getString("Phone")+"\n-----------------------------------------------------------");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



        System.out.print("\n\n===================Fees table ========================================\n");
        System.out.print("\n\n==DateDiff=========AccountID=============DayLateFee ============rentbuy===================AccountBalance=========\n");
        try (ResultSet myRs5 = myState.executeQuery("Select\n" +
                "  DATEDIFF(CAST(DueDate As date), CAST(RentDate As date)) AS DateDiff,\n" +
                "  table2.AccountID,\n" +
                "  (\n" +
                "    DATEDIFF(CAST(DueDate As date), CAST(RentDate As date)) -4\n" +
                "  ) * 2 as DayLateFee,\n" +
                "  table1.rentbuy,\n" +
                "  table2.AccountBalance\n" +
                "From\n" +
                "  group2.Transaction_Table as table1\n" +
                "  Join group2.user_account_table as table2 ON table1.AccountID = table2.AccountID\n" +
                "  join group2.fees as table3 on table2.AccountID = table3.AccountID\n" +
                "Where\n" +
                "  DATEDIFF(CAST(DueDate As date), CAST(RentDate As date)) > 1\n" +
                "  AND rentbuy != \"buy\";\n")) {
            while (myRs5.next()) {
                System.out.println(myRs5.getString("DateDiff")   + "                      " + ","
                        + myRs5.getString("AccountID")           + "                    " + ","
                        + myRs5.getString("DayLateFee")          + "                 " + ","
                        + myRs5.getString("rentbuy")             + "                     " + ","
                        + myRs5.getString("AccountBalance")
                        +"\n-----------------------------------------------------------");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
/////////////////////////////////////////////////////////Methods for AdminOptions/////////////////////////////////////////////////////
    public void latefees() throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException{
        int linec = 1;
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
        System.out.print("\n===================book table========================================\n");

        String sqlstsment = "update\n" +
                "  group2.user_account_table\n" +
                "  join group2.fees on fees.AccountID = group2.user_account_table.AccountID\n" +
                "set\n" +
                "  AccountBalance = AccountBalance + DayLateFee\n" +
                "Where\n" +
                "  DayLateFee > 0";


        String sqlstsment1 = "update group2.fees\n" +
                " Join group2.transaction_table on fees.AccountID= group2.transaction_table.AccountID\n" +
                " set DayLateFee = ((DATEDIFF(CAST(DueDate As date) , CAST(RentDate As date)) )-4) + 1\n" +
                " Where DATEDIFF(CAST(DueDate As date) , CAST(RentDate As date)) >1 AND rentbuy!= \"buy\" ;";
        System.out.print(sqlstsment);
        myState.execute(sqlstsment);
        myState.execute(sqlstsment1);






    }
}


