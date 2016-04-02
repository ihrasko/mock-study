/**
 * Computer class
 */
public class Computer {

    private String name;
    private String ipAddress;
    private String macAdress;
    private String os;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMacAdress() {
        return macAdress;
    }

    public void setMacAdress(String macAdress) {
        this.macAdress = macAdress;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Computer computer = (Computer) o;

        if (name != null ? !name.equals(computer.name) : computer.name != null) return false;
        if (ipAddress != null ? !ipAddress.equals(computer.ipAddress) : computer.ipAddress != null) return false;
        if (macAdress != null ? !macAdress.equals(computer.macAdress) : computer.macAdress != null) return false;
        return os != null ? os.equals(computer.os) : computer.os == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (ipAddress != null ? ipAddress.hashCode() : 0);
        result = 31 * result + (macAdress != null ? macAdress.hashCode() : 0);
        result = 31 * result + (os != null ? os.hashCode() : 0);
        return result;
    }
}
