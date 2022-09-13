package management;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.student;
import com.student.manage.studentdao;

public class start {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Student");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("Press 1 to Add");
			System.out.println("Press 2 to Delete");
			System.out.println("Press 3 to Update");
			System.out.println("Press 4 to Exit");
			int c = Integer.parseInt(bf.readLine());
			if (c == 1) {
				System.out.println("Enter user name:");
				String name = bf.readLine();
				System.out.println("Enter user roll:");
				String roll = bf.readLine();
				System.out.println("Enter user gpa:");
				String gpa = bf.readLine();
				System.out.println("Enter user number:");
				String number = bf.readLine();
				student s = new student(roll, number, name, gpa);
				boolean ans = studentdao.insert(s);
				System.out.println(s);
				//System.out.println(ans);
				if (ans) {
					System.out.println("student is added successfully....");
				} else {
					System.out.println("Something went wrong.Try again...");
				}
			} else if (c == 2) {
				System.out.println("Enter student Roll to delete?");
				String roll = bf.readLine();
				boolean ansd = studentdao.delete(roll);
				if (ansd) {
					System.out.println("Deleted successfully....");
				} else {
					System.out.println("Something went wrong.Try again...");
				}
			} else if (c == 3) {
				System.out.println("Enter student Roll to update?");
				String roll = bf.readLine();
				System.out.println("Enter which field you want to update?");
				String o = bf.readLine();
				System.out.println("Updated value?");
				String v = bf.readLine();
				boolean ansu = studentdao.update(o, v, roll);
				if (ansu) {
					System.out.println("Updated successfully....");
				} else {
					System.out.println("Something went wrong.Try again...");
				}
			} else {
				System.err.println("Exit the program");
				System.exit(0);
			}
		}

	}

}
