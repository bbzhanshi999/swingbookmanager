package edu.hyit.bm.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;

public class BookMaintainView extends JInternalFrame {
	private JTable bookGrid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookMaintainView frame = new BookMaintainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookMaintainView() {
		setClosable(true);
		setBounds(100, 100, 632, 599);
		
		JLabel lblNewLabel = new JLabel("修改图书");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		
		bookGrid = new JTable();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(267)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(52)
							.addComponent(bookGrid, GroupLayout.PREFERRED_SIZE, 496, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(68, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(bookGrid, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(160, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
