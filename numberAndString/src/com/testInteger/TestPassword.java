package com.testInteger;

public class TestPassword {

	public static void main(String[] args) {
		
		String password = getRandomString(3);
		System.out.println("原来的密码："+password);
		char[] gussPassword = new char[3];
		outloop:
		for (short i = '0'; i <= 'z'; i++) {
			for (short j = '0'; j <= 'z'; j++) {
				for (short k = '0';  k <= 'z'; k++) {
					if (Character.isLetterOrDigit(i)&&Character.isLetterOrDigit(j)&&Character.isLetterOrDigit(k)) {
						gussPassword[0] = (char) i;
						gussPassword[1] = (char) j;
						gussPassword[2] = (char) k;
						String newPassword = new String(gussPassword);
//						System.out.println("穷举出来的密码："+newPassword);
						if (password.equals(newPassword)) {
							System.out.println("找到密码是："+newPassword);
							break outloop;
						}
					}else {
						continue;
					}
				}
				
			}
		}
	}

	private static String getRandomString(int lenth) {

		String pool = "";
		for (short i = '0'; i <= '9'; i++) {
			pool += i ;
		}
		for (short i = 'a'; i <= 'z'; i++) {
			pool += i;
		}
		for (short i = 'A'; i <= 'Z'; i++) {
			pool += i;
		}
		char[] cs = new char[lenth];
		for (int i = 0; i < cs.length; i++) {
			int index = (int) (Math.random() * pool.length());
			cs[i] = pool.charAt(index);
		}
		String s = new String(cs);
		return s;
	}
	
}
