
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StudentService {
	private ArrayList<Student> listStudent;
	private static final String INSERT_CUSTOMER_SQL = "Insert into student(id, ten, ngaysinh, diachi, diem) values (?, ?, ?, ?, ?)";
	private final static String DB_URL = "jdbc:sqlserver://localhost:1433;"
			+ "databaseName=studentmanager;"
			+ "integratedSecurity=true";
	private final static String USER_NAME = "sa";
	private final static String PASSWORD = "123";
	public StudentService()  {
		this.listStudent = new ArrayList<Student>();
	
		
	}
	
	/**
	 * Add new student to list
	 * 
	 * @param student Student
	 */
	public void add(Student student) {
		listStudent.add(student);
	}

	/**
	 * Add student.
	 * 
	 * @param
	 */
	public void insertStudent() throws SQLException {
		Student student = new Student();
		Connection connection = DatabaseConnection.getConnection(DB_URL, USER_NAME, PASSWORD);
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL);

		preparedStatement.setString(1, student.getStudentId());
		preparedStatement.setString(2, student.getStudentName());
		preparedStatement.setString(3, student.getBirthday());
		preparedStatement.setString(4, student.getAddress());
		preparedStatement.setDouble(5, student.getScore());

		preparedStatement.executeUpdate();
	}
	public void AddStudentList() {
		String id;
		Scanner input = new Scanner(System.in);
		System.out.println("Input StudentID:");
		id = input.nextLine();

		System.out.println("Input StudentName:");
		String name = input.nextLine();

		System.out.println("Input Birthday Student:");
		String birthday = input.nextLine();

		System.out.println("Input Address Student:");
		String address = input.nextLine();

		System.out.println("Input Score Student:");
		double score = input.nextDouble();
		listStudent.add(new Student(id, name, birthday, address, score));

		input.close();
	}

	/**
	 * remove student by studentId.
	 * 
	 * @param studentId
	 */
	public void delete(String studentId) {
		// TODO Auto-generated method stub
		for (Student student : listStudent) {
			if (student.getStudentId().equals(studentId)) {
				listStudent.remove(student);
				break;
			}
		}
	}

	/**
	 * 
	 * Search student by name
	 * 
	 * @param name
	 */
	public void SearchStudentByName(String name) {
		ArrayList<Student> listStudentFindByName = new ArrayList<>();
		for (Student student : listStudentFindByName) {
			if ((formatText(student.getStudentName()).contains(formatText(name)))) {
				listStudentFindByName.add(student);
			}
		}
	}

	/**
	 * Print student score max
	 * 
	 * @return
	 */
	public ArrayList<Student> printScoreMax() {
		double max = listStudent.get(0).getScore();
		for (int i = 1; i < listStudent.size(); i++) {
			if (listStudent.get(i).getScore() > max) {
				max = listStudent.get(i).getScore();
			}
		}

		//
		ArrayList<Student> studentMax = new ArrayList<>();
		for (Student student : listStudent) {
			if (student.getScore() == max) {
				studentMax.add(student);
			}
		}
		return studentMax;

	}

	/**
	 * 
	 * Sort student ascending by score
	 * 
	 * 
	 */
	public void SortAscending() {
		Collections.sort(listStudent, new Comparator<Student>() {
			public int compare(Student student1, Student student2) {
				if (student1.getScore() > student2.getScore()) {
					return 1;
				}
				if (student1.getScore() < student2.getScore()) {
					return -1;
				}
				return 0;
			}
		});
	}

	/**
	 * 
	 * Sort student decrease by name
	 * 
	 * @param
	 */
	public void SortDecrease() {
		Collections.sort(listStudent, new Comparator<Student>() {
			public int compare(Student student1, Student student2) {
				return (student2.getStudentName().compareTo(student1.getStudentName()));
			}
		});
	}

	/**
	 * Get all student
	 * 
	 * @return
	 */
	public ArrayList<Student> getAllStudent() {
		return this.listStudent;
	}

	public ArrayList<Student> getStudentByName(String name) {
		ArrayList<Student> lsStudent = new ArrayList<Student>();
		for (Student student : listStudent) {
			if ((formatText(student.getStudentName()).contains(formatText(name)))) {
				lsStudent.add(student);
			}
		}
		return lsStudent;
	}

	/**
	 * Show Student
	 * 
	 * @param lsStudent
	 */
	public void show(ArrayList<Student> lsStudent) {

		System.out.println("   STT  ||    ID    ||             Name              ||    birtday      ||       Address    ||      Score   ");
		int index = 1;
		for (Student student : lsStudent) {

			System.out.println(index + "   " + student.getStudentId() + "    " + student.getStudentName() + "     "
					+ student.getAddress() + "    " + student.getBirthday() + "    " + student.getAddress() + "    "
					+ student.getScore());
			index++;
		}
	}

	public String formatText(String text) {
		return text.toLowerCase().trim();
	}

	

}
