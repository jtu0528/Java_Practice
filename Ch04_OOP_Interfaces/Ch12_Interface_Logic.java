// 1. 定義金融服務介面
interface FinanceService {
    void validate(); // 驗證客戶身分
    void execute();  // 執行業務動作
}

// 2. 實作：存款業務
class DepositService implements FinanceService {
    public void validate() {
        System.out.println("驗證銀行帳戶與印鑑...");
    }
    public void execute() {
        System.out.println("存款手續完成。");
    }
}

// 3. 實作：保險理賠業務
class ClaimService implements FinanceService {
    public void validate() {
        System.out.println("審核理賠申請文件與事故證明...");
    }
    public void execute() {
        System.out.println("理賠案已進入撥款程序。");
    }
}

public class Ch12_Interface_Logic {
    public static void main(String[] args) {
        // 展示多型應用
        FinanceService task1 = new DepositService();
        FinanceService task2 = new ClaimService();

        System.out.println("--- 處理櫃檯業務 ---");
        task1.validate();
        task1.execute();

        System.out.println("\n--- 處理後台理賠 ---");
        task2.validate();
        task2.execute();
    }
}
