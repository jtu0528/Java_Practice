// 模擬銀行帳戶類別
class BankAccount {
    private String accountId;
    private int balance;

    public BankAccount(String accountId, int initialBalance) {
        this.accountId = accountId;
        this.balance = initialBalance;
    }

    // 使用 Getter 讀取資料
    public int getBalance() {
        return balance;
    }

    // 使用 Setter 修改資料，並加入簡易邏輯檢查
    public void deposit(int amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("存款成功，目前餘額: " + balance);
        }
    }
}

public class Ch13_Encapsulation_Logic {
    public static void main(String[] args) {
        BankAccount myAcc = new BankAccount("CAT-001", 1000);
        myAcc.deposit(500);
        System.out.println("最終確認餘額: " + myAcc.getBalance());
    }
}
