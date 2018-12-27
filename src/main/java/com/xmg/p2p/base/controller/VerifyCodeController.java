package com.xmg.p2p.base.controller;


import com.xmg.p2p.base.service.IVerifyCodeService;
import com.xmg.p2p.base.util.JSONResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author Elvis Chen
 * @Date 2018/12/27 16:01
 * @Version 1.0
 **/
@Controller
public class VerifyCodeController {

    @Autowired
    private IVerifyCodeService verifyCodeService;

    @RequestMapping("sendVerifyCode")
    @ResponseBody
    public JSONResult sendVerifyCode(String phoneNumber) {
        JSONResult json = new JSONResult();
        try{
        verifyCodeService.sendVerifyCode(phoneNumber);
        } catch (RuntimeException re) {
            json.setMsg(re.getMessage());
            json.setSuccess(false);
        }
        return json;
    }
}
