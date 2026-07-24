import java.util.*;

class Account{
    private double balance;
    private String name;
    static double interest;

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(balance, account.balance) == 0 && Objects.equals(name, account.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, name);
    }

    public void setBalance(double Balance){
        this.balance = Balance;
    }

    public void setName(String Name){
        this.name = Name;
    }

    public Account(String Name,double Balance){
        this.balance = Balance;
        this.name = Name;
    }

    public String getName(){
        return name;
    }

    public double getBalance(){
        return balance;
    }

    public void addInterest(){
    }
}

class SavingsAccount extends Account{
    public SavingsAccount(String name, double balance){
        super(name, balance);
    }
    @Override
    public void addInterest(){
        setBalance(getBalance()*1.08);
    }
}

class CreditCard extends Account{
    public CreditCard(String name, double balance){
        super(name, balance);
    }
    @Override
    public void addInterest(){
        setBalance(getBalance()*1.21);
    }
}

class TestInheritance{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
       // Account[] arr = new Account[3];
       // for(int i=0;i<3;i++){
       //     System.out.println("Enter the balance for person "+ (i+1));
       //     double bal = sc.nextDouble();
       //     System.out.println("Enter the Name of person "+ (i+1));
      //      String nam = sc.next();
       //     arr[i] = new Account(nam, bal);
       // }
        //acc.setBalance(5000);
        // acc.setName("Supe");
       // for(int i=0;i<3;i++) {
       //     System.out.print("The name of person "+ i + " is " + arr[i].getName());
       //     System.out.println(" and his balance is " + arr[i].getBalance());
       // }

        Account acc = new Account("Suppu", 1000);
        SavingsAccount acc1 = new SavingsAccount("Tuppu", 2000);
        CreditCard acc2 = new CreditCard("Muppu", 3000);

        List<Account> accounts = new ArrayList<>();

        accounts.add(acc);
        accounts.add(acc1);
        accounts.add(acc2);

        for(int i=0; i<accounts.size(); i++){
            accounts.get(i).addInterest();
            double j = accounts.get(i).getBalance();
            System.out.println("The final balance amount for person " + accounts.get(i).getName() + " is: " + j);
        }
    }
}