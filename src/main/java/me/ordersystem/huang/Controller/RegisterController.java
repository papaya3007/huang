package me.ordersystem.huang.Controller;

import me.ordersystem.huang.pojo.Admin;
import me.ordersystem.huang.service.AdminService;
import me.ordersystem.huang.utils.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class RegisterController {

    @Resource
    private AdminService adminService;

    //注册用
    @RequestMapping(value = "/reg", method = {RequestMethod.POST})
    public String register(HttpServletRequest request, Model model) {
        String returnInfo;
        //获取数据
        String adminName = request.getParameter("Username");
        String adminCode = request.getParameter("adminCode");
        String password = request.getParameter("Password");
        System.out.println(adminName + adminCode + password);
        //对密码进行加密
        String MD5Password = MD5Util.encode(password, adminName);
        //测试用 检测是否加密成功
        System.out.println(MD5Password);

        //进行判断如果邀请码正确则可以正常注册 （不能为空什么的在页面上使用js判断
        if (adminCode.equals("adminCode")) {
            Admin admin = new Admin();
            admin.setAdminname(adminName);
            admin.setPassword(MD5Password);
            int info = adminService.register(admin);
            if (info > 0) {
                returnInfo = "恭喜你管理员账户注册成功";
                model.addAttribute("info", returnInfo);
                return "index";
            } else {
                returnInfo = "你所填信息可能有错";
                model.addAttribute("info", returnInfo);
                return "login";
            }

        } else {
            returnInfo = "邀请码都没有注册你个大爷";
            model.addAttribute("info", returnInfo);
            return "login";

        }
    }
}
