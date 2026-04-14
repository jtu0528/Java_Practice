/**
 * Chapter 4: 陣列基礎 (Arrays)
 * 學習重點：
 * 1. 掌握陣列的宣告與初始化。
 * 2. 練習透過索引 (Index) 存取資料。
 * 3. 結合迴圈處理陣列內容（計算總和與平均）。
 */
public class Ch04_Array_PolicyPremiums {
    public static void main(String[] args) {
        // 1. 宣告並初始化陣列：儲存 5 件保單的保費金額
        int[] premiums = {12000, 35000, 8000, 22000, 15000};
        
        int totalIncome = 0;

        // 2. 使用 premiums.length 自動取得陣列長度，增加程式靈活性
        for (int i = 0; i < premiums.length; i++) {
            System.out.println("保單編號 " + (i + 1) + " 實收金額: " + premiums[i]);
            
            // 將每筆保費累加
            totalIncome += premiums[i];
        }

        // 3. 計算平均保費 (注意：為了精確度，先轉為 double 再計算)
        double averagePremium = (double) totalIncome / premiums.length;

        System.out.println("--------------------");
        System.out.println("當日總計保費收入: " + totalIncome);
        System.out.println("平均單件保費金額: " + averagePremium);
    }
}
