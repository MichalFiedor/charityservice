package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.Role;

public interface RoleService {

    Role findRoleByName(String name);
}
