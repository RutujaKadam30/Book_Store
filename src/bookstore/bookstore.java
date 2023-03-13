package bookstore;
import java.io.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
public class bookstore {
	public static void main(String[] args) throws IOException
    {
		try//handling the errors
		{
			Class.forName("com.mysql.jdbc.Driver");//include the mysql jdbc drive 
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/obookstore","root","3052");//connecting to the mysql db,user name and port number
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
    public void searchBySno()
    {
 
        // Display message
        System.out.println(
            "\t\t\t\tSEARCH BY SERIAL NUMBER\n");
 
        // Class data members
        int sNo;
        System.out.println("Enter Serial No of Book:");
        sNo = input.nextInt();
 
        int flag = 0;
        System.out.println(
            "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
 
        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].sNo) {
                System.out.println(
                    theBooks[i].sNo + "\t\t"
                    + theBooks[i].bookname + "\t\t"
                    + theBooks[i].authorname + "\t\t"
                    + theBooks[i].bookQtyCopy + "\t\t"
                    + theBooks[i].bookQty);
                flag++;
                return;
            }
        }
        if (flag == 0)
            System.out.println("No Book for Serial No "
                               + sNo + " Found.");
    }
 
    // Method 4
    // To search author by name
    public void searchByauthorname()
    {
 
        // Display message
        System.out.println(
            "\t\t\t\tSEARCH BY AUTHOR'S NAME");
 
        input.nextLine();
 
        System.out.println("Enter Author Name:");
        String authorname = input.nextLine();
 
        int flag = 0;
 
        System.out.println(
            "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
 
        for (int i = 0; i < count; i++) {
 
            // if author matches any of its book
            if (authorname.equalsIgnoreCase(
                    theBooks[i].authorname)) {
 
                // Print below corresponding credentials
                System.out.println(
                    theBooks[i].sNo + "\t\t"
                    + theBooks[i].bookname + "\t\t"
                    + theBooks[i].authorname + "\t\t"
                    + theBooks[i].bookQtyCopy + "\t\t"
                    + theBooks[i].bookQty);
                flag++;
            }
        }
 
        // Else no book matches for author
        if (flag == 0)
            System.out.println("No Books of " + authorname
                               + " Found.");
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
    public void upgradeBookQty()
    {
 
        System.out.println(
            "\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
        System.out.println("Enter Serial No of Book");
 
        int sNo = input.nextInt();
 
        for (int i = 0; i < count; i++) {
 
            if (sNo == theBooks[i].sNo) {
 
                // Display message
                System.out.println(
                    "Enter No of Books to be Added:");
 
                int addingQty = input.nextInt();
                theBooks[i].bookQty += addingQty;
                theBooks[i].bookQtyCopy += addingQty;
 
                return;
            }
        }
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
    String regNum;
 
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
        System.out.println("Enter Registration Number:");
        this.regNum = input.nextLine();
    }
}
class users {
	 
    // Creating objects of Scanner and users class
    Scanner input = new Scanner(System.in);
    user theusers[] = new user[50];
 
    public static int count = 0;
 
    // Method 1
    // To add books
    public void adduser(user s)
    {
        for (int i = 0; i < count; i++) {
 
            if (s.regNum.equalsIgnoreCase(
                    theusers[i].regNum)) {
 
                // Print statement
                System.out.println(
                    "user of Reg Num " + s.regNum
                    + " is Already Registered.");
 
                return;
            }
        }
 
       /* if (count <= 50) {
            theusers[count] = s;
            count++;
            
        }
        */
    }
 
    // Method 2
    // Displaying all users
    public void showAllusers()
    {
        // Printing user name and
        // corresponding registered number
        System.out.println("user Name\t\tReg Number");
        for (int i = 0; i < count; i++) {
 
            System.out.println(theusers[i].userName
                               + "\t\t"
                               + theusers[i].regNum);
        }
    }
 
    // Method 3
    // To check the user
    public int isuser()
    {
        // Display message only
        System.out.println("Enter Reg Number:");
 
        String regNum = input.nextLine();
 
        for (int i = 0; i < count; i++) {
 
            if (theusers[i].regNum.equalsIgnoreCase(
                    regNum)) {
                return i;
            }
        }
 
        // Print statements
        System.out.println("User is not Registered.");
        System.out.println("Get Registered First.");
 
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
}
/*public class bookstore {
	public static void main(String[] args) throws IOException
    { */
        // Creating object of Scanner class
        // to take input from user
		
		/*try//handling the errors
		{
			Class.forName("com.mysql.jdbc.Driver");//include the mysql jdbc drive 
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/obookstore","root","3052");//connecting to the mysql db,user name and port number
			System.out.println("Connetion Established ");
			Statement st=(Statement) conn.createStatement();*/
		   //	String q = "insert into book value ('"+sNO+"',bookname,authorname,bookQty,bookQtyCopy)";
	
		  // book c = new book();
		   	//st.executeUpdate("insert into book value ('"+c.sNo+"','"+c.bookname+"','"+c.authorname+"','"+c.bookQty+"','"+c.bookQtyCopy+"')");
		  // 	java.sql.PreparedStatement pstmt=conn.prepareStatement(q);
		   	//	ResultSet rset=st.executeQuery("select * from itemployee");//display the table
			//while(q.next())//collecting the n number of records from the table
			//{
				//System.out.println(q.getString(1)+"           "+q.getString(2)+"                "+rset.getString(3)+"                "+rset.getString(4)+"        "+rset.getString(5)); 
			//}
		//	System.out.println("Values are inserted Successfully");
		
		/*} catch (Exception e) 
		{
			System.out.println("The error are:   " + e);
		}*/
		
        Scanner input = new Scanner(System.in);
 
        // Displaying menu
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
        // Creating object of book class
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
            	
            	st.executeUpdate("UPDATE book SET bookQty = ? WHERE sNo = ?");
            	System.out.println("Book Updated Successfully");
            	
                ob.upgradeBookQty();
                break;
 
            // Case
            case 3:
 
                System.out.println(
                    " press 1 to Search with Book Serial No.");
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
    				System.out.println(rset.getString(1)+"           "+rset.getString(2)+"                "+rset.getString(3)+"                "+rset.getString(4)+"        "+rset.getString(5)); 
    			}
            	
                
                break;
 
                // Case
            case 5:
                user s = new user();
                st.executeUpdate("insert into user value ('"+s.userName+"','"+s.regNum+"','"+s.booksCount+"')");
            	System.out.println("User Added Successfully");
                obuser.adduser(s);
                break;
 
                // Case
            case 6:
                obuser.showAllusers();
                ResultSet rset1=st.executeQuery("select * from user");
            	while(rset1.next())//collecting the n number of records from the table
    			{
    				System.out.println(rset1.getString(1)+"           "+rset1.getString(2)+"                "+rset1.getString(3)); 
    			}
                break;
 
                // Case
            case 7:
                obuser.checkOutBook(ob);
                break;
 
                // Case
            case 8:
                obuser.checkInBook(ob);
                break;
 
                // Default case that will execute for sure
                // if above cases does not match
            default:
 
                // Print statement
                System.out.println("ENTER BETWEEN 0 TO 8.");
            }
 
        }
 
        // Checking condition at last where we are
        // checking case entered value is not zero
        //while (choice != 0);
		} catch (Exception e) 
		{
			System.out.println("The error are:   " + e);
		}
    }
}


