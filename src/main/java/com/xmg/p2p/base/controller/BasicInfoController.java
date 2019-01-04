package com.xmg.p2p.base.controller;

import com.xmg.p2p.base.domain.Userinfo;
import com.xmg.p2p.base.service.ISystemDictionaryService;
import com.xmg.p2p.base.service.IUserinfoService;
import com.xmg.p2p.base.util.JSONResult;
import com.xmg.p2p.base.util.RequireLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户个人资料填写
 * @Author Elvis Chen
 * @Date 2019/1/1 21:15
 * @Version 1.0
 **/
@Controller
public class BasicInfoController {

    @Autowired
    private IUserinfoService userinfoService;

    @Autowired
    private ISystemDictionaryService systemDictionaryService;

    @RequireLogin
    @RequestMapping("basicInfo")
    public String basicInfo(Model model) {
        model.addAttribute("userinfo", this.userinfoService.getCurrent());
        model.addAttribute("educationBackgrounds", this.systemDictionaryService.listByParentSn("educationBackground"));
        model.addAttribute("incomeGrades", this.systemDictionaryService.listByParentSn("incomeGrade"));
        model.addAttribute("marriages", this.systemDictionaryService.listByParentSn("marriage"));
        model.addAttribute("kidCounts", this.systemDictionaryService.listByParentSn("kidCount"));
        model.addAttribute("houseConditions", this.systemDictionaryService.listByParentSn("houseCondition"));
        return "userInfo";
    }

    @RequireLogin
    @RequestMapping("basicInfo_save")
    @ResponseBody
    public JSONResult basicInfoSave(Userinfo userinfo){
        this.userinfoService.updateBasicInfo(userinfo);
        return new JSONResult();
    }
}