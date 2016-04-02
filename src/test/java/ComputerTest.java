import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
/**
 * Computer test class
 * Testing mock interactions
 */
public class ComputerTest {

    private Computer mockedComputer;

    @Before
    public void initTest() {
        mockedComputer = mock(Computer.class);
    }

    @Test
    public void ComputerNameTest() {
        mockedComputer.setName("Computer One");
        verify(mockedComputer).setName("Computer One");
    }

    @Test
    public void ComputerIpAddressTest() {
        mockedComputer.setIpAddress("192.168.2.1");
        verify(mockedComputer).setIpAddress("192.168.2.1");
    }

    @Test
    public void ComputerMacAdressTest() {
        mockedComputer.setMacAddress("01:23:45:67:89:ab");
        verify(mockedComputer).setMacAddress("01:23:45:67:89:ab");
    }

    @Test
    public void ComputerOsTest() {
        mockedComputer.setOs("Windows");
        verify(mockedComputer).setOs("Windows");
    }
}
