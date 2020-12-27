package pl.coderslab.charity.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.exception.UserAlreadyExistException;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;

import java.util.Arrays;


import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@DataJpaTest
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    private static final Logger log =
            LoggerFactory.getLogger(UserServiceImplTest.class);
    private UserService userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @Before
    public void setUp() {
        userService = new UserServiceImpl(userRepository, roleRepository, passwordEncoder);
    }

    @Test
    public void find_by_user_name_then_return_user(){
        //given
        User user = new User();
        user.setUserName("Michal");
        when(userService.findByUserName("Michal")).thenReturn(user);
        //when
        User result = userService.findByUserName("Michal");
        //than
        assertEquals("Michal", result.getUserName());
    }

    @Test
    public void when_save_user_then_it_is_returned_correctly() throws UserAlreadyExistException {
        //given
        User user = new User();
        user.setFirstName("Michal");
        when(userRepository.save(user)).thenReturn(user);
        //when
        User result = userService.saveUser(user);
        //than
        assertNotNull(result);
        assertEquals(user.getFirstName(), result.getFirstName());
    }

//    @Test(expected = UserAlreadyExistException.class)
//    public void when_save_the_same_user_name_then_return_exception() {
//        //given
//        User lukasz1 = new User();
//        lukasz1.setUserName("Lukasz");
//        User lukasz2 = new User();
//        lukasz2.setUserName("Lukasz");
//        when(userRepository.save(lukasz1)).thenReturn(lukasz1);
//        when(userRepository.save(lukasz2)).thenReturn(lukasz2);
//        //when
//        User result1 = userService.saveUser(lukasz1);
//        User result2 = userService.saveUser(lukasz2);
//    }

    @Test
    public void when_save_user_then_it_is_returned_correctly_with_user_role() throws UserAlreadyExistException {
        //given
        User user = new User();
        user.setUserName("Lukasz");
        Role role = new Role();
        role.setName("ROLE_USER");
        user.setRoles(Arrays.asList(role));
        when(userService.saveUser(user)).thenReturn(user);

        //when
        User result = userService.saveUser(user);

        //than
        assertNotNull(result);
        assertEquals(role.getName(), result.getRoles().get(0).getName());
    }
}