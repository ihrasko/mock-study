import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Network class
 */
public class Network {

    private List<Computer> computers;

    public Network() {
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
}
