package services;

import org.example.model.User;
import org.example.model.UserAlreadyAddedException;
import org.example.repository.impl.UserDaoImpl;
import org.example.services.impl.UserServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    public static final String USER_NAME = "User";
    public static final User EXIST_USER_OBJ = new User("User");
    public static final User UNEXIST_USER_OBJ = new User("UnUser");

    @Mock
    private UserDaoImpl userDaoMock;

    @InjectMocks
    private UserServiceImpl userService;


    @Test
    public void shouldCheckUserExist() {
       when(userDaoMock.checkUserExist(EXIST_USER_OBJ)).thenReturn(true);

       Assertions.assertEquals(userService.checkUserExist(EXIST_USER_OBJ), true);
    }

    @Test
    public void shouldCheckUserUnExist() {
        when(userDaoMock.checkUserExist(UNEXIST_USER_OBJ)).thenReturn(false);

        Assertions.assertEquals(userService.checkUserExist(UNEXIST_USER_OBJ), false);
    }



}
