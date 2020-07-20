package com.oracle.tools;

public class RegexTools {
	//验证用户名  校验规则 ：数字 字母 _  并且 数字不能开头，长度5-10
	public static boolean  regexUserName(String username) {
		return username.matches("^[a-zA-Z_]\\w{4,9}$");
	}
	//密码校验：有字母数字和特殊字符(*&._)组成 
	public static boolean  regexPassword(String password) {
		return password.matches("[a-zA-Z0-9*&._]{6,10}");
	}
	//邮箱校验： 
	public static boolean  regexEmail(String email) {
		return email.matches("\\w+@\\w+\\.\\[a-zA-Z]{2,3}");
	}
	 
	
	
}
