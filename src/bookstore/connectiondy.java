package bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.Statement;


public class connectiondy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		try//handling the errors
		{
			Class.forName("com.mysql.jdbc.Driver");//include the mysql jdbc drive 
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/obookstore","root","3052");//connecting to the mysql db,user name and port number
			System.out.println("Connetion Successfully");
			Statement st=(Statement) conn.createStatement();
class book {
	 
    // Class data members
    public int sNo;
    public String bookname;
    public String authorname;
    public int bookQty;
    public int bookQtyCopy;
 
    // Creating object of Scanner class to
    // read input from users
    Scanner input = new Scanner(System.in);
    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    // Method
    // To add book details
    public book() 
    {
        // Display message for taking input later
        // taking input via
        // nextInt() and nextLine() standard methods
        System.out.println("Enter Serial No of Book:");
        this.sNo = input.nextInt();
        input.nextLine();
        //br.readLine();
 
        System.out.println("Enter Book Name:");
        this.bookname = input.nextLine();
 
        System.out.println("Enter Author Name:");
        this.authorname = input.nextLine();
 
        System.out.println("Enter Quantity of Books:");
        this.bookQty = input.nextInt();
        bookQtyCopy = this.bookQty;
    }
}
/*
public class connectiondy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		try//handling the errors
		{
			Class.forName("com.mysql.jdbc.Driver");//include the mysql jdbc drive 
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/obookstore","root","3052");//connecting to the mysql db,user name and port number
			System.out.println("Connetion Successfully");
			Statement st=(Statement) conn.createStatement();*/
			
			System.out.println("WElcome");
			System.out.println( "********************Welcome to Book Store!********************");
	        System.out.println(  "                  Select From The Following Options:               ");
	        //System.out.println( "**********************************************************************");
	        System.out.println(
	                "----------------------------------------------------------------------------------------------------------");
	            System.out.println("Press 1 to Add new Book.");
	            System.out.println("Press 0 to Exit Application.");
	            System.out.println(
	                "Press 2 to Upgrade Quantity of a Book.");
	            System.out.println("Press 3 to Search a Book.");
	            System.out.println("Press 4 to Show All Books.");
	            System.out.println("Press 5 to Register User.");
	            System.out.println(
	                "Press 6 to Show All Registered user.");
	            System.out.println("Press 7 to Check Out Book. ");
	            System.out.println("Press 8 to Check In Book");
	            System.out.println(
	                "-------------------------------------------------------------------------------------------------------");
		  book b=new book();
		st.executeUpdate("insert into book value ('"+b.sNo+"','"+b.bookname+"','"+b.authorname+"','"+b.bookQty+"','"+b.bookQtyCopy+"')");
		} catch (Exception e) 
		{
			System.out.println("The error are:   " + e);
		}
		System.out.println("Thank you ...");
	}

}
