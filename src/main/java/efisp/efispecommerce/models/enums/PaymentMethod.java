package efisp.efispecommerce.models.enums;

public enum PaymentMethod {
    CreditCard("Credit Card"),
    FetLock("Fet Lock"),
    Pix("Pix");

    public final String value;

    PaymentMethod(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}