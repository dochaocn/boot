package com.dc.thread.pipeline.encrypt;

import com.dc.thread.pipeline.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * RSA加解密工具类
 *
 */
public class RSAUtil {
	
	//加密算法
	private static final String DEFAULT_ENCRYPT_ALGORITHM = "RSA";
	
	//RSA公钥
	private static PublicKey rsa_public_key = null;

	private static Cipher encryptCipher = null;

	/**
	 * 加载RSAPublicKey
	 */
	public static PublicKey readRSAPublicKey(String fileName) throws NoSuchAlgorithmException, IOException, InvalidKeySpecException {
		InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName));
		BufferedReader br = new BufferedReader(isr);
		StringBuilder builder = new StringBuilder();
		boolean inKey = false;
		for (String line = br.readLine(); line != null; line = br.readLine()) {
			line = line.trim();
			if (!inKey) {
				if (line.startsWith("-----BEGIN ") && line.endsWith(" PUBLIC KEY-----")) {
					inKey = true;
				}
				continue;
			} else {
				if (line.startsWith("-----END ") && line.endsWith(" PUBLIC KEY-----")) {
					inKey = false;
					break;
				}
				builder.append(line);
			}
		}
		br.close();
		isr.close();
		byte[] keyBytes = Base64.base64ToByteArray((builder.toString()));

		X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		PublicKey key = kf.generatePublic(spec);
		return key;
	}

	/**
	 * 初始化
	 */
	public static void init(PublicKey publicKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
		if(rsa_public_key == null && publicKey != null){
			rsa_public_key = publicKey;
			encryptCipher = Cipher.getInstance(DEFAULT_ENCRYPT_ALGORITHM);
			encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
		}
	}
	
	/**
	 * 加密数据
	 */
	public static synchronized byte[] encryptData(byte[] dataToEncrypt) throws IllegalBlockSizeException, BadPaddingException {
		return encryptCipher.doFinal(dataToEncrypt);
	}

}
