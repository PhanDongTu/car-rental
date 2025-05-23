package com.project.thuexe.services;

import com.project.thuexe.dtos.UserDTO;
import com.project.thuexe.exceoptions.DataNotFoundException;
import com.project.thuexe.models.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserServices {
    User createUser(UserDTO userDTO) throws DataNotFoundException;
    String login(String username, String password);
}
