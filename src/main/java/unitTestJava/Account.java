package unitTestJava;

public class Account {

    private boolean active;
    private Address defoultDeliveryAddress;

    public Account(){
        this.active = false;
    }

    public Account(Address defoultDeliveryAddress) {
        this.defoultDeliveryAddress = defoultDeliveryAddress;
        if(defoultDeliveryAddress != null){
            activate();
        }else {
            this.active = false;
        }
    }

    public void activate(){
        this.active = true;
    }

    public boolean isActive(){
        return this.active;
    }

    public Address getDefoultDeliveryAddress() {
        return defoultDeliveryAddress;
    }

    public void setDefoultDeliveryAddress(Address defoultDeliveryAddress) {
        this.defoultDeliveryAddress = defoultDeliveryAddress;
    }
}
