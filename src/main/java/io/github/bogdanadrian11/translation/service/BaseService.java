package io.github.bogdanadrian11.translation.service;

import org.springframework.stereotype.Service;

import java.util.Base64;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
public class BaseService {
    public String toBase64(String input) {
        return Base64.getEncoder()
                .encodeToString(input.getBytes(UTF_8));
    }

    public String fromBase64(String input) {
        return new String(Base64.getDecoder()
                .decode(input));
    }
}
