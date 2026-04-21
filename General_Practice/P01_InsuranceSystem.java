/**
 * 練習題目 01：金融保單整合管理系統
 * * 練習目標：
 * 1. 結合 HashMap 與 ArrayList 處理一對多的資料關聯。
 * 2. 實作資料封裝 (Encapsulation)，保護保單與客戶隱私。
 * 3. 模擬透過身分證號快速檢索客戶，並管理其名下多張保單。
 * * 業務邏輯：
 * - 每個保單有險種名稱與金額。
 * - 每個客戶可以擁有多張保單。
 * - 系統需支援新增客戶、為指定客戶新增保單、顯示所有保戶現況。
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// 1. 定義保單類別 
class Policy {
    private String policyName;
    private int premium;

    public Policy(String name, int premium) {
        this.policyName = name;
        this.premium = premium;
    }

    public String getInfo() {
        return "險種: " + policyName + " | 保費: " + premium;
    }
}

// 2. 定義客戶類別 (練習將 ArrayList 放入物件中)
class Customer {
    private String name;
    private ArrayList<Policy> myPolicies;

    public Customer(String name) {
        this.name = name;
        this.myPolicies = new ArrayList<>();
    }

    public void addPolicy(Policy p) {
        myPolicies.add(p);
    }

    public void showAllPolicies() {
        System.out.println("客戶姓名: " + name);
        if (myPolicies.isEmpty()) {
            System.out.println(" - 目前無投保紀錄");
        } else {
            for (Policy p : myPolicies) {
                System.out.println(" - " + p.getInfo());
            }
        }
    }
}

public class P01_InsuranceSystem {
    public static void main(String[] args) {
        // 3. 使用 HashMap 管理所有客戶 (Key: 身分證號, Value: 客戶物件)
        HashMap<String, Customer> database = new HashMap<>();

        // 新增客戶資料
        database.put("A123456789", new Customer("張小明"));
        database.put("B987654321", new Customer("李曉華"));

        // 4. 模擬業務邏輯：為特定客戶新增保單
        Customer target = database.get("A123456789");
        if (target != null) {
            target.addPolicy(new Policy("終身壽險", 5000));
            target.addPolicy(new Policy("意外傷害險", 1200));
        }

        // 5. 顯示所有客戶的投保狀況
        System.out.println("=== 國泰人壽系統資料查詢 ===");
        for (String id : database.keySet()) {
            System.out.println("身分證號: " + id);
            database.get(id).showAllPolicies();
            System.out.println("----------------------------");
        }
    }
}
