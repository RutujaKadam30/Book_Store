package bookstore;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class onlinebookstore {
			public static void main(String[] args) throws IOException
		{
		      try//handling the errors
		   {
		    	 Scanner sc=new Scanner(System.in);
			     Class.forName("com.mysql.jdbc.Driver");//include the mysql jdbc drive 
			     Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","3052");//connecting to the mysql db,user name and port number
			     System.out.println("Connetion Established ");
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

			    	class books {
			    		 
			    	    // Class data members
			    	    book theBooks[] = new book[50];
			    	    public static int count;
			    	 
			    	    Scanner input = new Scanner(System.in);
			    	 
			    	    // Method 1
			    	    //  To compare books
			    	    public int compareBookObjects(book b1, book b2)
			    	    {
			    	 
			    	        // If book name matches
			    	        if (b1.bookname.equalsIgnoreCase(b2.bookname)) {
			    	 
			    	            // Printing book exists
			    	            System.out.println(
			    	                "Book of this Name Already Exists.");
			    	            return 0;
			    	        }
			    	 
			    	        // if book serial matches
			    	        if (b1.sNo == b2.sNo) {
			    	 
			    	            // Print book exists
			    	            System.out.println(
			    	                "Book of this Serial No Already Exists.");
			    	 
			    	            return 0;
			    	        }
			    	        return 1;
			    	    }
			    	 
			    	    // Method 2
			    	    // To add book
			    	    public void addBook(book b)
			    	    {
			    	 
			    	        for (int i = 0; i < count; i++) {
			    	 
			    	            if (this.compareBookObjects(b, this.theBooks[i])
			    	                == 0)
			    	                return;
			    	        }
			    	 
			    	        if (count < 50) {
			    	 
			    	            theBooks[count] = b;
			    	            count++;
			    	        }
			    	        else {
			    	 
			    	            System.out.println(
			    	                "No Space to Add More Books.");
			    	        }
			    	    }
			    	 
			    	    // Method 3
			    	    // To search book by serial number
			    	    public void searchBySno() throws SQLException
			    	    {
			    	 
			    	        // Display message
			    	        System.out.println(
			    	            "\t\t\t\tSEARCH BY Book Name\n");
			    	 
			    	        // Class data members
			    	        String bookname;
			    	        System.out.println("Enter Book name");
			    	        bookname = input.next();
			    	        System.out.println(
			    	            "S.No---------Name---------Author-------Available Qty\t ");
			
			    	             String sql2 = "Select * from book Where bookname='" + bookname + "'";
				                 ResultSet rs = st.executeQuery(sql2);
				                 while(rs.next())//collecting the n number of records from the table
			            			{
			            				System.out.println(rs.getString(1)+"             "+rs.getString(2)+"              "+rs.getString(3)+"               "+rs.getString(4)); 
			            			}
				                System.out.println("------------------------------------------------");
			                        
			    	    }
			    	 
			    	    // Method 4
			    	    // To search author by name
			    	    public void searchByauthorname() throws SQLException
			    	    {
			    	 
			    	        // Display message
			    	        System.out.println(
			    	            "\t\t\t\tSEARCH BY AUTHOR'S NAME");
			    	 
			    	        input.nextLine();
			    	 
			    	        System.out.println("Enter Author Name:");
			    	        String authorname = input.nextLine();
			    	 
			    	        int flag = 0;
			    	 
			    	        System.out.println(
			    	            "S.No------Name-------Author------Available Qty\t ");
			    	 
			    	        String sql3 = "Select * from book Where authorname='" + authorname + "'";
			                 ResultSet rs1 = st.executeQuery(sql3);
			                 
			                        while(rs1.next())//collecting the n number of records from the table
		            			 {
		            				System.out.println(rs1.getString(1)+"              "+rs1.getString(2)+"            "+rs1.getString(3)+"                   "+rs1.getString(4)); 
		            			 }
			                  
			                 System.out.println("--------------------------------------------------");
			                
			    	        // Else no book matches for author
			    	        
			    	    }
			    	 
			    	    // Method 5
			    	    // To display all books
			    	    public void showAllBooks()
			    	    {
			    	 
			    	    	
			    	        System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
			    	        System.out.println(
			    	            "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
			    	 
			    	        for (int i = 0; i < count; i++) {
			    	 
			    	            System.out.println(
			    	                theBooks[i].sNo + "\t\t"
			    	                + theBooks[i].bookname + "\t\t"
			    	                + theBooks[i].authorname + "\t\t"
			    	                + theBooks[i].bookQtyCopy + "\t\t"
			    	                + theBooks[i].bookQty);
			    	        }
			    	        
			    	    }
			    	 
			    	   //method6
			    	    // To edit the book
			    	    public void upgradeBookQty() throws SQLException
			    	    {
			    	 
			    	        System.out.println(
			    	            "\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
			    	        System.out.println("Enter Name Of Book");
			    	 
			    	       String  bookname = input.next();
			    	          //  int i=0;
			    	                // Display message
			    	                System.out.println(
			    	                    "Enter No of Books to be Added:");
			    	 
			    	                int addingQty = input.nextInt();
			    	               // theBooks[i].bookQty += addingQty;
			    	               // theBooks[i].bookQtyCopy += addingQty;
			    	                st.executeUpdate("UPDATE book SET bookQty = '"+addingQty+"' WHERE bookname = '"+bookname+"' ");
			    	                st.executeUpdate("UPDATE book SET bookQtyCopy = '"+addingQty+"' WHERE bookname = '"+bookname+"' ");
			    	 
			    	              System.out.println("Quantity Updated Successfully!!!!");
			    	    }
			    	 
			    	 
			    	    // Method 7
			    	    // To search the library
			    	    public int isAvailable(int sNo)
			    	    {
			    	 
			    	        for (int i = 0; i < count; i++) {
			    	            if (sNo == theBooks[i].sNo) {
			    	                if (theBooks[i].bookQtyCopy > 0) {
			    	 
			    	                    System.out.println(
			    	                        "Book is Available.");
			    	                    return i;
			    	                }
			    	                System.out.println("Book is Unavailable");
			    	                return -1;
			    	            }
			    	        }
			    	 
			    	        System.out.println("No Book of Serial Number "
			    	                           + " Available in Library.");
			    	        return -1;
			    	    }
			    	 
			    	    // Method 8
			    	    // To remove the book from the library
			    	    public book checkOutBook()
			    	    {
			    	 
			    	        System.out.println(
			    	            "Enter Serial No of Book to be Checked Out.");
			    	        int sNo = input.nextInt();
			    	 
			    	        int bookIndex = isAvailable(sNo);
			    	 
			    	        if (bookIndex != -1) {
			    	            theBooks[bookIndex].bookQtyCopy--;
			    	            return theBooks[bookIndex];
			    	        }
			    	        return null;
			    	    }
			    	 
			    	    // Method 9
			    	    // To add the Book to the Library
			    	    public void checkInBook(book b)
			    	    {
			    	        for (int i = 0; i < count; i++) {
			    	            if (b.equals(theBooks[i])) {
			    	                theBooks[i].bookQtyCopy++;
			    	                return;
			    	            }
			    	        }
			    	    }
			    	}
			    	class user {
			    		 
			    	    // Class member variables
			    	    String userName;
			    	    String mobNum;
			    	 
			    	    book borrowedBooks[] = new book[3];
			    	    public int booksCount = 0;
			    	 
			    	    // Creating object of Scanner class to
			    	    // take input from user
			    	    Scanner input = new Scanner(System.in);
			    	 
			    	    // Constructor
			    	    public user()
			    	    {
			    	        // Print statement
			    	        System.out.println("Enter user Name:");
			    	 
			    	        // This keywords refers to current instance
			    	        this.userName = input.nextLine();
			    	 
			    	        // Print statement
			    	        System.out.println("Enter Mobile Number:");
			    	        this.mobNum = input.nextLine();
			    	    }
			    	}
			    	class users {
			    		 
			    	    // Creating objects of Scanner and users class
			    	    Scanner input = new Scanner(System.in);
			    	    user theusers[] = new user[50];
			    	 
			    	    public static int count = 0;
			    	 
			             // Method 1
			    	    // Displaying all users
			    	    public void showAllusers()
			    	    {
			    	        // Printing user name and
			    	        // corresponding registered number
			    	        System.out.println("User Name \t Mobile Number");
			    	        for (int i = 0; i < count; i++) {
			    	 
			    	            System.out.println(theusers[i].userName
			    	                               + "\t\t"
			    	                               + theusers[i].mobNum);
			    	        }
			    	    }
			    	 
			    	    // Method 
			    	    // To check the user
			    	    public int isuser()
			    	    {
			    	        // Display message only
			    	        System.out.println("Enter Book Name which You have to buy:");
			    	 
			    	        String bookname = input.nextLine();
			    	 
			    	     /*   for (int i = 0; i < count; i++) {
			    	 
			    	            if (theusers[i].mobNum.equalsIgnoreCase(
			    	                    mobNum)) {
			    	            	System.out.println("Hello user");
			    	            			return i;
			    	            }
			    	        }
			    	 
			    	        // Print statements
			    	        System.out.println("User is not Registered.");
			    	        System.out.println("Get Registered First.");
			    	 */
			    	        
			    	        return -1;
			    	    }
			    	 
			    	    // Method 4
			    	    // To remove the book
			    	    public void checkOutBook(books book)
			    	    {
			    	    	
			    	        int userIndex = this.isuser();
			    	 
			    	        if (userIndex != -1) {
			    	            System.out.println("checking out");
			    	 
			    	            
			    	           // book.showAllBooks();
			    	            book b = book.checkOutBook();
			    	 
			    	            System.out.println("checking out");
			    	            if (b != null) {
			    	 
			    	                if (theusers[userIndex].booksCount
			    	                    <= 3) {
			    	 
			    	                    System.out.println("adding book");
			    	                    theusers[userIndex].borrowedBooks
			    	                        [theusers[userIndex]
			    	                             .booksCount]
			    	                        = b;
			    	                    theusers[userIndex].booksCount++;
			    	 
			    	                    return;
			    	                }
			    	                else {
			    	 
			    	                    System.out.println(
			    	                        "user Can not Borrow more than 3 Books.");
			    	                    return;
			    	                }
			    	            }
			    	            System.out.println("Book is not Available.");
			    	        }
			    	    }
			    	 
			    	    // Method 5
			    	    // To add the book
			    	    public void checkInBook(books book)
			    	    {
			    	        int userIndex = this.isuser();
			    	        if (userIndex != -1) {
			    	 
			    	            // Printing credentials corresponding to user
			    	            System.out.println(
			    	                "S.No\t\t\tBook Name\t\t\tAuthor Name");
			    	 
			    	            user s = theusers[userIndex];
			    	 
			    	            for (int i = 0; i < s.booksCount; i++) {
			    	 
			    	                System.out.println(
			    	                    s.borrowedBooks[i].sNo + "\t\t\t"
			    	                    + s.borrowedBooks[i].bookname + "\t\t\t"
			    	                    + s.borrowedBooks[i].authorname);
			    	            }
			    	 
			    	            // Display message only
			    	            System.out.println(
			    	                "Enter Serial Number of Book to be Checked In:");
			    	 
			    	            int sNo = input.nextInt();
			    	 
			    	            for (int i = 0; i < s.booksCount; i++) {
			    	                if (sNo == s.borrowedBooks[i].sNo) {
			    	                    book.checkInBook(s.borrowedBooks[i]);
			    	                    s.borrowedBooks[i] = null;
			    	 
			    	                    return;
			    	                }
			    	            }
			    	 
			    	            System.out.println("Book of Serial No " + sNo
			    	                               + "not Found");
			    	        }
			    	    }
			    	    
			    	    public void displayuse() throws SQLException {
			    	    	Scanner input = new Scanner(System.in);
				    		System.out.println( "********************Welcome to Book Store!********************");
				            System.out.println(  "                  Select From The Following Options:               ");
				            //System.out.println( "**********************************************************************");
				     
				            System.out.println(
				                    "----------------------------------------------------------------------------------------------------------");
				               
				              //  System.out.println( "Press 2 to Upgrade Quantity of a Book.");
				                System.out.println("Press 1 to Search a Book.");
				                System.out.println("Press 2 to Show All Books.");
				               
				               // System.out.println("Press 5 to Show All Registered user.");
				                //System.out.println("Press 3 to Check Out Book. ");
				                System.out.println("Press 3 to Buy Book");
				                
				                System.out.println(
				                    "-------------------------------------------------------------------------------------------------------");
				    	
				                books ob = new books();
				                // Creating object of users class
				                users obuser = new users();
				         
				                int choice;
				                int searchChoice;
				         
				                // Creating menu
				                // using while loop
				               
				            while(true) {
				                   
				                    choice = input.nextInt();
				                    
				                    // Switch case
				                    switch (choice) {
				         
				                        // Case
				                   
				         
				                        // Case
				                   
				         
				                    // Case
				                    case 1:
				         
				                        System.out.println(
				                            " press 1 to Search with Book Name.");
				                        System.out.println(
				                            " Press 2 to Search with Book's Author Name.");
				                        searchChoice = input.nextInt();
				         
				                        // Nested switch
				                        switch (searchChoice) {
				         
				                            // Case
				                        case 1:
				                            ob.searchBySno();
				                            break;
				         
				                            // Case
				                        case 2:
				                        	
				                            ob.searchByauthorname();
				                        }
				                        break;
				         
				                        // Case
				                    case 2:
				                    	ob.showAllBooks();
				                    	ResultSet rset=st.executeQuery("select * from book");
				                    	while(rset.next())//collecting the n number of records from the table
				            			{
				            				System.out.println(rset.getString(1)+"             "+rset.getString(2)+"              "+rset.getString(3)+"                "+rset.getString(4)+"                 "+rset.getString(5)); 
				            			}
				                    	
				                        
				                        break;
				         
				                        // Case
				                   
				  
				                        // Case
				                    case 3:
				                        obuser.checkInBook(ob);
				                        break;
				         
				                        // Default case that will execute for sure
				                        // if above cases does not match
				                    default:
				         
				                        // Print statement
				                        System.out.println("ENTER BETWEEN 0 TO 8.");
				                    }
				         
				                }
			    	    	
			    	    }
			    	
			    	   public void displayms() throws SQLException
			    		{
			    			Scanner input = new Scanner(System.in);
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
			               
			                System.out.println(
			                    "Press 5 to Show All Registered user.");
			                System.out.println("Press 6 to Check Out Book. ");
			                System.out.println("Press 7 to Check In Book");
			                System.out.println(
			                    "-------------------------------------------------------------------------------------------------------");
			    	
			                books ob = new books();
			                // Creating object of users class
			                users obuser = new users();
			         
			                int choice;
			                int searchChoice;
			         
			                // Creating menu
			                // using while loop
			               
			            while(true) {
			                   
			                    choice = input.nextInt();
			                    
			                    // Switch case
			                    switch (choice) {
			         
			                        // Case
			                    case 1:
			                        book b = new book();
			                       st.executeUpdate("insert into book value ('"+b.sNo+"','"+b.bookname+"','"+b.authorname+"','"+b.bookQty+"','"+b.bookQtyCopy+"')");
			                    	System.out.println("Book Added Successfully");
			                    	ob.addBook(b);
			                    	break;
			         
			                        // Case
			                    case 2:
			                    	
			                    	//st.executeUpdate("UPDATE book SET bookQty = ? WHERE sNo = ?");
			                    	System.out.println("Book Updated Successfully");
			                    	
			                        ob.upgradeBookQty();
			                        break;
			         
			                    // Case
			                    case 3:
			         
			                        System.out.println(
			                            " press 1 to Search with Book Name.");
			                        System.out.println(
			                            " Press 2 to Search with Book's Author Name.");
			                        searchChoice = input.nextInt();
			         
			                        // Nested switch
			                        switch (searchChoice) {
			         
			                            // Case
			                        case 1:
			                            ob.searchBySno();
			                            break;
			         
			                            // Case
			                        case 2:
			                        	
			                            ob.searchByauthorname();
			                        }
			                        break;
			         
			                        // Case
			                    case 4:
			                    	ob.showAllBooks();
			                    	ResultSet rset=st.executeQuery("select * from book");
			                    	while(rset.next())//collecting the n number of records from the table
			            			{
			            				System.out.println(rset.getString(1)+"          "+rset.getString(2)+"                     "+rset.getString(3)+"					"+rset.getString(4)+"					"+rset.getString(5)); 
			            			}
			                    	
			                        
			                        break;
			         
			                        // Case
			                   
			                    case 5:
			                        obuser.showAllusers();
			                        ResultSet res1= st.executeQuery("select * from registration");
			                    	while(res1.next())//collecting the n number of records from the table
			            			{
			            				System.out.println(res1.getString(1)+"-------------------"+res1.getString(3)); 
			            			}
			                        break;
			         
			                        // Case
			                    case 6:
			                        obuser.checkOutBook(ob);
			                        break;
			         
			                        // Case
			                    case 7:
			                        obuser.checkInBook(ob);
			                        break;
			         
			                        // Default case that will execute for sure
			                        // if above cases does not match
			                    default:
			         
			                        // Print statement
			                        System.out.println("ENTER BETWEEN 0 TO 8.");
			                    }
			         
			                }
			         
			    		}
			    	}
			 
			
	
			    	
			 System.out.println("\t ----------------- WELCOME --------------------\t");
		System.out.println("\t\t May I Know Who Are You ????" );
		System.out.println("\t 1.User");
		System.out.println("\t 2.Book Seller");
		int choice = sc.nextInt();
		switch(choice) {
		
		case 1: 
			
		// for user login
			System.out.println("1.Are You Register User");
			System.out.println("2.Or New User");
			
			int userChoice = sc.nextInt();
			 switch(userChoice) {
			    case 1:
					System.out.println("-------------Hello Readers Welcome-------------- " );
					System.out.println("Username (use mobile as username )");
				    String mobilenum = sc.next();
					System.out.println("Password " );
					String password=sc.next();
					 if (mobilenum != null && password != null) {
				            String sql = "Select * from registration Where mobilenum='" + mobilenum + "' and password='" + password + "'";
				            ResultSet rs = st.executeQuery(sql);
				            if (rs.next()) {
				            	System.out.println("Login Successfully");
				            	users d1 = new users();
								  d1.displayuse();
				            	
				            	
				            } else {
				            	System.out.println("User not found");
				         
				            }
				        }
					 
					  
				            break;
		              
		              case 2 : 
		            	  System.out.println("Welcome new user");
		            	  System.out.println("Name : ");
		            	  String name = sc.next();
		            	  System.out.println("password : ");
		            	  String password1 = sc.next();
		            	  System.out.println("Mobile Number : ");
		            	  int mobilenum1 =sc.nextInt();
		            	  st.executeUpdate("insert into registration value ('"+name+"','"+password1+"','"+mobilenum1+"')");
		              	System.out.println("User Added Successfully");
		              	System.out.println("Please Login in System");
		            	  
		            	  
		            	  break;
		             default:
		            		  System.out.println("Enter Correct choice");
		}
			 break;
		case 2:
			System.out.println(" ------------------------ WELCOME SELLER -------------------  ");
			System.out.println("1.Registered Seller");
			System.out.println("2.New Selller");
			int sellerChoice = sc.nextInt();
			 switch(sellerChoice) {
			    case 1:
					System.out.println("---------------- Welcome Back-------------------  " );
					System.out.println(" Username (use mobile as username )");
				    String mobilenum = sc.next();
					System.out.println("Password " );
					String password=sc.next();
					 if (mobilenum != null && password != null) {
				            String sql = "Select * from selleregi Where mobilenum='" + mobilenum + "' and password='" + password + "'";
				            ResultSet rs = st.executeQuery(sql);
				            if (rs.next()) {
				            	System.out.println("Login Successfully");
				                   users d1 = new users();
								  d1.displayms();
				            	
				            } else {
				            	System.out.println("User not found");
				         
				            }
				            
				        }
					 break;
			    case 2:
			    	System.out.println("--------Hello New Seller---------");
			    	System.out.println("Enter Your Details To Register On our Site");
			    	System.out.println("Name : ");
	            	String name = sc.next();
	            	System.out.println("password : ");
	            	String password1 = sc.next();
	            	System.out.println("Mobile Number : ");
	            	int mobilenum1 =sc.nextInt();
	            	st.executeUpdate("insert into selleregi value ('"+name+"','"+password1+"','"+mobilenum1+"')");
	              	System.out.println("*******Seller Added Successfully*******");
	              	System.out.println("Please Login in the System");
	            	  
			    	
			
		}
		
		}
		} catch (Exception e) 
	{
		System.out.println("The error are:   " + e);
	}

	}

}

