package com.oracle.JFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminFrm extends JFrame {

	private JPanel contentPane;
	JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrm frame = new AdminFrm();
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
	public AdminFrm() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("\u70B9\u9910\u7CFB\u7EDF\u7BA1\u7406\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 449);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("\u5957\u9910\u4FE1\u606F\u7BA1\u7406");
		menu.setIcon(new ImageIcon(AdminFrm.class.getResource("/images/base.png")));
		menuBar.add(menu);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u65B0\u589E\u5957\u9910");
		menu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("\u5957\u9910\u7EF4\u62A4");
		menu.add(mntmNewMenuItem);

		JMenu menu_1 = new JMenu("\u8BA2\u5355\u7BA1\u7406");
		menu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menu_1.setIcon(new ImageIcon(AdminFrm.class.getResource("/images/bookManager.png")));
		menuBar.add(menu_1);

		JMenuItem menuItem = new JMenuItem("\u8BA2\u5355\u7BA1\u7406");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addorder(e);
			}
		});
		menuItem.setIcon(new ImageIcon(AdminFrm.class.getResource("/images/bookManager.png")));
		menu_1.add(menuItem);

		JMenu menu_2 = new JMenu("\u5176\u4ED6");
		menu_2.setIcon(new ImageIcon(AdminFrm.class.getResource("/images/about.png")));
		menuBar.add(menu_2);

		JMenuItem menuItem_1 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editPasswordActionPerformed(e);
			}
		});
		menu_2.add(menuItem_1);

		JMenuItem menuItem_2 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitSystemactionPerformed(e);
			}
		});
		menu_2.add(menuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}
	protected void addorder(ActionEvent e) {
		EditUserInfoInterFrm editUserInfoInterFrm = new EditUserInfoInterFrm();
		editUserInfoInterFrm.setVisible(true);
		desktopPane.add(editUserInfoInterFrm);
	}

	//退出系统
	protected void exitSystemactionPerformed(ActionEvent e) {
		System.exit(0);
	}

	/*
	 * 跳转到修改用户信息的窗体
	 */
	protected void editPasswordActionPerformed(ActionEvent e) {
		EditUserInfoInterFrm editUserInfoInterFrm = new EditUserInfoInterFrm();
		editUserInfoInterFrm.setVisible(true);
		desktopPane.add(editUserInfoInterFrm);
	}

}
