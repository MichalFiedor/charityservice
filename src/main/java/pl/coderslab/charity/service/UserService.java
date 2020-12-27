package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.exception.UserAlreadyExistException;

public interface UserService {

    User findByUserName(String userName);

    User saveUser(User user) throws UserAlreadyExistException;

}
