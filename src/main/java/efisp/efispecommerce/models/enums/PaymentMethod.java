package efisp.efispecommerce.models.enums;

public enum PaymentMethod {
    CreditCard("Cartão de Crédito"),
    FetLock("Boleto Bancário"),
    Pix("Pix");

    public final String value;

    PaymentMethod(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}