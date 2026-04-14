/**
 * Chapter 6: 物件導向 - 封裝 (Encapsulation)
 * 學習重點：
 * 1. 使用 private 修飾詞隱藏敏感資料。
 * 2. 透過 Getter / Setter 方法控制資料存取。
 * 3. 在 Setter 中加入「邏輯檢查」，防止非法資料（例如年齡為負數）進入系統。
 * 4. 練習使用 Constructor (建構子) 初始化物件。
 */

class InsuranceAccount {
    // 1. 私有變數 (Private fields)：外部無法直接修改
    private String holderName;
    private int age;
    private int premium;

    // 2. 建構子 (Constructor)：在 new 的那一刻初始化資料
    public InsuranceAccount(String name, int age, int premium) {
        this.holderName = name;
        setAge(age);      // 呼叫 Setter 來確保資料正確
        setPremium(premium);
    }

    // 3. Getter 與 Setter：對外的唯一窗口
    public void setAge(int age) {
        if (age > 0 && age < 150) { // 邏輯檢查：保險業對年齡有嚴謹限制
            this.age = age;
        } else {
            System.out.println(">> 系統警告：無效的年齡輸入！");
        }
    }

    public int getAge() {
        return this.age;
    }

    public void setPremium(int premium) {
        if (premium >= 0) {
            this.premium = premium;
        }
    }

    public int getPremium() {
        return this.premium;
    }

    public String getName() {
        return this.holderName;
    }
}

public class Ch06_Encapsulation_Policy {
    public static void main(String[] args) {
        // 建立保戶物件
        InsuranceAccount p1 = new InsuranceAccount("學員 A", 25, 15000);

        // 嘗試非法修改：因為是 private，下面這行會編譯失敗
        // p1.age = -10; 

        // 必須透過合法管道修改
        p1.setAge(-5); // 這會觸發我們寫在 Setter 裡的警告邏輯
        
        System.out.println("保戶姓名：" + p1.getName());
        System.out.println("保戶年齡：" + p1.getAge());
        System.out.println("目前保費：" + p1.getPremium());
    }
}
