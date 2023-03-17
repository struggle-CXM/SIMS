package com.SIMS.service;

import com.SIMS.entity.Admin;

public interface AdminService {
    Admin AdminLogin(Admin a);

    int ChangePassword(Admin a);
}
