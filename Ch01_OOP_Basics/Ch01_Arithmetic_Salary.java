/**
 * Chapter 1: 基礎運算與資料型別
 * 實作目標：練習變數宣告、基本四則運算以及 int 與 double 的轉型處理。
 */
/**
 * Chapter 1: 基礎運算與型別處理
 * 重點：掌握變數命名規範、型別精度選擇、以及運算的隱式轉型。
 */
public class Ch01_Arithmetic_Salary {
    public static void main(String[] args) {
        // 1. 變數宣告：命名採用小駝峰式 (camelCase)，並根據數值特性選擇正確型別 (int/double)
        String employeeName = "學員 A";
        int monthlySalary = 50000;       // 整數資料使用 int
        double taxRate = 0.05;           // 涉及小數或百分比時，需使用浮點數 double
        int bonus = 2000;

        // 2. 型別提升 (Type Promotion)：int 與 double 運算時，結果會自動提升為精度較高的 double
        int grossSalary = monthlySalary + bonus;
        
        // 此處發生隱式轉型：grossSalary (int) * taxRate (double) -> 結果為 double
        double taxAmount = grossSalary * taxRate;
        
        double netSalary = grossSalary - taxAmount;

        // 3. 字串串接：練習在輸出語句中使用 + 運算子串接字串與變數
        System.out.println("員工姓名: " + employeeName);
        System.out.println("應付總額: " + grossSalary);
        System.out.println("扣繳稅額: " + taxAmount);
        System.out.println("--------------------");
        System.out.println("實領薪資: " + netSalary);
    }
}
