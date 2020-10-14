package sample;

import java.io.Serializable;

public class PaymentRecipe implements Serializable {
    private String name;
    private String creditCardNr;
    private String validation;

    public PaymentRecipe(String name, String creditCardNr, String validation) {
        this.name = name;
        this.creditCardNr = creditCardNr;
        this.validation = validation;
    }
    public static void createPaymentRecipe(String s1, String s2, String s3)    {
        PaymentRecipe paymentRecipe = new PaymentRecipe(s1, s2, s3);
        Controller.payments.put(Controller.currentID, paymentRecipe);
        Save.writePayments(Controller.payments);
        System.out.println("Payments has been updated");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreditCardNr() {
        return creditCardNr;
    }

    public void setCreditCardNr(String creditCardNr) {
        this.creditCardNr = creditCardNr;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

}
