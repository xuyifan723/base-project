package com.xuyifan.commonutils.cryptogram;

import com.xuyifan.commonutils.common.ValidateUtils;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.*;
import java.security.Key;
import java.util.Base64;

/**  des加解密
 * @Author: xuyifan
 * @Date: 2020/4/24
 */
public class DESUtil {
    /**
     * 偏移变量，固定占8位字节
     */
    private final static String IV_PARAMETER = "12345678";
    /**
     * 密钥算法
     */
    private static final String ALGORITHM = "DES";
    /**
     * 加密/解密算法-工作模式-填充模式
     */
    private static final String CIPHER_ALGORITHM = "DES/CBC/PKCS5Padding";
    /**
     * 默认编码
     */
    private static final String CHARSET = "utf-8";



    private static final String DES_KEY="xuyifan_decryt";


    /**
     * 生成key
     *
     * @param password
     * @return
     * @throws Exception
     */
    private static Key generateKey(String password) throws Exception {
        DESKeySpec dks = new DESKeySpec(password.getBytes(CHARSET));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        return keyFactory.generateSecret(dks);
    }
    public static String encrypt(String data) {
        String encrypt = DESUtil.encrypt(DESUtil.DES_KEY, data);
        return encrypt;
    }

    /**
     * DES加密字符串
     *
     * @param deskey 加密密码，长度不能够小于8位
     * @param data 待加密字符串
     * @return 加密后内容
     */
    public static String encrypt(String deskey, String data) {
        ValidateUtils.validate(deskey== null || deskey.length() < 8,"加密失败，deskey不能小于8位");

        if (data == null)
            return null;
        try {
            Key secretKey = generateKey(deskey);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            IvParameterSpec iv = new IvParameterSpec(IV_PARAMETER.getBytes(CHARSET));
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
            byte[] bytes = cipher.doFinal(data.getBytes(CHARSET));

            //JDK1.8及以上可直接使用Base64，JDK1.7及以下可以使用BASE64Encoder
            //Android平台可以使用android.util.Base64
            return new String(Base64.getEncoder().encode(bytes));

        } catch (Exception e) {
            e.printStackTrace();
            return data;
        }
    }
    public static String decrypt( String data) {
        String decrypt = DESUtil.decrypt(DESUtil.DES_KEY, data);
        return decrypt;
    }
    /**
     * DES解密字符串
     *
     * @param deskey 解密密码，长度不能够小于8位
     * @param data 待解密字符串
     * @return 解密后内容
     */
    public static String decrypt(String deskey, String data) {
        ValidateUtils.validate(deskey== null || deskey.length() < 8,"加密失败，deskey不能小于8位");

        if (data == null)
            return null;
        try {
            Key secretKey = generateKey(deskey);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            IvParameterSpec iv = new IvParameterSpec(IV_PARAMETER.getBytes(CHARSET));
            cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
            return new String(cipher.doFinal(Base64.getDecoder().decode(data.getBytes(CHARSET))), CHARSET);
        } catch (Exception e) {
            e.printStackTrace();
            return data;
        }
    }
    public static String encryptFile( String srcFile, String destFile) {
        String val = DESUtil.encryptFile(DESUtil.DES_KEY, srcFile, destFile);
        return val;
    }
    /**
     * DES加密文件
     *
     * @param srcFile  待加密的文件
     * @param destFile 加密后存放的文件路径
     * @return 加密后的文件路径
     */
    public static String encryptFile(String deskey, String srcFile, String destFile) {

        ValidateUtils.validate(deskey== null || deskey.length() < 8,"加密失败，deskey不能小于8位");

        try {
            IvParameterSpec iv = new IvParameterSpec(IV_PARAMETER.getBytes(CHARSET));
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, generateKey(deskey), iv);
            InputStream is = new FileInputStream(srcFile);
            OutputStream out = new FileOutputStream(destFile);
            CipherInputStream cis = new CipherInputStream(is, cipher);
            byte[] buffer = new byte[1024];
            int r;
            while ((r = cis.read(buffer)) > 0) {
                out.write(buffer, 0, r);
            }
            cis.close();
            is.close();
            out.close();
            return destFile;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static String decryptFile( String srcFile, String destFile) {
        String val = DESUtil.decryptFile(DESUtil.DES_KEY, srcFile, destFile);
        return val;
    }
    /**
     * DES解密文件
     *
     * @param srcFile  已加密的文件
     * @param destFile 解密后存放的文件路径
     * @return 解密后的文件路径
     */
    public static String decryptFile(String deskey, String srcFile, String destFile) {
        ValidateUtils.validate(deskey== null || deskey.length() < 8,"加密失败，deskey不能小于8位");
        try {
            File file = new File(destFile);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            IvParameterSpec iv = new IvParameterSpec(IV_PARAMETER.getBytes(CHARSET));
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, generateKey(deskey), iv);
            InputStream is = new FileInputStream(srcFile);
            OutputStream out = new FileOutputStream(destFile);
            CipherOutputStream cos = new CipherOutputStream(out, cipher);
            byte[] buffer = new byte[1024];
            int r;
            while ((r = is.read(buffer)) >= 0) {
                cos.write(buffer, 0, r);
            }
            cos.close();
            is.close();
            out.close();
            return destFile;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        String encrypt = DESUtil.encrypt("xuyifan432");
        System.out.println(encrypt);
        String decrypt = DESUtil.decrypt(encrypt);
        System.out.println(decrypt);
    }
}
