public class Account {

    private String name;
    private int balance;
    private String pin;
    private int number;

    public Account(String name, int balance, String pin, int number) {
        this.name = name;
        this.balance = balance;
        this.pin = pin;
        this.number = number;
    }



    public String getName()        {
        return name;
    }
    public void   setName(String name) {
        this.name = name;
    }

    public int  getBalance()           {
        return balance;
    }
    public void setBalance(int balance){
        this.balance = balance;
    }

    public String getPin()         {
        return pin;
    }
    public void   setPin(String pin)   {
        this.pin = pin;
    }

    public int  getNumber()            {
        return number;
    }
    public void setNumber(int number)  {
        this.number = number;
    }


    public void deposit(int amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be greater than zero. Got: " + amount);
        }
        balance += amount;
    }



    public void withdraw(int amount, String pin)
            throws InvalidAmountException, InvalidPinException, InsufficientFundsException {

        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be greater than zero. Got: " + amount);
        }
        if (!this.pin.equals(pin)) {
            throw new InvalidPinException("Invalid PIN for account: " + number);
        }
        if (balance < amount) {
            throw new InsufficientFundsException(
                    "Insufficient funds. Balance: " + balance + ", Requested: " + amount);
        }
        balance -= amount;
    }


    public int checkBalance(String pin) throws InvalidPinException {
        if (!this.pin.equals(pin)) {
            throw new InvalidPinException("Invalid PIN for account: " + number);
        }
        return balance;
    }

    @Override
    public String toString() {
        return "Account{number=" + number + ", name='" + name + "', balance=" + balance + "}";
    }
}
