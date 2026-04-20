// 父類別：通用保單
class Insurance {
    public void calculatePremium() {
        System.out.println("計算通用保費邏輯...");
    }
}

// 子類別：人壽保險 (覆寫父類別方法)
class LifeInsurance extends Insurance {
    @Override
    public void calculatePremium() {
        System.out.println("根據年齡與健康狀況計算人壽保費...");
    }
}

// 子類別：旅遊保險 (覆寫父類別方法)
class TravelInsurance extends Insurance {
    @Override
    public void calculatePremium() {
        System.out.println("根據旅遊天數與地區計算旅遊保費...");
    }
}

public class Ch14_Polymorphism_Logic {
    public static void main(String[] args) {
        // 使用父類別型態宣告，指向子類別物件 (多型)
        Insurance myPolicy1 = new LifeInsurance();
        Insurance myPolicy2 = new TravelInsurance();

        myPolicy1.calculatePremium();
        myPolicy2.calculatePremium();
    }
}
