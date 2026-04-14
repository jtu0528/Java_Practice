/**
 * Chapter 3: 迴圈控制 (for loop)
 * 學習重點：
 * 1. 掌握 for 迴圈的語法結構 (初始化; 條件; 疊代)。
 * 2. 練習「累加器 (Accumulator)」邏輯。
 * 3. 理解自動化批次處理重複性任務的優勢。
 */
public class Ch03_Loop_YearlyTotal {
    public static void main(String[] args) {
        int monthlySalary = 50000;
        int monthlyBonus = 2000;
        int yearlyTotal = 0; // 累加器：用來儲存整年總薪資，初始值為 0

        // i 從 1 開始代表 1 月，執行到 12 月為止，每次 i + 1
        for (int i = 1; i <= 12; i++) {
            int currentMonthIncome = monthlySalary + monthlyBonus;
            
            // 累加邏輯：將當月薪資加進總額裡
            yearlyTotal += currentMonthIncome; 

            // 輸出每個月的發放紀錄
            System.out.println(i + " 月發放金額: " + currentMonthIncome);
        }

        System.out.println("--------------------");
        System.out.println("整年度總實領薪資: " + yearlyTotal);
    }
}
