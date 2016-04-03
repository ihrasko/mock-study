import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.verification.SmartNullPointerException;

import static org.junit.Assert.*;
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

            assertTrue(Mockito.mockingDetails(spy).isMock());
            assertTrue(Mockito.mockingDetails(spy).isSpy());

            spy.removeComputer(100);
            fail("Test should fail due to IndexOutOfBoudException");
        } catch (Exception e) {
            assertTrue((e instanceof IndexOutOfBoundsException));
        }
    }

    @Test
    public void smartNullTest() {
        Computer c = mock(Network.class, Mockito.RETURNS_SMART_NULLS).removeComputer(100);

        try {
            c.getName();
        } catch (Exception e) {
            assertTrue((e instanceof SmartNullPointerException));
        }
    }
}
