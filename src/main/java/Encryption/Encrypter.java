package Encryption;

import java.io.File;

public class Encrypter {

    public static void decrypt (String encryptedFile, String decryptedFile, String key){
        File encFile = new File(encryptedFile);
        File decFile = new File(decryptedFile);

        try {
            CryptoUtils.decrypt(key, encFile, decFile);
        } catch (CryptoException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getMessage());
        }

    }
    public static void encrypt (String inputFile, String encryptedFile, String key){
        File inFile = new File(inputFile);
        File encFile = new File(encryptedFile);

        try {
            CryptoUtils.encrypt(key, inFile, encFile);
        } catch (CryptoException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getMessage());
        }
    }
}
