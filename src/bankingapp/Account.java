package bankingapp;

public class Account {


    String customerID;
    String password;
    double tan = (int)(Math.random()*100);

    protected Account(String cID, String password, double tan) {
        this.customerID = cID; //This zeigt auf die customerID, die bei Instanziierung angegeben wird.
        this.password = password; //This zeigt auf das password, das bei Instanziierung angegeben wird.
        this.tan = tan; //zeigt auf tan

    }


    protected void customer(){
        System.out.println("Customer ID: " +this.customerID);
        System.out.println("Password: " +this.password);
        System.out.println("Generated TAN: "+this.tan);
    }
}
