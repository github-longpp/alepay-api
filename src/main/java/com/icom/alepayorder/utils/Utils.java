package com.icom.alepayorder.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Utils {
    public static String randomOrderCode() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 11;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    public static String generateHmac256(String message, byte[] key) throws InvalidKeyException, NoSuchAlgorithmException {
        byte[] bytes = hmac("HmacSHA256", key, message.getBytes());
        return bytesToHex(bytes);
    }

    public static byte[] hmac(String algorithm, byte[] key, byte[] message) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(algorithm);
        mac.init(new SecretKeySpec(key, algorithm));
        return mac.doFinal(message);
    }

    public static String bytesToHex(byte[] bytes) {
        final char[] hexArray = "0123456789abcdef".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0, v; j < bytes.length; j++) {
            v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
        String valueToDigest = "amount=10000&buyerAddress=Tam Trinh&buyerCity=Ha Noi&buyerCountry=Viet Nam&buyerEmail=lam@gmail.com&buyerName=lam&buyerPhone=0312345678&cancelUrl=http://test/cancel&currency=VND&customMerchantId=lam123&orderCode=orderTest000&orderDescription=mo ta don hang&returnUrl=http://test/return&tokenKey=0COVspcyOZRNrsMsbHTdt8zesP9m0y&totalItem=1";
        byte[] key = "hjuEmsbcohOwgJLCmJlf7N2pPFU1Le".getBytes();

        String messageDigest = generateHmac256(valueToDigest, key);
        System.out.println(messageDigest);
    }

}
