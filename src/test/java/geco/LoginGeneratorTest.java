package geco;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginGeneratorTest {

    private LoginGenerator loginGenerator;

    @Before
    public void init() {
        LoginService loginService = new LoginService(new String[] {"JROL", "BPER", "CGUR", "JDUP", "JRAL", "JRAL"});
        this.loginGenerator = new LoginGenerator(loginService);
    }

    @Test
    public void generateLoginForNomAndPrenom() throws Exception {
        assertEquals("PDUR", this.loginGenerator.generateLoginForNomAndPrenom("Durand", "Paul"));
        assertEquals("JROL1", this.loginGenerator.generateLoginForNomAndPrenom("Rolling", "Jean"));
        assertEquals("PDUR1", this.loginGenerator.generateLoginForNomAndPrenom("Dùrand", "Paul"));

        assertEquals("JROL2", this.loginGenerator.generateLoginForNomAndPrenom("Rolling", "Jean"));
        assertEquals("JROL3", this.loginGenerator.generateLoginForNomAndPrenom("Rolling", "Jean"));
        assertEquals("PDU", this.loginGenerator.generateLoginForNomAndPrenom("Du", "Paul"));
    }

}