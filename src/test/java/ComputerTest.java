import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
/**
 * Computer test class
 * Testing mock interactions
 */
public class ComputerTest {

    @Mock
    private Computer mockedComputer;

    @Before
    public void initMOcks() {
        MockitoAnnotations.initMocks(this);
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
        mockedComputer.setOs("Linux");

        verify(mockedComputer).setOs("Linux");
    }

    @Test
    public void verifyNumberOfInvocations() {
        mockedComputer.setOs("Windows");
        mockedComputer.setOs("Linux");

        verify(mockedComputer, times(1)).setOs("Windows");
        verify(mockedComputer, times(1)).setOs("Linux");

        verify(mockedComputer, atLeast(2)).setOs(anyString());
        verify(mockedComputer, atMost(2)).setOs(anyString());
    }

    @Test
    public void verifyOrderOfInvocations() {
        mockedComputer.setOs("Windows");
        mockedComputer.setOs("Linux");

        InOrder inOrder = inOrder(mockedComputer);

        inOrder.verify(mockedComputer).setOs("Windows");
        inOrder.verify(mockedComputer).setOs("Linux");
    }
}
