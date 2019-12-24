package unitTestJava;

public class Account {

    private boolean active;
    private Address defoultDeliveryAddress;
    private String email;

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

    public void setEmail(String email) {
        if (email.matches("^[A-Za-z0-9._%+]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")){
            this.email = email;
        }else{
            throw new IllegalArgumentException("Wrong email format");
        }
    }
}
