/**
 * Chapter 1: 基礎運算與資料型別
 * 實作目標：練習變數宣告、基本四則運算以及 int 與 double 的轉型處理。
 */
public class BasicSalaryCalculator {
    public static void main(String[] args) {
        // 1. 定義資料 
        String employeeName = "學員 A";
        int monthlySalary = 50000;       // 月薪
        double taxRate = 0.05;           // 稅率 5%
        int bonus = 2000;                // 獎金

        // 2. 邏輯運算 
        // 計算總薪資：(月薪 + 獎金)
        int grossSalary = monthlySalary + bonus;
        
        // 計算稅額：總薪資 * 稅率 (注意：double 運算後需轉回 int 或用 double 存)
        double taxAmount = grossSalary * taxRate;
        
        // 計算實領薪資：總薪資 - 稅額
        double netSalary = grossSalary - taxAmount;

        // 3. 輸出結果
        System.out.println("員工姓名: " + employeeName);
        System.out.println("應付總額: " + grossSalary);
        System.out.println("扣繳稅額: " + taxAmount);
        System.out.println("--------------------");
        System.out.println("實領薪資: " + netSalary);
    }
}
