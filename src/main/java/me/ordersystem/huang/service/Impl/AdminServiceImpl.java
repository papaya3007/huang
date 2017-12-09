package me.ordersystem.huang.service.Impl;

import me.ordersystem.huang.dao.AdminMapper;
import me.ordersystem.huang.pojo.Admin;
import me.ordersystem.huang.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    @Override
    public int register(Admin admin) {
        return this.adminMapper.insert(admin);
    }

    @Override
    public Admin login(String name, String password) {
        return this.adminMapper.login(name, password);
    }
}
