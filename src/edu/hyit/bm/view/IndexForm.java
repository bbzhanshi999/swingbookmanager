package edu.hyit.bm.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;

public class IndexForm extends JFrame {

	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public IndexForm() {
		setTitle("主菜单");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu basicMenu = new JMenu("基本设置");
		basicMenu.setIcon(new ImageIcon(IndexForm.class.getResource("/settings.png")));
		basicMenu.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(basicMenu);
		
		JMenu categoryMenu = new JMenu("图书类别管理");
		categoryMenu.setIcon(new ImageIcon(IndexForm.class.getResource("/category.png")));
		basicMenu.add(categoryMenu);
		
		JMenuItem addCategoryItem = new JMenuItem("新增图书类别");
		addCategoryItem.addActionListener((e)->{
			AddCategoryInternalFrame addCategoryFrame = new AddCategoryInternalFrame();
			addCategoryFrame.setVisible(true);
			this.add(addCategoryFrame);
		
			addCategoryFrame.setBounds(400, 200, 500, 500);
		});
		addCategoryItem.setIcon(new ImageIcon(IndexForm.class.getResource("/add.png")));
		categoryMenu.add(addCategoryItem);
		
		JMenuItem categoryMainItem = new JMenuItem("图书类别维护");
		
		categoryMainItem.addActionListener((e)->{
			CategoryMaintainInternalFrame categoryMaintainInternalFrame = new CategoryMaintainInternalFrame();
			categoryMaintainInternalFrame.setVisible(true);
			this.add(categoryMaintainInternalFrame);
			categoryMaintainInternalFrame.setBounds(400, 200, 600, 600);
		});
		
		
		
		categoryMainItem.setIcon(new ImageIcon(IndexForm.class.getResource("/maintain.png")));
		categoryMenu.add(categoryMainItem);
		
		JMenu menu_1 = new JMenu("图书管理");
		menu_1.setIcon(new ImageIcon(IndexForm.class.getResource("/book.png")));
		basicMenu.add(menu_1);
		
		JMenuItem menuItem_1 = new JMenuItem("新增图书");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBookFrame addBookFrame = new AddBookFrame();
				addBookFrame.setVisible(true);
				getContentPane().add(addBookFrame);
				addBookFrame.setBounds(400, 200, 600, 600);
			}
		});
		menu_1.add(menuItem_1);
		
		
		JMenuItem menuItem_2 = new JMenuItem("图书维护");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//todo
			}
		});
		menu_1.add(menuItem_2);
		
		JMenuItem logoutMenuItem = new JMenuItem("退出系统");
		logoutMenuItem.addActionListener((e)->{
			int flag = JOptionPane.showConfirmDialog(null, "是否确定退出？");
			if(flag==0) {
				this.dispose();
			}
		});
		logoutMenuItem.setIcon(new ImageIcon(IndexForm.class.getResource("/logout.png")));
		basicMenu.add(logoutMenuItem);
		
		JMenu menu_2 = new JMenu("关于我们");
		menu_2.setIcon(new ImageIcon(IndexForm.class.getResource("/about.png")));
		menuBar.add(menu_2);
		
		JMenuItem menuItem_3 = new JMenuItem("关于淮阴工学院");
		menuItem_3.setIcon(new ImageIcon(IndexForm.class.getResource("/about.png")));
		menu_2.add(menuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		ImageIcon background = new ImageIcon("/background.jpg");
		JLabel backgroundlabel = new JLabel(background);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(backgroundlabel, GroupLayout.PREFERRED_SIZE, 1674, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(backgroundlabel, GroupLayout.PREFERRED_SIZE, 969, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);//设置最大化
	}
}
