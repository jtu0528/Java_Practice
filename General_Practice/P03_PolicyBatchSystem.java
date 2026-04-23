/**
 * 練習題目 03：保單批次核保與異常控管系統
 * * 練習重點：
 * 1. 使用 for-each 進行批次資料處理 (取代傳統 for 迴圈)。
 * 2. 實作帶有驗證邏輯的 Setter，展現資料封裝的安全性。
 * 3. 透過 try-catch-finally 確保系統在處理髒數據時不會崩潰，並保證執行收尾動作。
 */

import java.util.ArrayList;

class InsurancePolicy {
    private String name;
    private int amount;

    public InsurancePolicy(String name, int amount) {
        this.name = name;
        // 這裡我們直接呼叫 setter，確保連建構時都要經過檢查
        setAmount(amount);
    }

    public String getName() { return name; }
    public int getAmount() { return amount; }

    public void setAmount(int amount) {
        if (amount < 0) {
            // 如果金額不對，我們可以選擇拋出異常或設為 0
            this.amount = 0; 
        } else {
            this.amount = amount;
        }
    }
}

public class P03_PolicyBatchSystem {
    public static void main(String[] args) {
        ArrayList<InsurancePolicy> list = new ArrayList<>();
        list.add(new InsurancePolicy("醫療險", 5000));
        list.add(new InsurancePolicy("意外險", -100)); // 髒數據
        list.add(new InsurancePolicy("壽險", 12000));

        System.out.println("=== 開始批次核保作業 ===");

        // 使用 for-each 迴圈
        for (InsurancePolicy policy : list) {
            try {
                System.out.println("正在審核: " + policy.getName());
                
                // 模擬業務邏輯：如果金額為 0，視為異常資料
                if (policy.getAmount() == 0) {
                    throw new Exception("警告：保單 [" + policy.getName() + "] 金額異常，請人工確認！");
                }
                
                System.out.println(">> 核保成功，金額為: " + policy.getAmount());

            } catch (Exception e) {
                System.out.println(">> 錯誤: " + e.getMessage());
            } finally {
                // 無論核保成功還是抓到錯誤，都要印出分隔線
                System.out.println("-----------------------");
            }
        }
        
        System.out.println("所有保單處理程序結束。");
    }
}
