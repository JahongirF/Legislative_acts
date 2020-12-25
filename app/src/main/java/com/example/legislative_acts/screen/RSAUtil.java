package com.example.legislative_acts.screen;

import android.util.Base64;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;


public class RSAUtil {

    public static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDOoZBMKU40wM5I+cu4S2qXvJLCVszFlnPACAYFnUkZM2HjqJCI5aYCu3cyd3/eJhqEcm8Jm7daSzuUjH9HYPib3+XUoeSM+zv2eNdWtaZZDnWmbqOuvRbmgtxFFmI3SO2y94zIdEoG13UpP2VkNWlmpKDSo4WCoO6XNsSMmhP/QQIDAQAB";
    public static String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAM6hkEwpTjTAzkj5y7hLape8ksJWzMWWc8AIBgWdSRkzYeOokIjlpgK7dzJ3f94mGoRybwmbt1pLO5SMf0dg+Jvf5dSh5Iz7O/Z411a1plkOdaZuo669FuaC3EUWYjdI7bL3jMh0SgbXdSk/ZWQ1aWakoNKjhYKg7pc2xIyaE/9BAgMBAAECgYEApPzaRAXjPToKPLjAEqqdNQVMRcKbBNXqHJYLgOYi3O1rJyWMKtL7qEjZl0FVpyLTn5fj008zqvRRYX6BjpP+TMCI8mhwY21+ya3AViSMjl2vYxyb9Yk04nwyuWYsOCQV1FzR+RQ25KtocmubcLaG4kiVQrhGGybA/4+vhvbT6HUCQQDuMydtI+BZ2hUTxFWuKQ1h7yGJMUEN0Mo0Q2s5WRX5IfwS4rMQFBCk9fmMMwXhD9AK2fNWiVB/UteK7O8aQ0h7AkEA3hJ9N6KVYjMSXgPLgAwrp17QzXDkQRilCV9bGWRE1PlmWJnpIuks7InzKOCjmiXa4LcCsVBN1gi74uSUwVxQcwJANYinnr7GaEs8G3Ivs3GkgVMmHVhFf55iI3bXfU8JQjGiHnh2t/FagEiL6jd5ZciRAC9VoihAQC1VJfL0FdnzSwJAQ5/Tu75pyRaOUEzNineqT3RjFzx6dYxArYL5JdlP0J8F2JM92GCzSnCTuG33w/glF+sDCeXPXg8Yz/YVinBHGwJAbNUu7hIWf4FIe9XqS5ECaxg+cSawVLQSrBZGpsiJ6f+UgXjss00NqADBEkFM8dAvobwUdJW53a+q26zuYv1Hpw==";

    public static PublicKey getPublicKey(String base64PublicKey) {
        PublicKey publicKey = null;
        try {
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.decode(base64PublicKey.getBytes(), Base64.DEFAULT));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            publicKey = keyFactory.generatePublic(keySpec);
            return publicKey;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return publicKey;
    }

    public static PrivateKey getPrivateKey(String base64PrivateKey) {
        PrivateKey privateKey = null;
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.decode(base64PrivateKey.getBytes(), Base64.DEFAULT));
        KeyFactory keyFactory = null;
        try {
            keyFactory = KeyFactory.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            privateKey = keyFactory.generatePrivate(keySpec);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return privateKey;
    }

    public static byte[] encrypt(String data, String publicKey) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(publicKey));
        return cipher.doFinal(data.getBytes());
    }

    public static String decrypt(byte[] data, PrivateKey privateKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(cipher.doFinal(data));
    }

    public static String decrypt(String data, String base64PrivateKey) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        return decrypt(Base64.decode(data.getBytes(), Base64.DEFAULT), getPrivateKey(base64PrivateKey));
    }

    public static void main(String[] args) throws IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, BadPaddingException {
        try {
            String encryptedString = Base64.encodeToString(encrypt("Salom Jasur", publicKey), Base64.DEFAULT);
            System.out.println(encryptedString);

            /*String decryptedString = RSAUtil.decrypt("MYnqec5fSPBqUrnSiyQtswQgmzFGagHqsiZ7/8XAT+Jb2786YoITow60JU3yb19YcseU4rmGJik6EFRSbpT0bLmSkVfMswzvDjxd25X7LtuEziLx+WYIW07kGN3gR5bVUFriF4WUW2lI7CJ/J8Q2FT8XBM39H7hg2sK5mNPbyYA=", privateKey);
            System.out.println(decryptedString);*/
        } catch (NoSuchAlgorithmException e) {
            System.err.println(e.getMessage());
        }

    }
}
