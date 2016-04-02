import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;
/**
 * Computer test class
 * Testing mock interactions
 */
public class ComputerTest {

    @Mock
    private Computer mockedComputer;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);

        // callback test
        when(mockedComputer.reboot(anyLong())).thenAnswer(new Answer() {
            public Object answer(InvocationOnMock invocation) {
                Object[] args = invocation.getArguments();
                Object mock = invocation.getMock();
                return "Reboot planned in: " + args[0] + " millis";
            }
        });

        // throw exception on void method when arg is null
        doThrow(new NullPointerException()).when(mockedComputer).setName(null);
    }

    @Test
    public void callBackTest() {
        assertTrue("Reboot planned in: 2000 millis".equals(mockedComputer.reboot(2000)));
    }

    @Test
    public void voidMethodExceptionTest() {
        try {
            mockedComputer.setName(null);
            fail("Test should fail due to NullPointerException");
        } catch (Exception e) {
            assertTrue((e instanceof  NullPointerException));
        }
    }

    @Test
    public void ComputerNameTest() {
        mockedComputer.setName("Computer One");
        verify(mockedComputer).setName("Computer One");
    }

    @Test
    public void verifyInvocationNeverHappen() {
        mockedComputer.setName(anyString());
        verify(mockedComputer, never()).setName(null);
    }

    @Test
    public void ComputerIpAddressTest() {
        mockedComputer.setIpAddress("192.168.2.1");
        verify(mockedComputer).setIpAddress("192.168.2.1");
    }

    @Test
    public void ComputerMacAddressTest() {
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
