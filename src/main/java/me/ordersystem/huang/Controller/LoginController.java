package me.ordersystem.huang.Controller;

import me.ordersystem.huang.pojo.Admin;
import me.ordersystem.huang.service.AdminService;
import me.ordersystem.huang.utils.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.security.provider.MD5;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Resource
    private AdminService adminService;

    //用于跳转到登陆页面
    @RequestMapping(value = "/loginAdmin")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //登陆时密码需要进行md5加密一下然后与数据库里的进行比对
        String md5password = MD5Util.encode(password, username);
        Admin admin = adminService.login(username, md5password);
        if (admin.getAdminname() != null) {
            return "index";
        } else {
            return "login";
        }


    }
}
