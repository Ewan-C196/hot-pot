package com.oracle.tools;

public class RegexTools {
	//��֤�û���  У����� ������ ��ĸ _  ���� ���ֲ��ܿ�ͷ������5-10
	public static boolean  regexUserName(String username) {
		return username.matches("^[a-zA-Z_]\\w{4,9}$");
	}
	//����У�飺����ĸ���ֺ������ַ�(*&._)��� 
	public static boolean  regexPassword(String password) {
		return password.matches("[a-zA-Z0-9*&._]{6,10}");
	}
	//����У�飺 
	public static boolean  regexEmail(String email) {
		return email.matches("\\w+@\\w+\\.\\[a-zA-Z]{2,3}");
	}
	 
	
	
}
