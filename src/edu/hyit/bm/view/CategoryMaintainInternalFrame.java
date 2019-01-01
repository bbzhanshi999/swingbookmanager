package edu.hyit.bm.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TrayIcon.MessageType;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import edu.hyit.bm.model.BookCategory;
import edu.hyit.bm.service.CategoryService;
import edu.hyit.bm.util.StringUtils;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class CategoryMaintainInternalFrame extends JInternalFrame {
	private JTextField searchText;
	private JTable categoryGrid;
	private CategoryService categoryService=  new CategoryService();
	private JTextField nameField;
	private JTextField idField;
	private JTextArea descField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CategoryMaintainInternalFrame frame = new CategoryMaintainInternalFrame();
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
	public CategoryMaintainInternalFrame() {
		setClosable(true);
		setBounds(200, 200, 599, 536);
		
		JLabel titleLabel = new JLabel("图书类型维护");
		titleLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label = new JLabel("输入类型名称：");
		
		searchText = new JTextField();
		searchText.setColumns(10);
		
		JButton searchBtn = new JButton("查询");
		searchBtn.addActionListener((e)->{
			fillTable(this.searchText.getText());
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	
		

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(228)
							.addComponent(titleLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(62)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(searchText, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
									.addGap(36)
									.addComponent(searchBtn))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(72, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(titleLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(searchText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchBtn))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("类型名称");
		
		nameField = new JTextField();
		nameField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("类型描述");
		
		descField = new JTextArea();
		
		JButton modifyBtn = new JButton("修改");
		modifyBtn.addActionListener((e)->{
			if(StringUtils.isBlank(idField.getText())) {
				JOptionPane.showMessageDialog(null, "请选择一条记录", "错误", 0);
			}else {
				categoryService.save(new BookCategory(Integer.valueOf(idField.getText()),nameField.getText(),descField.getText()));
				fillTable(null);
				clearForm();
			}
		});
		modifyBtn.setIcon(new ImageIcon(CategoryMaintainInternalFrame.class.getResource("/modify.png")));
		
		JButton deleteBtn = new JButton("删除");
		deleteBtn.addActionListener((e)->{
			if(StringUtils.isBlank(idField.getText())) {
				JOptionPane.showMessageDialog(null, "请选择一条记录", "错误", 0);
			}else {
				int result = JOptionPane.showConfirmDialog(null, "是否确认删除？");
				if(result==0) {
					categoryService.delete(Integer.valueOf(idField.getText()));
					fillTable(null);
					clearForm();
				}
			}
		});
	
		deleteBtn.setIcon(new ImageIcon(CategoryMaintainInternalFrame.class.getResource("/delete.png")));
		
		JLabel label_1 = new JLabel("编号");
		
		idField = new JTextField();
		idField.setEditable(false);
		idField.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(61)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(modifyBtn)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(deleteBtn))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(label_1))
							.addGap(34)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(nameField)
								.addComponent(descField, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
								.addComponent(idField))))
					.addContainerGap(87, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(13)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(descField, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(modifyBtn)
						.addComponent(deleteBtn))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		categoryGrid = new JTable();
		
		categoryGrid.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		categoryGrid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//点击后更新表单操作
				
				int selectedColumn = categoryGrid.getSelectedColumn();
				idField.setText(categoryGrid.getValueAt(selectedColumn, 0)+"");
				nameField.setText(categoryGrid.getValueAt(selectedColumn, 1)+"");
				descField.setText(categoryGrid.getValueAt(selectedColumn, 2)+"");
			}
		});
		categoryGrid.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u7C7B\u578B\u540D\u79F0", "\u7C7B\u578B\u63CF\u8FF0"
			}
		));
		categoryGrid.getColumnModel().getColumn(2).setPreferredWidth(150);
		
		scrollPane.setViewportView(categoryGrid);
		getContentPane().setLayout(groupLayout);
		fillTable(null);
	}

	private void clearForm() {
		idField.setText("");
		nameField.setText("");
		descField.setText("");
	}

	private void fillTable(String query) {
		DefaultTableModel model = (DefaultTableModel) this.categoryGrid.getModel();
		model.setRowCount(0);//清空表格原内容
		List<BookCategory> categoryList = null;
		if(StringUtils.isBlank(query)) {
			categoryList = categoryService.findAll();
		}else {
			categoryList = categoryService.findByCategoryNameLike(query);
		}
		for(BookCategory category:categoryList) {
			model.addRow(new Object[] {category.getId(),category.getCategoryName(),category.getDescription()});
		}
	}
	public JTextArea getDescField() {
		return descField;
	}
}
