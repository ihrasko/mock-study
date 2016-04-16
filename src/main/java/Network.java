import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Network class
 */
public class Network {

    private static Logger logger = LoggerFactory.getLogger(Network.class);

    private List<Computer> computers;

    public Network() {
        logger.info("Creating Network");

        if (this.computers == null) {
            this.computers = new ArrayList<Computer>();
        }
    }

    public boolean addComputer(Computer computer) {
        return computers.add(computer);
    }

    public boolean removeComputer(Computer computer) {
        return computers.remove(computer);
    }

    public Computer removeComputer(int index) {
        return computers.remove(index);
    }
}
