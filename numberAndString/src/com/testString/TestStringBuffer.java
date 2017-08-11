package com.testString;

public class TestStringBuffer {

	public static void main(String[] args) {
//        String str1 = "let there ";
// 
//        StringBuffer sb = new StringBuffer(str1); //根据str1创建一个StringBuffer对象
//        sb.append("be light"); //在最后追加
//         
//        System.out.println(sb);
//         
//        sb.delete(4 ,10);//删除4-10之间的字符
//         
//        System.out.println(sb);
//         
//        sb.insert(4, "there ");//在4这个位置插入 there
//         
//        System.out.println(sb);
//         
//        sb.reverse(); //反转
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
//        System.out.println("使用字符串+的方式，连接10000次，耗时"+(time2-time1)+"毫秒");
//        
        StringBuffer sb = new StringBuffer();
        String temp1 = new String(TestString.getCharArray(10));
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
			sb.append(temp1);
		}
        long end = System.currentTimeMillis();
        System.out.println("使用StringBuffer的方式，连接1000000次，耗时"+(end-start)+"毫秒");
        
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
		System.out.println("使用myStringBuffer的方式，连接1000000次，耗时"+(time2-time1)+"毫秒");
		
		try {
			msb.delete(-2);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
