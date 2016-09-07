

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class UserTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class UserTest
{
    private User vasea;
    private User greg;
    private User ion;
    private User nicu;

    
    
    

    /**
     * Default constructor for test class UserTest
     */
    public UserTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        vasea = new User("Vasea");
        greg = new User("Greg");
        ion = new User("Ion");
        nicu = new User("Nicu");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void displayFriends()
    {
        vasea.displayFriends(Status.OFFLINE);
    }
}

