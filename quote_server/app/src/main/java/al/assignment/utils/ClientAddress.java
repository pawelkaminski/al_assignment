package al.assignment.utils;

public class ClientAddress {
    String port;
    String host;

    ClientAddress(String host, String port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj instanceof ClientAddress) {
            ClientAddress otherChair = (ClientAddress) obj;
            return host.equals(otherChair.host) && port.equals(otherChair.port);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 17 * host.hashCode() + 31 * port.hashCode();
    }

    public String getUrl() {
        return host + ":" + port;
    }
}
