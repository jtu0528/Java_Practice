/**
 * Chapter 10: 例外處理 (Exception Handling)
 * 學習重點：
 * 1. 掌握 try-catch 結構，捕捉執行時期的錯誤。
 * 2. 理解 ArithmeticException (算術錯誤) 與一般的 Exception 處理。
 * 3. 練習使用 finally 區塊執行「無論如何都要執行」的收尾動作。
 */

// --- 類別 1：業務邏輯類別 (FinanceService) ---
class FinanceService {
    
    // 執行資金分配計算
    public void distributeFunds(int totalAmount, int peopleCount) {
        try {
            System.out.println(">> 啟動資金分配程序...");
            
            // 潛在風險：如果 peopleCount 為 0，會引發 ArithmeticException
            int result = totalAmount / peopleCount;
            
            System.out.println("分配成功！每人可得：" + result);
            
        } catch (ArithmeticException e) {
            // 攔截特定錯誤：除以 0
            System.err.println("【系統錯誤】分配人數不可為 0，請重新確認輸入。");
        } catch (Exception e) {
            // 攔截其他所有未知的錯誤
            System.err.println("【未知錯誤】發生非預期異常：" + e.getMessage());
        } finally {
            // 無論成功或失敗都會執行，通常用於關閉資源或記錄 Log
            System.out.println(">> 程序結束：已記錄本次操作日誌。");
        }
    }
}

// --- 類別 2：執行主程式 (Ch10_Exception_Handling) ---
public class Ch10_Exception_Handling {
    public static void main(String[] args) {
        FinanceService service = new FinanceService();

        System.out.println("--- 萬用金融資金管理系統 ---");

        // 測試場景 A：正常情況
        System.out.println("\n[測試 1：正常分配]");
        service.distributeFunds(10000, 5);

        // 測試場景 B：異常情況 (人數為 0)
        System.out.println("\n[測試 2：異常輸入]");
        service.distributeFunds(10000, 0); 
    }
}
