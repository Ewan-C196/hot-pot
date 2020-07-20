package com.oracle.JFrame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.oracle.service.UserServiceImpl;

public class EditUserInfoInterFrm extends JInternalFrame {
	private JTextField usernameTxt;
	private JPasswordField oldPasswordTxt;
	private JPasswordField newPasswordTxt;
	private JPasswordField newPswTxt;
	private UserServiceImpl userServiceImpl = new UserServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditUserInfoInterFrm frame = new EditUserInfoInterFrm();
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
	public EditUserInfoInterFrm() {
		usernameTxt.setText(LoginFrm.user.getUserName());// 把用户名写到txt中
		setTitle("\u8D26\u6237\u4FE1\u606F\u4FEE\u6539");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 548, 430);

		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(EditUserInfoInterFrm.class.getResource("/images/userName.png")));

		usernameTxt = new JTextField();
		usernameTxt.setEditable(false);
		usernameTxt.setColumns(10);

		JLabel label = new JLabel("\u65E7\u5BC6\u7801\uFF1A");
		label.setIcon(new ImageIcon(EditUserInfoInterFrm.class.getResource("/images/password.png")));

		oldPasswordTxt = new JPasswordField();

		JLabel label_1 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		label_1.setIcon(new ImageIcon(EditUserInfoInterFrm.class.getResource("/images/new_password.png")));

		newPasswordTxt = new JPasswordField();

		JLabel label_2 = new JLabel("\u65B0\u5BC6\u7801\u786E\u8BA4\uFF1A");

		newPswTxt = new JPasswordField();

		JButton btnNewButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		btnNewButton.setIcon(new ImageIcon(EditUserInfoInterFrm.class.getResource("/images/edit.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editDoUserActionPerformed(e);
			}
		});

		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setIcon(new ImageIcon(EditUserInfoInterFrm.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(23)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel).addComponent(label).addComponent(label_1)))
								.addGroup(groupLayout.createSequentialGroup().addGap(31).addComponent(label_2)))
						.addGap(23)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false).addComponent(newPswTxt)
								.addComponent(newPasswordTxt, Alignment.TRAILING).addComponent(oldPasswordTxt)
								.addComponent(usernameTxt, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup().addGap(72).addComponent(btnNewButton).addGap(86)
								.addComponent(btnNewButton_1)))
				.addContainerGap(160, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(74)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel).addComponent(
						usernameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(27)
				.addGroup(groupLayout
						.createParallelGroup(Alignment.BASELINE).addComponent(label).addComponent(oldPasswordTxt,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(25)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(label_1)
						.addComponent(newPasswordTxt, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
				.addGap(29)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(newPswTxt, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
				.addGap(47).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
				.addContainerGap(72, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);

	}

	/*
	 * 对用户信息进行修改
	 */
	protected void editDoUserActionPerformed(ActionEvent e) {
		//
		String username = usernameTxt.getText();
		String oldPassword = new String(oldPasswordTxt.getPassword());
		String newPassword = new String(newPasswordTxt.getPassword());
		String newPsw = new String(newPswTxt.getPassword());
		// 自己去判断一下2次新输入的密码是否一致
		if (oldPassword.equals(LoginFrm.user.getPassword())) {
			int i = userServiceImpl.editPassword(newPassword, LoginFrm.user.getId());
			if (i > 0) {
				JOptionPane.showMessageDialog(null, "成功");
				return;
			}
			JOptionPane.showMessageDialog(null, "失败");
			return;
		}

	}

}
