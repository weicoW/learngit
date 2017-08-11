package com.testString;

public class TestStringBuffer {

	public static void main(String[] args) {
//        String str1 = "let there ";
// 
//        StringBuffer sb = new StringBuffer(str1); //����str1����һ��StringBuffer����
//        sb.append("be light"); //�����׷��
//         
//        System.out.println(sb);
//         
//        sb.delete(4 ,10);//ɾ��4-10֮����ַ�
//         
//        System.out.println(sb);
//         
//        sb.insert(4, "there ");//��4���λ�ò��� there
//         
//        System.out.println(sb);
//         
//        sb.reverse(); //��ת
//         
//        System.out.println(sb);
//        
//        System.out.println(sb.length());
//        System.out.println(sb.capacity());
		
//		String ss = new String();
//		String temp = new String(TestString.getCharArray(10));
//		long time1 =  System.currentTimeMillis();
//        for (int i = 0; i < 10000; i++) {
//			ss += temp;
//		}
//        long time2 = System.currentTimeMillis();
//        System.out.println("ʹ���ַ���+�ķ�ʽ������10000�Σ���ʱ"+(time2-time1)+"����");
//        
        StringBuffer sb = new StringBuffer();
        String temp1 = new String(TestString.getCharArray(10));
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
			sb.append(temp1);
		}
        long end = System.currentTimeMillis();
        System.out.println("ʹ��StringBuffer�ķ�ʽ������1000000�Σ���ʱ"+(end-start)+"����");
        
		MyStringBuffer msb = new MyStringBuffer();
		String temp = new String(TestString.getCharArray(10));
		long time1 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			try {
				msb.append(temp);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long time2 = System.currentTimeMillis();
		System.out.println("ʹ��myStringBuffer�ķ�ʽ������1000000�Σ���ʱ"+(time2-time1)+"����");
		
		try {
			msb.delete(-2);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
