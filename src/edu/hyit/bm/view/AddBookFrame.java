package edu.hyit.bm.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import edu.hyit.bm.model.BookCategory;
import edu.hyit.bm.service.CategoryService;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.Date;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddBookFrame extends JInternalFrame {
	private JTextField bookNameTxt;
	private JTextField authorTxt;
	private JTextField publisherTxt;
	private JSpinner dateSpinner;
	private JSpinner amountSpinner;
	private JComboBox categoryBox;
	
	private CategoryService categoryService=  new CategoryService();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBookFrame frame = new AddBookFrame();
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
	public AddBookFrame() {
		setFrameIcon(new ImageIcon(AddBookFrame.class.getResource("/add.png")));
		setTitle("新增图书");
		setClosable(true);
		setBounds(100, 100, 572, 525);
		
		JLabel titleLb = new JLabel("新增图书");
		titleLb.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel = new JLabel("书名：");
		
		JLabel lblNewLabel_1 = new JLabel("作者：");
		
		JLabel lblNewLabel_2 = new JLabel("发行商：");
		
		JLabel lblNewLabel_3 = new JLabel("出版日期：");
		
		JLabel lblNewLabel_4 = new JLabel("数量：");
		
		JLabel lblNewLabel_5 = new JLabel("类型：");
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		publisherTxt = new JTextField();
		publisherTxt.setColumns(10);
		
		SpinnerDateModel model = new SpinnerDateModel();
		dateSpinner = new JSpinner(model);
		dateSpinner.setValue(new Date());
        //设置时间格式
        JSpinner.DateEditor editor = new JSpinner.DateEditor(dateSpinner,
                "yyyy-MM-dd HH:mm:ss");
        dateSpinner.setEditor(editor);
		
		amountSpinner = new JSpinner();
		amountSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		categoryBox = new JComboBox();
		List<BookCategory> categorys = categoryService.findAll();
		categorys.stream().forEach(category->{
			categoryBox.addItem(category);
		});
		
		
		JButton saveBtn = new JButton("保存");
		saveBtn.addActionListener((e)->{
			System.out.println(this.categoryBox.getSelectedItem().getClass());
		});
		
		JButton resetBtn = new JButton("重置");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(216, Short.MAX_VALUE)
					.addComponent(titleLb, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addGap(200))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(104)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_5)
						.addComponent(saveBtn))
					.addGap(57)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(resetBtn)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(categoryBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(amountSpinner)
							.addComponent(dateSpinner)
							.addComponent(publisherTxt)
							.addComponent(authorTxt)
							.addComponent(bookNameTxt, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)))
					.addContainerGap(168, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(titleLb)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(publisherTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(dateSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(amountSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(categoryBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(saveBtn)
						.addComponent(resetBtn))
					.addContainerGap(123, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
	public JSpinner getDateSpinner() {
		return dateSpinner;
	}
	public JSpinner getAmountSpinner() {
		return amountSpinner;
	}
	public JComboBox getCategoryBox() {
		return categoryBox;
	}
}
