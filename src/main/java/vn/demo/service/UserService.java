package vn.demo.service;

import org.springframework.stereotype.Service;
import vn.demo.exception.ResourceNotFoundException;
import vn.demo.model.User;

@Service
public class UserService {
    public int addUser(User user) {
        if(!user.getFirstName().equals("nhan")) {
            throw new ResourceNotFoundException("Nhan k ton tai");
        }
        return 0;
    }
}
