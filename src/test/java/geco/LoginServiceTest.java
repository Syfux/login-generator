package geco;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LoginServiceTest {

    private LoginService loginService;

    @Before
    public void init() {
        String[] login = {"login"};
        loginService = new LoginService(login);
    }

    @Test
    public void loginExists() throws Exception {
        assertFalse(this.loginService.loginExists("noLogin"));
        assertTrue(this.loginService.loginExists("login"));
    }

    @Test
    public void addLogin() throws Exception {
        String login = "newLogin";
        assertFalse(this.loginService.loginExists(login));
        this.loginService.addLogin(login);
        assertTrue(this.loginService.loginExists(login));
    }

    @Test
    public void findAllLoginsStartingWith() throws Exception {
        this.loginService.addLogin("login2");
        List<String> test = this.loginService.findAllLoginsStartingWith("l");
        assertEquals("login", test.get(0));
        assertEquals("login2", test.get(1));
        test = this.loginService.findAllLoginsStartingWith("i");
        assertEquals(0, test.size());
    }

    @Test
    public void findAllLogins() throws Exception {
        List<String> test = this.loginService.findAllLogins();
        assertEquals(1, test.size());
        this.loginService.addLogin("login2");
        test = this.loginService.findAllLogins();
        assertEquals(2, test.size());
    }

}