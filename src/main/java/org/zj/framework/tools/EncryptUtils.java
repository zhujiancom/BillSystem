/**
 * 
 */
package org.zj.framework.tools;

import java.security.MessageDigest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @Description
 * @author zj
 * @Date 2014年7月9日
 */
public class EncryptUtils{
	public static Log log = LogFactory.getLog(EncryptUtils.class);

	public static String MD5(String str){
		try{
			byte[] psw = str.getBytes();
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(psw);
			byte[] mdPsw = md.digest();
			return byteToHex(mdPsw);
		}
		catch(Exception e){
			log.warn("Encrypt string error!",e);
			return str;
		}
	}

	private static String encryptInner(String md5){
		char[] a = md5.toCharArray();
		for(int i = 0; i < a.length; i++){
			a[i] = (char) (a[i] ^ 't');
		}
		String s = new String(a);
		return s;
	}

	public static String encrypt(String inStr){
		return encryptInner(MD5(inStr));
	}

	public static String decode(String inStr){
		return encryptInner(encryptInner(MD5(inStr)));
	}

	public static String byteToHex(byte[] bt){
		StringBuilder sb = new StringBuilder(4);
		for(int b : bt){
			sb.append(Integer.toHexString(b & 0x00FF | 0xFF00).substring(2,4));
		}
		return sb.toString();
	}
	//
	public static void main(String args[]) {
		String s = new String("admin123");
		System.out.println("原始：" + s);
		System.out.println("MD5后：" + MD5(s));
		//		System.out.println("对MD5加密后2： "+encrypt(s));
		//		System.out.println("对MD5解密后： "+decode(s));
	}
}
