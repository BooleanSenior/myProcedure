package com.asop.jf.util;

public class FunctionUtil {

	/**
	 * 将字符串用.隔开每个数转换成2进制，然后不满足8位数就补0
	 * 为了门户路由ip对比的方法
	 * @param str
	 * @return
	 */
  public static  String StrToBinstr(String str) {
       String[] strChar=str.split("\\.");
        String result="";
        for(int i=0;i<strChar.length;i++){
        	int strInt=0;
        	if(i<strChar.length-1){
        		strInt=Integer.parseInt(strChar[i]);
        	}
            result +=format(Integer.toBinaryString(strInt),8);
        }
        return result;
    }
  /**
   * 将字符串不够8位的话 补0添加
   * @param num
   * @param len
   * @return
   */
  public static String  format(String num,int len){ 
		int l = num.length(); 
		if (l < len) { 
			for (int i = 0; i < len - l; i++) { 
				num = "0" + num;
			} 
		} 
		return num; 
	}
  
  
}
