package io.github.bogdanadrian11.translation.controller;

import io.github.bogdanadrian11.translation.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/decode")
public class DecodeController {
    private final BaseService baseService;

    @Autowired
    public DecodeController(BaseService baseService) {
        this.baseService = baseService;
    }

    @GetMapping("/fromBase64")
    public String toBase64(@RequestParam String input) {
        return baseService.fromBase64(input);
    }
}
