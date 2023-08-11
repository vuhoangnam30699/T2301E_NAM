public class DeliveryOrder extends Order {
    private String address;

    public DeliveryOrder() {

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString() +
                "DeliveryOrder{" +
                "address='" + address + '\'' +
                '}';
    }
}
