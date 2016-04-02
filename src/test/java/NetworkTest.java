import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
/**
 * Network test class
 * Testing stub method calls
 */
public class NetworkTest {

    private Network mockedNetwork;
    private Computer mockedComputer;

    @Before
    public void initTest() {
        mockedNetwork = mock(Network.class);
        mockedComputer = mock(Computer.class);


        when(mockedNetwork.addComputer(mockedComputer)).thenReturn(true);
        when(mockedNetwork.addComputer(null)).thenReturn(false);

        when(mockedNetwork.removeComputer(mockedComputer)).thenReturn(true);
        when(mockedNetwork.removeComputer(null)).thenReturn(false);
    }

    @Test
    public void addComputerPositiveTest() {
        assertEquals(true, mockedNetwork.addComputer(mockedComputer));
    }

    @Test
    public void addComputerNegativeTest() {
        assertEquals(false, mockedNetwork.addComputer(null));
    }

    @Test
    public void removeComputerPositiveTest() {
        assertEquals(true, mockedNetwork.removeComputer(mockedComputer));
    }

    @Test
    public void removeComputerNegativeTest() {
        assertEquals(false, mockedNetwork.removeComputer(null));
    }
}
