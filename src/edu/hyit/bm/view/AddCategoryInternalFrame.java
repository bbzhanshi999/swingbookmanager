package edu.hyit.bm.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.border.EmptyBorder;

import edu.hyit.bm.model.BookCategory;
import edu.hyit.bm.service.CategoryService;
import edu.hyit.bm.util.StringUtils;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCategoryInternalFrame extends JInternalFrame {
	private JTextField nameField;
	private JTextArea descField;
	private CategoryService categoryService = new CategoryService();;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCategoryInternalFrame frame = new AddCategoryInternalFrame();
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
	public AddCategoryInternalFrame() {
		setTitle("新增图书类型");
		setClosable(true);
		setBounds(100, 100, 489, 411);
		
		JLabel lblNewLabel = new JLabel("新增图书类型");
		lblNewLabel.setIcon(new ImageIcon(AddCategoryInternalFrame.class.getResource("/add.png")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setToolTipText("");
		
		JLabel categoryNameField = new JLabel("类型名称：");
		
		JLabel lblNewLabel_2 = new JLabel("类型描述：");
		
		nameField = new JTextField();
		nameField.setColumns(10);
		
		JButton saveBtn = new JButton("保存");
		saveBtn.addActionListener((e)->{
			String categoryName = this.nameField.getText();
			String desc = this.descField.getText();
			if(StringUtils.isBlank(categoryName)) {
				JOptionPane.showMessageDialog(null, "类型名称不能为空");
			}else {
				categoryService.save(new BookCategory(null,categoryName,desc));
				JOptionPane.showMessageDialog(null, "新增类型成功");
				this.nameField.setText("");
				this.descField.setText("");
			}
		});
		
		saveBtn.setIcon(new ImageIcon(AddCategoryInternalFrame.class.getResource("/save.png")));
		
		JButton reset = new JButton("重置");
		reset.addActionListener((e)->{
			this.nameField.setText("");
			this.descField.setText("");
		});
		reset.setIcon(new ImageIcon(AddCategoryInternalFrame.class.getResource("/reset.png")));
		
		descField = new JTextArea();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(117)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addGap(18)
									.addComponent(descField, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(categoryNameField)
									.addGap(18)
									.addComponent(nameField, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(saveBtn)
									.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
									.addComponent(reset))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(174)
							.addComponent(lblNewLabel)))
					.addGap(140))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(60)
					.addComponent(lblNewLabel)
					.addGap(62)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(categoryNameField)
						.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(descField, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(saveBtn)
						.addComponent(reset))
					.addGap(67))
		);
		getContentPane().setLayout(groupLayout);

	}
	public JTextArea getDescField() {
		return descField;
	}
}
