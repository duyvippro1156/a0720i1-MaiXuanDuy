

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 
 * @author PC
 *
 */
public class Main {

    /**
     * main
     * 
     * @author viettuts.vn
     * @param args
     * @throws SQLException 
     */
    public static void main(String args[])  {
    	Menu();
    }

	/**
	 * 
	 * Menu Student.
	 * @throws SQLException 
	 * 
	 */
	@SuppressWarnings("resource")
	public static void Menu()  {
		while (true) {
			System.out.println("Manage Student list");
			System.out.println("Function");
			System.out.println("1.Print student list");
			System.out.println("2.Add Student list");
			System.out.println("3.Delete student list");
			System.out.println("4.Search name .");
			System.out.println("5.Print student score max");
			System.out.println("6.Sort Student ascending score");
			System.out.println("7.Sort student decrease name");
			System.out.println("Please choose:");

			Scanner input = new Scanner(System.in);
			int number = input.nextInt();
			StudentService studentService = new StudentService();
			switch (number) {
			case 1:
				studentService.show(studentService.getAllStudent());
				break;
			case 2:
				studentService.AddStudentList();
				studentService.show(studentService.getAllStudent());
				studentService.insertStudent();
				break;
			case 3:
				System.out.println("Input StudentID:");
				Scanner it = new Scanner(System.in);
				 String studentId = it.nextLine();
				studentService.delete(studentId);
				studentService.show(studentService.getAllStudent());
				break;
			case 4:
				System.out.println("Input studentName:");
				String nameSearch = new Scanner(System.in).nextLine();
				studentService.SearchStudentByName(nameSearch);
				studentService.show(studentService.getStudentByName(nameSearch));
				break;
			case 5:
				studentService.printScoreMax();
				studentService.show(studentService.printScoreMax());
				break;
			case 6:
				studentService.SortAscending();
				studentService.show(studentService.getAllStudent());
				break;
			case 7:
				studentService.SortDecrease();
				studentService.show(studentService.getAllStudent());
				
				break;
			default:
				System.out.println("The imported menu does not exist. Please re-enter!");
				
			}
		
		}
	
	}
	
}
