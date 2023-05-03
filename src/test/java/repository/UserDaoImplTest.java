package repository;

import org.example.model.User;
import org.example.model.UserAlreadyAddedException;
import org.example.repository.impl.UserDaoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


public class UserDaoImplTest {
    public static final User EXIST_USER_OBJ = new User("User");
    public static final User UNEXIST_USER_OBJ = new User("UnUser");

    private UserDaoImpl userDaoMock;

    public UserDaoImplTest(UserDaoImpl userDaoMock) {
        this.userDaoMock = userDaoMock;
    }

    @Test
    public void shouldNotReturnUser() {

        Assertions.assertNull(userDaoMock.getUserByName("User1"));

    }

    @Test
    public void shouldReturnUser() throws UserAlreadyAddedException {

        Assertions.assertEquals(userDaoMock.getUserByName("User"), EXIST_USER_OBJ);

    }

}
