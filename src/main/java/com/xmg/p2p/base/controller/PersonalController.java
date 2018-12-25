/**
 * 
 */
package com.xmg.p2p.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xmg.p2p.base.domain.Logininfo;
import com.xmg.p2p.base.service.IAccountService;
import com.xmg.p2p.base.service.IUserinfoService;
import com.xmg.p2p.base.util.UserContext;

/**
 * @Description:个人中心 
 * @Author: chenyihong
 * @Date: 2018年12月18日
 */
@Controller
public class PersonalController {
	
	@Autowired
	private IUserinfoService userinfoService;
	
	@Autowired
	private IAccountService accountService;

	@RequestMapping("personal")
	public String personalCenter(Model model){
		Logininfo current = UserContext.getCurrent();
		model.addAttribute("userinfo", userinfoService.get(current.getId()));
		model.addAttribute("account", accountService.get(current.getId()));
		return "personal";
	}
}
