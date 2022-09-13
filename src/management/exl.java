package management;

import java.awt.Font;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.student.manage.abc;
import com.student.manage.student;
import com.student.manage.studentdao;

import java.awt.Color;
import java.awt.Container;

public class exl extends JFrame implements ActionListener {
	String[] cols = { "Name", "Roll", "GPA", "Number" };
	String[] rows = new String[4];
	JLabel gpa, roll, name, number;
	JTextField gpat, rollt, namet, numbert;
	JButton add, dlt, upd, cls, exp;
	JTable table;
	JScrollPane pane;
	DefaultTableModel model;

	exl() {
		rows[0] = "";
		rows[1] = "";
		rows[2] = "";
		rows[3] = "";
		Container c = this.getContentPane();
		c.setLayout(null);
		Font f = new Font("Arial", Font.BOLD, 15);
		JLabel label = new JLabel("Student Details");
		label.setFont(f);
		label.setBounds(140, 10, 250, 50);
		c.add(label);
		name = new JLabel("Name");
		name.setBounds(10, 80, 140, 30);
		c.add(name);
		namet = new JTextField();
		namet.setBounds(110, 80, 200, 30);
		c.add(namet);
		roll = new JLabel("Roll");
		roll.setBounds(10, 130, 140, 30);
		c.add(roll);
		rollt = new JTextField();
		rollt.setBounds(110, 130, 200, 30);
		c.add(rollt);
		gpa = new JLabel("GPA");
		gpa.setBounds(10, 180, 140, 30);
		c.add(gpa);
		gpat = new JTextField();
		gpat.setBounds(110, 180, 200, 30);
		c.add(gpat);
		number = new JLabel("Number");
		number.setBounds(10, 230, 140, 30);
		c.add(number);
		numbert = new JTextField();
		numbert.setBounds(110, 230, 200, 30);
		c.add(numbert);
		add = new JButton("ADD");
		add.setBounds(400, 80, 100, 30);
		c.add(add);
		dlt = new JButton("DELETE");
		dlt.setBounds(400, 130, 100, 30);
		c.add(dlt);
		upd = new JButton("UPDATE");
		upd.setBounds(400, 180, 100, 30);
		c.add(upd);
		cls = new JButton("CLEAR");
		cls.setBounds(400, 230, 100, 30);
		c.add(cls);
		exp = new JButton("Export");
		exp.setBounds(300, 300, 100, 30);
		c.add(exp);
		table = new JTable();
		model = new DefaultTableModel();
		model.setColumnIdentifiers(cols);
		table.setModel(model);
		table.setSelectionBackground(Color.black);
		table.setSelectionForeground(Color.white);
		table.setRowHeight(30);
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(8, 340, 740, 265);
		c.add(pane);
		exp.addActionListener(this);
		add.addActionListener(this);
		cls.addActionListener(this);
		dlt.addActionListener(this);
		upd.addActionListener(this);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				int number = table.getSelectedRow();
				String nameString = model.getValueAt(number, 0).toString();
				String rollString = model.getValueAt(number, 1).toString();
				String gpaString = model.getValueAt(number, 2).toString();
				String numberString = model.getValueAt(number, 3).toString();
				namet.setText(nameString);
				rollt.setText(rollString);
				gpat.setText(gpaString);
				numbert.setText(numberString);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {
			rows[0] = namet.getText();
			rows[1] = rollt.getText();
			rows[2] = gpat.getText();
			rows[3] = numbert.getText();
//			System.out.println(rows[0]=="");
//			System.out.println(rows[1]=="");
//			System.out.println(rows[2]=="");
//			System.out.println(rows[3]=="");
//			System.out.println(rows[0]);
//			System.out.println(rows[1]);
//			System.out.println(rows[2]);
//			System.out.println(rows[3]);
			if (rows[0] == "" || rows[1] == "" || rows[2] == "" || rows[3] == "") {
				JOptionPane.showMessageDialog(null, "Something went wrong.");
			} else {
				student s = new student(rows[1], rows[3], rows[0], rows[2]);
				boolean ans = studentdao.insert(s);
				if (ans) {
					model.addRow(rows);
					JOptionPane.showMessageDialog(null, "student is added successfully....");
				} else {
					JOptionPane.showMessageDialog(null, "Something went wrong.Try again...");
				}
			}
		} else if (e.getSource() == cls) {
			namet.setText("");
			rollt.setText("");
			gpat.setText("");
			numbert.setText("");
		} else if (e.getSource() == dlt) {
			int numberofrow = table.getSelectedRow();
			if (numberofrow >= 0) {
				//System.out.println(rollt.getText());
				boolean ansd = studentdao.delete(rollt.getText());
				if (ansd) {
					model.removeRow(numberofrow);
					JOptionPane.showMessageDialog(null, "Deleted successfully....");
				} else {
					JOptionPane.showMessageDialog(null, "Something went wrong.Try again...");
				}
			} else {
				JOptionPane.showMessageDialog(null, "No row has been selected or No row Exist");
			}
		} 
		else if (e.getSource() == upd) {
			int number = table.getSelectedRow();
			String nameString = namet.getText();
			String rollString = rollt.getText();
			String gpaString = gpat.getText();
			String numberString = numbert.getText();
			model.setValueAt(nameString, number, 0);
			model.setValueAt(rollString, number, 1);
			model.setValueAt(gpaString, number, 2);
			model.setValueAt(numberString, number, 3);
//			System.out.println(rows[2]);
//			System.out.println(gpaString);
//			System.out.println(numberString);
//			System.out.println(nameString);
			boolean ans1= abc.update(nameString, gpaString, numberString,rollString);
			if (ans1) {
				JOptionPane.showMessageDialog(null, "Record is updated successfully....");
			} else {
				JOptionPane.showMessageDialog(null, "Something went wrong.Try again...");
			}
		} else if (e.getSource() == exp) {
			JFileChooser fchoose = new JFileChooser();
			int option = fchoose.showSaveDialog(exl.this);
			if (option == JFileChooser.APPROVE_OPTION) {
				String name = fchoose.getSelectedFile().getName();
				String path = fchoose.getSelectedFile().getParentFile().getPath();
				String file = path + "\\" + name + ".xls";
				export(table, new File(file));
			}
		}
	}

	public void export(JTable table, File file) {
		try {
			TableModel m = table.getModel();
			FileWriter fw = new FileWriter(file);

			for (int i = 0; i < m.getColumnCount(); i++) {
				fw.write(m.getColumnName(i) + "\t");
			}

			fw.write("\n");

			for (int i = 0; i < m.getRowCount(); i++) {
				for (int j = 0; j < m.getColumnCount(); j++) {
					fw.write(m.getValueAt(i, j).toString() + "\t");
				}
				fw.write("\n");
			}

			fw.close();
			System.out.println("Export Successfully....");
			System.exit(0);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) throws Exception {
		// FileOutputStream out = new FileOutputStream(new
		// File("C:\\Users\\SANJIDA\\Desktop\\java\\student.xlsx"));
		exl s = new exl();
		s.setVisible(true);
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s.setTitle("Project");
		s.setBounds(10, 20, 800, 700);
	}
}
