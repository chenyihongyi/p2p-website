package com.xmg.p2p.base.controller;

import com.xmg.p2p.base.domain.Logininfo;
import com.xmg.p2p.base.service.IAccountService;
import com.xmg.p2p.base.service.IUserinfoService;
import com.xmg.p2p.base.util.BidConst;
import com.xmg.p2p.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Elvis Chen
 * @Date 2018/12/29 12:26
 * @Version 1.0
 **/
@Controller
public class BorrowController {

    @Autowired
    private IAccountService accountService;
    
    @Autowired
    private IUserinfoService userinfoService;

    @RequestMapping("borrow")
    public String borrowIndex(Model model) {
        Logininfo current = UserContext.getCurrent();
        if(current == null){
            return "redirect:borrow.html";
        } else {
            model.addAttribute("account", this.accountService.getCurrent());
            model.addAttribute("userinfo", this.userinfoService.getCurrent());
            model.addAttribute("creditBorrowScore", BidConst.BASE_BORROW_SCORE);
            return "borrow";
        }
    }
}
