import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {
        String message = "Hello Bob, this is Alice.";
        String replyMessage = "Hello Alice, this is Bob.";

        System.out.println("===Symmetric Encrypt/Decrypt===");

        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        SecretKey key = keyGenerator.generateKey();
        byte[] iv = new byte[12];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(iv);

        System.out.println("Symmetric encrypt input: " + message);
        byte[] symmetricEncryptedMessage = symmetricEncrypt(message, key, iv);
        System.out.println("Symmetric encrypt output: " + Base64.getEncoder().encodeToString(symmetricEncryptedMessage));
        String symmetricDecryptedMessage = symmetricDecrypt(symmetricEncryptedMessage, key, iv);
        System.out.println("Symmetric decrypt input: " + symmetricDecryptedMessage);

        System.out.println();
        System.out.println("===Asymmetric Encrypt/Decrypt===");

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPairAlice = keyPairGenerator.generateKeyPair();
        PublicKey publicKeyAlice = keyPairAlice.getPublic();
        PrivateKey privateKeyAlice = keyPairAlice.getPrivate();
        KeyPair keyPairBob = keyPairGenerator.generateKeyPair();
        PublicKey publicKeyBob = keyPairBob.getPublic();
        PrivateKey privateKeyBob = keyPairBob.getPrivate();

        System.out.println("Message from Alice to Bob.");
        System.out.println("Asymmetric encrypt input: " + message);
        byte[] asymmetricEncryptedMessage = asymmetricEncrypt(message, publicKeyAlice);
        System.out.println("Asymmetric encrypt output: " + Base64.getEncoder().encodeToString(asymmetricEncryptedMessage));
        String asymmetricDecryptedMessage = asymmetricDecrypt(asymmetricEncryptedMessage, privateKeyAlice);
        System.out.println("Asymmetric decrypt output: " + asymmetricDecryptedMessage);

        System.out.println("Message from Bob to Alice.");
        System.out.println("Asymmetric encrypt input: " + replyMessage);
        byte[] asymmetricEncryptedReplyMessage = asymmetricEncrypt(replyMessage, publicKeyBob);
        System.out.println("Asymmetric encrypt output: " + Base64.getEncoder().encodeToString(asymmetricEncryptedReplyMessage));
        String asymmetricDecryptedReplyMessage = asymmetricDecrypt(asymmetricEncryptedReplyMessage, privateKeyBob);
        System.out.println("Asymmetric decrypt output: " + asymmetricDecryptedReplyMessage);

        System.out.println();
        System.out.println("===Signing and Verify===");
        System.out.println("Message to sign: " + message);
        byte[] signature = sign(message, privateKeyAlice);
        System.out.println("Signature: " + Base64.getEncoder().encodeToString(signature));
        boolean signatureVerified = verify(message, signature, publicKeyAlice);
        System.out.println("Signature verified: " + signatureVerified);

        System.out.println("Message to sign: " + replyMessage);
        byte[] signature2 = sign(replyMessage, privateKeyBob);
        System.out.println("Signature: " + Base64.getEncoder().encodeToString(signature2));
        boolean signatureVerified2 = verify(replyMessage, signature2, publicKeyBob);
        System.out.println("Signature verified: " + signatureVerified2);
    }

    static byte[] symmetricEncrypt(String input, SecretKey key, byte[] iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        SecretKeySpec secretKey = new SecretKeySpec(key.getEncoded(), "AES");
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(128, iv);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, gcmParameterSpec);
        return cipher.doFinal(input.getBytes());
    }

    static String symmetricDecrypt(byte[] input, SecretKey key, byte[] iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        SecretKeySpec secretKey = new SecretKeySpec(key.getEncoded(), "AES");
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(128, iv);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, gcmParameterSpec);
        byte[] plainText = cipher.doFinal(input);
        return new String(plainText);
    }

    static byte[] asymmetricEncrypt(String input, PublicKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(input.getBytes());
    }

    static String asymmetricDecrypt(byte[] input, PrivateKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] plainText = cipher.doFinal(input);
        return new String(plainText);
    }

    static byte[] sign(String message, PrivateKey privateKey) throws Exception {
        Signature privateSignature = Signature.getInstance("SHA256withRSA");
        privateSignature.initSign(privateKey);
        privateSignature.update(message.getBytes());
        return privateSignature.sign();
    }

    static boolean verify(String message, byte[] signature, PublicKey publicKey) throws Exception {
        Signature publicSignature = Signature.getInstance("SHA256withRSA");
        publicSignature.initVerify(publicKey);
        publicSignature.update(message.getBytes());
        return publicSignature.verify(signature);
    }

}