package com.vpn.website.client.util;


import com.vpn.website.common.core.Base64;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/*
 * 实现MD5加盐加密与解密
 */
public class SecurityTool {
	private static MessageDigest md5;//md5加密对象
	private static Base64 base64;//加密编码对象
	private static final int saltLen = 8;//盐长度
	private static String salt = "";//盐

	static{
		try {
			md5 = MessageDigest.getInstance("MD5");//获取MD5加密对象
			base64 = new Base64();//获取加密编码对象
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取一个随机盐值
	 * @return
	 */
	public static String getSalt(){
		Random random = new Random();
		String str = "qwertyuiopasdfghjklzxcvbnm1234567890+-=*;',.";
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<saltLen;i++){
			sb.append(String.valueOf(str.charAt(random.nextInt(str.length()))));
		}
		return sb.toString();
	}

	/**
	 * 对密码进行加密
	 * @param password  用户密码
	 * @param salt  盐值
	 * @return
	 */
	public static String encrypt(String password,String salt){
		if(StringUtils.isEmpty(salt)){
			salt = "";
		}
		String passwordSalt = password + salt;//将密码和盐拼接到一起
		return DigestUtils.md5DigestAsHex(passwordSalt.getBytes());
	}

 	public static void main(String[] args) {
		String salt = getSalt();
		String password = "123456";
		String passwordSalt = password+salt;

		System.out.println(encrypt("123456",salt));

		String pwd = DigestUtils.md5DigestAsHex(passwordSalt.getBytes());
		System.out.println(pwd);

	}

}