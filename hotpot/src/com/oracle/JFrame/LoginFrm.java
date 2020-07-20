package com.oracle.JFrame;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.oracle.entity.User;
import com.oracle.service.UserServiceImpl;

public class LoginFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;
	private UserServiceImpl userServiceImpl = new UserServiceImpl();
	static User user = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrm frame = new LoginFrm();
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
	public LoginFrm() {
		setResizable(false);//设置不能最大化
		//改变系统默认字体
			Font font = new Font("Dialog", Font.PLAIN, 12);
			java.util.Enumeration keys = UIManager.getDefaults().keys();
			while (keys.hasMoreElements()) {
				Object key = keys.nextElement();
				Object value = UIManager.get(key);
				if (value instanceof javax.swing.plaf.FontUIResource) {
					UIManager.put(key, font);
				}
			}
		setTitle("\u9910\u5385\u70B9\u9910\u7CFB\u7EDF");
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u9910\u5385\u70B9\u9910\u7CFB\u7EDF\u6B22\u8FCE\u60A8");
		label.setFont(new Font("宋体", Font.BOLD, 22));
		label.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/OrderMeal.png")));
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		label_1.setFont(new Font("宋体", Font.BOLD, 15));
		label_1.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/userName.png")));
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5BC6  \u7801\uFF1A");
		label_2.setFont(new Font("宋体", Font.BOLD, 15));
		label_2.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/password.png")));
		
		passwordTxt = new JPasswordField();
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 15));
		btnNewButton.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/login.png")));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chongZhiActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 15));
		btnNewButton_1.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/reset.png")));
		
		JButton btnNewButton_2 = new JButton("\u6CE8\u518C\u7528\u6237");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerActionPerformed(e);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 15));
		btnNewButton_2.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/register.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(149)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(100)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton)
									.addGap(47)
									.addComponent(btnNewButton_1)
									.addGap(43)
									.addComponent(btnNewButton_2))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
										.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(passwordTxt))
									.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap(83, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addComponent(label)
					.addGap(63)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	//跳转到注册界面
	protected void registerActionPerformed(ActionEvent e) {
		this.dispose();//关闭当前的窗体
		RegisterFrm registerFrm = new RegisterFrm();
		registerFrm.setVisible(true);//跳转到注册页面并显示
		registerFrm.setLocationRelativeTo(null);
	}

	/*
	 * 重置
	 */
	protected void chongZhiActionPerformed(ActionEvent e) {
		userNameTxt.setText("");
		passwordTxt.setText("");
	}

	/*
	 *登录 :有get方法 90%都会对应一个set  
	 */
	@SuppressWarnings("deprecation")
	protected void LoginActionPerformed(ActionEvent e) {
		String userName = userNameTxt.getText();
 		String password = new String(passwordTxt.getPassword());//getPassword 返回的是一个char类型的数组
		//做用户登录功能
		User user1 = userServiceImpl.login(userName, password);
		if(user1!=null) {
			user = user1;
			JOptionPane.showMessageDialog(null, "登录成功！！！");
			dispose();//把之前窗体的隐藏
			AdminFrm adminFrm = new AdminFrm();
			adminFrm.setVisible(true);//如果你想让你的窗体显示 
		}else{
			JOptionPane.showMessageDialog(null, "用户名或密码错误！！！");
		}
	}
}
