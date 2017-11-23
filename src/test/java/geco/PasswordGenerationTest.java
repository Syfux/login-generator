package geco;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordGenerationTest {

    private PasswordGeneration pwdGen = new PasswordGeneration();

    @Test
    public void getRandomPassword() throws Exception {
        String gen1 = this.pwdGen.getRandomPassword();
        String gen2 = this.pwdGen.getRandomPassword();
        assertFalse(gen1.equals(gen2));
        assertEquals(8, gen1.length());
    }

}