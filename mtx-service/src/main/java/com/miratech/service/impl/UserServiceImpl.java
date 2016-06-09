package com.miratech.service.impl;

import com.miratech.dto.UserDTO;
import com.miratech.interfaces.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public List<UserDTO> list() {
        List<UserDTO> users = new ArrayList<>();
        users.add(new UserDTO(1, "Thomas"));
        users.add(new UserDTO(2, "Sandra"));
        users.add(new UserDTO(3, "Robert"));
        return users;
    }

    @Override
    public void add(UserDTO user) {
        System.out.println("Add new user");
    }

}
