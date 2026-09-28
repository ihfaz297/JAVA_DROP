class Account {
  private String name;
  private int accountNo;
  private String address;
  private String accType;
  private double curBalance;

  public Account(String name, int accountNo, double initialAmount) {
    this.name = name;
    this.accountNo = accountNo;
    this.curBalance = initialAmount;
  }

  public Account(String name, int accountNo, String address, String accType, double curBalance) {
    this.name = name;
    this.accountNo = accountNo;
    this.address = address;
    this.accType = accType;
    this.curBalance = curBalance;
  }
  public void deposit(int amount) {
    curBalance += amount;
  }
  public void withdraw(int amount) {
    curBalance -= amount;
  }
  public double getBalance() {
    return curBalance;
  }
}

class J14_1B {
  public static void main(String[] args) {
    Account a = new Account("Bipul", 2020331093, 500); 
    System.out.println(a.getBalance());
  }
}
