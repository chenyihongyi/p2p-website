package com.xmg.p2p.base.controller;

import com.xmg.p2p.base.domain.Userinfo;
import com.xmg.p2p.base.service.IRealAuthService;
import com.xmg.p2p.base.service.IUserinfoService;
import com.xmg.p2p.base.util.RequireLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 实名认证控制
 * @Author Elvis Chen
 * @Date 2019/1/4 21:30
 * @Version 1.0
 **/
@Controller
public class RealAuthController {

    @Autowired
    private IUserinfoService userinfoService;

    @Autowired
    private IRealAuthService realAuthService;

    @RequireLogin
    @RequestMapping("realAuth")
    public String realAuth(Model model) {

        Userinfo current = this.userinfoService.getCurrent();
        if (current.getIsRealAuth()) {
            model.addAttribute("realAuth", this.realAuthService.get(current.getRealAuthId()));
            model.addAttribute("auditing", false);
            return "realAuth_result";
        } else {
            if (current.getRealAuthId() != null) {
                model.addAttribute("auditing", true);
                return "realAuth_result";
            } else {
                return "realAuth";
            }
        }
    }
}
