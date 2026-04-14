/**
 * Chapter 5-1: 功能類別封裝
 * 重點：定義實例方法 (Instance Method)，將業務邏輯從主程式抽離。
 */
public class Ch05_PremiumLogic {

    // 宣告一個「非靜態 (Non-static)」方法
    // 這樣在主程式中就必須透過「new」出物件後才能呼叫，這是 OOP 的核心
    public double calculate(int basePremium, double rate) {
        return basePremium * rate;
    }

    public void printWelcomeMessage() {
        System.out.println("--- 國泰壽險保費試算系統 ---");
    }
}
