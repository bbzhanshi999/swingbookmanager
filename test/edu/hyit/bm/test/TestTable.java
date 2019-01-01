package edu.hyit.bm.test;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TestTable {
	static JFrame jf = new JFrame();
	public static void main(String[] args) {
		String[] name={"姓名","号码"};
		String[] s1 = { "小王", "213213" };
		String[] s2 = { "小芳", "142321" };
		String data[][] = { s1, s2 };
		JTable table = new JTable(data,name);
		JScrollPane JSP= new JScrollPane(table);
		jf.add(JSP);
		jf.setTitle("练习");
		jf.setBounds(300, 300, 300, 300);
		jf.setVisible(true);
	}
}
