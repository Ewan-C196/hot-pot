package com.oracle.JFrame;

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
import javax.swing.border.EmptyBorder;

import com.oracle.entity.User;
import com.oracle.service.UserServiceImpl;
import com.oracle.tools.RegexTools;

public class RegisterFrm extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTxt;
	private JTextField numberTxt;
	private JPasswordField passwordTxt;
	private JPasswordField pswTxt;
	private UserServiceImpl uerServiceImpl = new UserServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrm frame = new RegisterFrm();
					frame.setLocationRelativeTo(null);
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
	public RegisterFrm() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u65B0\u7528\u6237\u6CE8\u518C");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 22));
		lblNewLabel.setIcon(new ImageIcon(RegisterFrm.class.getResource("/images/new_register.png")));
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 15));
		lblNewLabel_1.setIcon(new ImageIcon(RegisterFrm.class.getResource("/images/new_user.png")));
		
		
		usernameTxt = new JTextField();
		usernameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6  \u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 15));
		lblNewLabel_2.setIcon(new ImageIcon(RegisterFrm.class.getResource("/images/new_password.png")));
		
		JLabel label = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label.setFont(new Font("宋体", Font.BOLD, 15));
		label.setIcon(new ImageIcon(RegisterFrm.class.getResource("/images/password_config.png")));
		
		JLabel label_1 = new JLabel("\u7535\u8BDD\u53F7\u7801\uFF1A");
		label_1.setFont(new Font("宋体", Font.BOLD, 15));
		label_1.setIcon(new ImageIcon(RegisterFrm.class.getResource("/images/email.png")));
		
		numberTxt = new JTextField();
		numberTxt.setColumns(10);
		
		passwordTxt = new JPasswordField();
		
		pswTxt = new JPasswordField();
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 15));
		btnNewButton.setIcon(new ImageIcon(RegisterFrm.class.getResource("/images/register.png")));
		
		JButton button = new JButton("\u91CD\u7F6E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetActionPerformed(e);
			}
		});
		button.setFont(new Font("宋体", Font.BOLD, 15));
		button.setIcon(new ImageIcon(RegisterFrm.class.getResource("/images/reset.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(155, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addGap(114))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(58)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(pswTxt, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2)
								.addComponent(label_1))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(numberTxt, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
								.addComponent(passwordTxt, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
								.addComponent(usernameTxt, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))))
					.addContainerGap(71, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(131, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(76)
					.addComponent(button)
					.addGap(81))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(50)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(usernameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_2)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(pswTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(35)
							.addComponent(label_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(32)
							.addComponent(numberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(btnNewButton))
					.addGap(35))
		);
		contentPane.setLayout(gl_contentPane);
	}
	/*
	 * 重置
	 */
	protected void resetActionPerformed(ActionEvent e) {
		usernameTxt.setText("");
		passwordTxt.setText("");
		pswTxt.setText("");
		numberTxt.setText("");
		
	}

	/*
	 * 注册
	 */
	protected void registerActionPerformed(ActionEvent evt) {
		String username = usernameTxt.getText();
		String password = new String(passwordTxt.getPassword());
		String psw = new String(pswTxt.getPassword());
		String uNumber = numberTxt.getText();
		//判断 接受到的参数是否为空 如果为空 提示用户错误信息        "   a b c    "                   
		if(username==null||"".equals(username.replaceAll(" ", ""))) {
			if(!RegexTools.regexUserName(username)) {
				JOptionPane.showMessageDialog(null, "用户名不符合规则！！！！");
			}
			return;
		}  
		if(password==null||"".equals(password.replaceAll(" ", ""))) {
			if(!RegexTools.regexPassword(password)) {
				JOptionPane.showMessageDialog(null, "密码不符合规则！！！！");
			}
 			return;
		} 
		//==    equals区别
		if(!password.equals(psw)) {
			JOptionPane.showMessageDialog(null, "两次输入的密码不一致！！！！");
			return;
		}
		if(uNumber==null||"".equals(uNumber.replaceAll(" ", ""))) {
			if(!RegexTools.regexEmail(uNumber)) {
				JOptionPane.showMessageDialog(null, "邮箱不符合规则！！！！");
			}
 			return;
		}
		User user =new User();//也可以使用构造方法去创建对象
		user.setuNumber(uNumber);
		user.setPassword(password);
		user.setUserName(username);
		 
		//注册用户前 我们需要去数据库中查询用户名是否存在，如果存在提示用户名已存在，否则正常注册
		if(uerServiceImpl.getUserByName(username)) {
			boolean b = uerServiceImpl.register(user);
			if(b) {
				JOptionPane.showMessageDialog(null, "恭喜您注册成功！！！");
				dispose();//把之前窗体的隐藏
				LoginFrm loginFrm = new LoginFrm();
				loginFrm.setVisible(true);
				loginFrm.setLocationRelativeTo(null);
				return;
			}
				JOptionPane.showMessageDialog(null, "注册失败！！！");
				return;
		}
			JOptionPane.showMessageDialog(null, "用户名已经存在，请重新输入！！！");
			return;
	}
	
}
