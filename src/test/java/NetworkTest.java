import com.sun.org.glassfish.gmbal.ManagedObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;
/**
 * Network test class
 * Testing stub method calls
 */
public class NetworkTest {

    @Mock
    private Network mockedNetwork;

    @Before
    public void initTest() {
        MockitoAnnotations.initMocks(this);

        when(mockedNetwork.addComputer(any(Computer.class))).thenReturn(true);
        when(mockedNetwork.addComputer(null)).thenReturn(false, true);

        when(mockedNetwork.removeComputer(any(Computer.class))).thenReturn(true);
        when(mockedNetwork.removeComputer(null)).thenThrow(new NullPointerException());
    }

    @Test
    public void addComputerPositiveTest() {
        assertEquals(true, mockedNetwork.addComputer(mock(Computer.class)));
    }

    @Test
    public void addComputerNegativeTest() {
        assertEquals(false, mockedNetwork.addComputer(null));
    }

    @Test
    public void addComputerConsecutiveCall() {
        assertEquals(false, mockedNetwork.addComputer(null));
        assertEquals(true, mockedNetwork.addComputer(null));
    }

    @Test
    public void removeComputerPositiveTest() {
        assertEquals(true, mockedNetwork.removeComputer(mock(Computer.class)));
    }

    @Test
    public void removeComputerNegativeTest() {
        try {
            mockedNetwork.removeComputer(null);
            fail("Test should fail due to NullPointerException");
        } catch (Exception e) {
            assertTrue((e instanceof NullPointerException));
        }
    }

    @Test
    public void spyingOnRealObjects() {
        // here every method is default stubbed
        assertEquals(null, mockedNetwork.removeComputer(100));

        // here real methods are called
        try {
            Network spy = spy(new Network());
            spy.removeComputer(100);
            fail("Test should fail due to IndexOutOfBoudException");
        } catch (Exception e) {
            assertTrue((e instanceof IndexOutOfBoundsException));
        }
    }
}
