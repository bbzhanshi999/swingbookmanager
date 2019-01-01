package edu.hyit.bm.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import edu.hyit.bm.model.User;
import edu.hyit.bm.service.UserService;
import edu.hyit.bm.util.StringUtils;
import java.awt.Toolkit;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField usrField;
	private JPasswordField pwdField;
	private UserService userService = new UserService();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//全局载入字体
					Font f = new Font("宋体",Font.PLAIN,14);
					String   names[]={ "Label", "CheckBox", "PopupMenu","MenuItem", "CheckBoxMenuItem",
							"JRadioButtonMenuItem","ComboBox", "Button", "Tree", "ScrollPane",
							"TabbedPane", "EditorPane", "TitledBorder", "Menu", "TextArea",
							"OptionPane", "MenuBar", "ToolBar", "ToggleButton", "ToolTip",
							"ProgressBar", "TableHeader", "Panel", "List", "ColorChooser",
							"PasswordField","TextField", "Table", "Label", "Viewport",
							"RadioButtonMenuItem","RadioButton", "DesktopPane", "InternalFrame"
					}; 
					for (String item : names) {
						 UIManager.put(item+ ".font",f); 
					}
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null); //弹窗居中
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginForm.class.getResource("/hyit.png")));
		setTitle("\u767B\u9646\u9875\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel headLb = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		headLb.setIcon(new ImageIcon(LoginForm.class.getResource("/1.png")));
		headLb.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		headLb.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel usrLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		usrLabel.setIcon(new ImageIcon(LoginForm.class.getResource("/username.png")));
		
		JLabel pwdLabel = new JLabel("密  码：");
		pwdLabel.setIcon(new ImageIcon(LoginForm.class.getResource("/password.png")));
		usrField = new JTextField();
		usrField.setColumns(10);
		
		JButton loginBtn = new JButton("\u767B\u5F55");
		loginBtn.setIcon(new ImageIcon(LoginForm.class.getResource("/login.png")));
		loginBtn.addActionListener((event)->{
			String username = this.usrField.getText();
			String password = new String(this.pwdField.getPassword());
			if(StringUtils.isBlank(username)) {
				JOptionPane.showMessageDialog(null, "用户名不能为空");
			} else if (StringUtils.isBlank(password)) {
				JOptionPane.showMessageDialog(null, "密码不能为空");
			} else {
				User principal = userService.login(new User(null,username,password));
				if(principal!=null) {
					this.dispose();//关闭当前窗口
					IndexForm indexForm = new IndexForm();
					indexForm.setVisible(true);
					indexForm.setLocationRelativeTo(null);
				}else {
					JOptionPane.showMessageDialog(null, "用户名或密码输入错误");
				}
			}
			
		});
		
		
		
		JButton resetBtn = new JButton("\u91CD\u7F6E");
		resetBtn.setIcon(new ImageIcon(LoginForm.class.getResource("/reset.png")));
		resetBtn.addActionListener((e)->{
			this.usrField.setText("");
			this.pwdField.setText("");
		});
		
		pwdField = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(127)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(usrLabel)
								.addComponent(pwdLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(pwdField)
								.addComponent(usrField, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(164)
							.addComponent(loginBtn)
							.addGap(49)
							.addComponent(resetBtn))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(190)
							.addComponent(headLb)))
					.addContainerGap(174, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(72)
					.addComponent(headLb)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(usrLabel)
						.addComponent(usrField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(pwdLabel)
						.addComponent(pwdField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginBtn)
						.addComponent(resetBtn))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
