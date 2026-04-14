/**
 * Chapter 2: 條件判斷 (if-else if)
 * 學習重點：多重分支邏輯、比較運算子的使用。
 */
public class Ch02_IfElse_TaxRate {
    public static void main(String[] args) {
        int monthlySalary = 75000;
        double taxRate;
        
        if (monthlySalary <= 30000) {
            taxRate = 0.0;      
        } else if (monthlySalary <= 70000) {
            taxRate = 0.05;     
        } else {
            taxRate = 0.1;      
        }

        double taxAmount = monthlySalary * taxRate;
        System.out.println("薪資: " + monthlySalary + " | 稅率: " + (taxRate * 100) + "%");
        System.out.println("實領薪資: " + (monthlySalary - taxAmount));
    }
}
