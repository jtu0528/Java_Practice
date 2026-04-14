/**
 * Chapter 7: 物件導向 - 繼承 (Inheritance)
 * 學習重點：
 * 1. 使用 extends 關鍵字實現繼承。
 * 2. 理解 super() 的用法：呼叫父類別的建構子。
 * 3. 練習 方法重寫 (Method Overriding)：子類別定義自己的行為。
 */

// --- 1. 父類別：通用保單 ---
class BasePolicy {
    protected String policyID; // protected 讓子類別可以直接存取
    protected int basePremium;

    public BasePolicy(String id, int premium) {
        this.policyID = id;
        this.basePremium = premium;
    }

    public void displayInfo() {
        System.out.println("保單編號: " + policyID + " | 基本保費: " + basePremium);
    }
}

// --- 2. 子類別：壽險 (繼承自通用保單) ---
class LifeInsurance extends BasePolicy {
    private String beneficiary; // 壽險特有的：受益人

    public LifeInsurance(String id, int premium, String beneficiary) {
        // 使用 super 呼叫父類別的建構子，處理共有的欄位
        super(id, premium);
        this.beneficiary = beneficiary;
    }

    // 方法重寫 (Overriding)：增加壽險專屬的資訊呈現
    @Override
    public void displayInfo() {
        super.displayInfo(); // 先執行父類別原有的功能
        System.out.println(">> 險種特點：壽險 | 指定受益人: " + beneficiary);
    }
}

// --- 3. 主程式 ---
public class Ch07_Inheritance_Insurance {
    public static void main(String[] args) {
        // 建立一個子類別物件
        LifeInsurance myPolicy = new LifeInsurance("L-9527", 30000, "王小明");
        
        // 呼叫方法，會執行子類別重寫後的版本
        myPolicy.displayInfo();
    }
}
