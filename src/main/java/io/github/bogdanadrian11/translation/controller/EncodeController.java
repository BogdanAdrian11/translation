package io.github.bogdanadrian11.translation.controller;

import io.github.bogdanadrian11.translation.service.BaseService;
import io.github.bogdanadrian11.translation.service.SHAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.NoSuchAlgorithmException;

@Controller
@ResponseBody
@RequestMapping("/encode")
public class EncodeController {
    private final SHAService shaService;
    private final BaseService baseService;

    @Autowired
    public EncodeController(SHAService shaService, BaseService baseService) {
        this.shaService = shaService;
        this.baseService = baseService;
    }

    @GetMapping("/toSHA256")
    public String toSHA256(@RequestParam String input) {
        try {
            return shaService.toSHA256(input);
        } catch (NoSuchAlgorithmException e) {
            throw new InternalError("Internal Issue");
        }
    }

    @GetMapping("/toBase64")
    public String toBase64(@RequestParam String input) {
        return baseService.toBase64(input);
    }
}
