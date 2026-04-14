import java.util.ArrayList;

/**
 * Chapter 9: ArrayList 與 業務邏輯分離實作
 * 學習重點：
 * 1. 練習將 ArrayList 封裝在管理類別中。
 * 2. 實作 CRUD 邏輯方法：addRecord, removeRecord, getTotal。
 * 3. 強化「主程式不處理細節，只負責呼叫」的架構觀念。
 */

// --- 類別 1：資料管理邏輯 (TransactionManager) ---
class TransactionManager {
    // 封裝一個私有的動態陣列
    private ArrayList<Integer> records = new ArrayList<>();

    // 方法：新增交易
    public void addRecord(int amount) {
        records.add(amount);
        System.out.println(">> 已存入交易紀錄：" + amount);
    }

    // 方法：移除特定順序的紀錄
    public void removeRecord(int index) {
        if (index >= 0 && index < records.size()) {
            int removed = records.remove(index);
            System.out.println(">> 已移除序號 " + (index + 1) + " 的紀錄：" + removed);
        }
    }

    // 方法：計算總額並回傳
    public int getTotal() {
        int sum = 0;
        for (int amount : records) { // 使用進階 for-each 迴圈
            sum += amount;
        }
        return sum;
    }

    // 方法：取得目前的紀錄總數
    public int getCount() {
        return records.size();
    }
}

// --- 類別 2：執行主程式 (Ch09_ArrayList_Logic) ---
public class Ch09_ArrayList_Logic {
    public static void main(String[] args) {
        // 1. 建立管理員物件
        TransactionManager manager = new TransactionManager();

        System.out.println("--- 帳務動態管理系統啟動 ---");

        // 2. 透過管理員進行操作，而不是直接操作 ArrayList
        manager.addRecord(12000);
        manager.addRecord(8500);
        manager.addRecord(3200);

        System.out.println("目前紀錄筆數：" + manager.getCount());

        // 3. 模擬刪除與重新計算
        manager.removeRecord(2); // 刪除第三筆 (index 2)

        // 4. 輸出最終結果
        int total = manager.getTotal();
        System.out.println("--------------------");
        System.out.println("經結算，本日交易總額為：" + total);
    }
}
