package me.ordersystem.huang.service;


import me.ordersystem.huang.pojo.Admin;

public interface AdminService {
    int register(Admin admin);

    Admin login(String name, String password);
}
