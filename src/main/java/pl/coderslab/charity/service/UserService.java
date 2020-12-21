package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.exception.UserAlreadyExistException;

public interface UserService {

    User findByUserName(String userName);

    void saveUser(User user) throws UserAlreadyExistException;

}
