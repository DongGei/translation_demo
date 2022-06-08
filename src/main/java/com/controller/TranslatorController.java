package com.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.pojo.ResponseResult;
import com.translationUtils.Translator;

/**
 * @className: TranslatorController
 * @description: TODO 类描述
 * @author: Dong
 * @date: 2022/6/8
 **/
@RestController
public class TranslatorController {
    @Autowired
    Translator translator;
    @GetMapping("/translate")
    public ResponseResult translate(@RequestParam("form")String form, @RequestParam("to")String to, @RequestParam("type")Integer type,
                                    @RequestParam("content")String content) {

        String s = translator.Translate(content, form, to, type);

        JSONObject json = new JSONObject();
        json.put("targetText", s);
        return s ==null ? new ResponseResult(202,"不支持"):new ResponseResult(200,json);
    }

}
