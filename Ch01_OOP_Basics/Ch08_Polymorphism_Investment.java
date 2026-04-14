/**
 * Chapter 8: 物件導向 - 多型 (Polymorphism)
 * 學習重點：
 * 1. 向上轉型 (Upcasting)：父類別型別宣告指向子類別實例。
 * 2. 動態綁定 (Dynamic Binding)：執行時根據物件實際型別決定呼叫哪個方法。
 */

// --- 1. 父類別：通用資產 ---
class Asset {
    public void showValue() {
        System.out.println("計算基礎資產價值...");
    }
}

// --- 2. 子類別 A：股票資產 ---
class Stock extends Asset {
    @Override
    public void showValue() {
        System.out.println(">> [股票] 價值計算：參考今日收盤價與持有股數。");
    }
}

// --- 3. 子類別 B：債券資產 ---
class Bond extends Asset {
    @Override
    public void showValue() {
        System.out.println(">> [債券] 價值計算：參考票面價值與累積利息。");
    }
}

// --- 4. 主程式 ---
public class Ch08_Polymorphism_Investment {
    public static void main(String[] args) {
        // 多型的核心：用父類別(Asset)的陣列，一次管理異質資產
        Asset[] myPortfolio = new Asset[2];
        myPortfolio[0] = new Stock();
        myPortfolio[1] = new Bond();

        System.out.println("--- 萬用金融資產試算系統啟動 ---");
        
        // 統一呼叫，展現「一個介面，多種實作」
        for (Asset item : myPortfolio) {
            item.showValue(); 
        }
    }
}
