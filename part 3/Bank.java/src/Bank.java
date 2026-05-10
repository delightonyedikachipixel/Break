public class BankApp {

    private Bank bank;

    public BankApp() {
        this.bank = new Bank("MyBank");
    }

    public static void main(String[] args) {
        BankApp app = new BankApp();

        try {
            Account jane = app.bank.registerCustomer("jane", "1234", "5000");
            Account jude = app.bank.registerCustomer("jude", "5678", "2000");

            int janeNum = jane.getNumber();
            int judeNum = jude.getNumber();

            app.bank.deposit(janeNum, 1000);
            System.out.println("jane balance after deposit: "
                    + app.bank.checkBalance(janeNum, "1234"));

            app.bank.withdraw(judeNum, 500, "5678");
            System.out.println("jude balance after withdrawal: "
                    + app.bank.checkBalance(judeNum, "5678"));

            app.bank.transfer(janeNum, judeNum, 200, "1234");

            System.out.println("Jane after transfer: "
                    + app.bank.checkBalance(janeNum, "1234"));

            System.out.println("Jude after transfer: "
                    + app.bank.checkBalance(judeNum, "5678"));

            app.bank.withdraw(judeNum, 99999, "5678");

        } catch (InvalidAmountException e) {
            System.out.println("Invalid amount: " + e.getMessage());
        } catch (InvalidPinException e) {
            System.out.println("Invalid PIN: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Insufficient funds: " + e.getMessage());
        }
    }
}