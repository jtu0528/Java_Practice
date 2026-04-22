/**
 * 練習題目 02：銀行帳戶轉帳與交易稽核系統
 * * 練習目標：
 * 1. 使用 Interface 定義帳戶標準行為。
 * 2. 實作 Exception Handling 處理轉帳餘額不足的狀況。
 * 3. 透過 ArrayList 紀錄每一筆成功與失敗的交易明細。
 */

import java.util.ArrayList;

// 1. 定義介面
interface Account {
    int getBalance();
    void transfer(int amount) throws Exception;
}

// 2. 實作帳戶類別
class PersonalAccount implements Account {
    private String owner;
    private int balance;
    private ArrayList<String> transactionLog; // 紀錄交易明細

    public PersonalAccount(String owner, int initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
        this.transactionLog = new ArrayList<>();
        transactionLog.add("開戶成功，初始金額: " + initialBalance);
    }

    // 實作取得餘額
    public int getBalance() {
        return this.balance;
    }   

    // 3. 實作轉帳邏輯（含異常處理）
    public void transfer(int amount) throws Exception {
        if (amount > balance) {
            transactionLog.add("轉帳失敗: 餘額不足 (欲轉出 " + amount + ")");
            throw new Exception("帳戶餘額不足，無法完成交易。");
        }
        
        this.balance -= amount;
        transactionLog.add("轉帳成功: 支出 " + amount + " | 目前餘額: " + this.balance);
    }

    // 顯示所有明細
    public void printLog() {
        System.out.println("=== 客戶 [" + owner + "] 交易明細清單 ===");
        for (String log : transactionLog) {
            System.out.println(log);
        }
    }
}

public class P02_BankTransferSystem {
    public static void main(String[] args) {
        PersonalAccount myAcc = new PersonalAccount("張小明", 1000);

        // 模擬轉帳流程
        try {
            System.out.println("執行轉帳: 400 元");
            myAcc.transfer(400);

            System.out.println("執行轉帳: 800 元");
            myAcc.transfer(800); // 這邊會觸發 Exception

        } catch (Exception e) {
            // 捕捉到餘額不足的錯誤
            System.out.println("系統錯誤提示: " + e.getMessage());
        } finally {
            // 無論成功或失敗都要印出明細
            System.out.println();
            myAcc.printLog();
        }
    }
}
