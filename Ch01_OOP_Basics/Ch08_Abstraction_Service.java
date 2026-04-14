/**
 * Chapter 8: 物件導向 - 抽象 (Abstraction)
 * 學習重點：
 * 1. 使用 abstract 宣告抽象類別與抽象方法。
 * 2. 理解「抽象方法沒有實作」：強制子類別必須完成特定功能。
 * 3. 實作金融服務申請的標準化流程。
 */

// --- 類別 1：抽象範本類別 (FinancialService) ---
// 抽象類別不能被直接 new 出來，它只能作為父類別被繼承
abstract class FinancialService {
    protected String serviceName;

    public FinancialService(String name) {
        this.serviceName = name;
    }

    // 普通方法：所有服務共用的邏輯
    public void startService() {
        System.out.println("--- 啟動服務：" + serviceName + " ---");
    }

    // 【核心重點】抽象方法：沒有 {} 
    // 意義：規定所有金融服務「必須」定義自己的審核邏輯
    public abstract void verifyIdentity();
    public abstract void processRequest();
}

// --- 類別 2：具體實作類別 (LoanRequest) ---
class LoanRequest extends FinancialService {
    public LoanRequest() {
        super("個人貸款申請");
    }

    // 強制實作父類別規定的審核邏輯
    @Override
    public void verifyIdentity() {
        System.out.println(">> [審核] 正在查詢聯徵中心信用紀錄...");
    }

    @Override
    public void processRequest() {
        System.out.println(">> [執行] 貸款申請已送件，進入審核流程。");
    }
}

// --- 主程式執行類別 ---
public class Ch08_Abstraction_Service {
    public static void main(String[] args) {
        // 建立具體的貸款申請物件
        LoanRequest request = new LoanRequest();

        request.startService();      // 執行父類別共用邏輯
        request.verifyIdentity();    // 執行子類別實作的審核
        request.processRequest();    // 執行子類別實作的流程
    }
}
