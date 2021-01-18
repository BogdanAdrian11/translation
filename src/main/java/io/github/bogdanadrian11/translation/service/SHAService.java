package io.github.bogdanadrian11.translation.service;

import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
public class SHAService {
    public static final String SHA_256 = "SHA-256";

    public String toSHA256(String input) throws NoSuchAlgorithmException {
        return bytesToHex(MessageDigest.getInstance(SHA_256)
                .digest(input.getBytes(UTF_8)));
    }

    private String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
