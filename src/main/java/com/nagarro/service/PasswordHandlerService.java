/**
 * PasswordHandlerService
 * 
 * @author shaziyahasan
 *
 * Class to encrypt and decrypt password
 */

package com.nagarro.service;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.stereotype.Service;

@Service
public class PasswordHandlerService {
	public static final String AES = "AES";

	private static byte[] hexStringToByteArray(String string) {
		byte[] bytes = new byte[string.length() / 2];
		for (int i = 0; i < bytes.length; i++) {
			int index = i * 2;
			int v = Integer.parseInt(string.substring(index, index + 2), 16);
			bytes[i] = (byte) v;
		}
		return bytes;
	}

	/* Method to decrypt password */

	public String decryptPassword(String password) 
			throws NoSuchAlgorithmException, NoSuchPaddingException {
		
		//key generated from encryptor
		String key = "DADE709ADB6442A5CF6A02E113A6DF0A";
		String decryptedPassword = null;

		try {
			byte[] byteKey = hexStringToByteArray(key);

			SecretKeySpec specs = new SecretKeySpec(byteKey, PasswordHandlerService.AES);

			Cipher cipher = Cipher.getInstance(PasswordHandlerService.AES);
			cipher.init(Cipher.DECRYPT_MODE, specs);

			byte[] decrypted = cipher.doFinal(hexStringToByteArray(password));
			decryptedPassword = new String(decrypted);
		} catch (InvalidKeyException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return decryptedPassword;
	}
}
