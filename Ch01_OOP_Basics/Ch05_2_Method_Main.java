/**
 * Chapter 5-2: 主程式執行
 * 重點：實例化物件 (Instantiation)、呼叫物件方法。
 */
public class Ch05_Method_Main {
    public static void main(String[] args) {
        // 1. 宣告並建立物件 
        Ch05_PremiumLogic logicTool = new Ch05_PremiumLogic();

        // 2. 透過物件呼叫方法
        logicTool.printWelcomeMessage();
        
        int myPremium = 80000;
        double discounted = logicTool.calculate(myPremium, 0.85);

        System.out.println("原保費: " + myPremium);
        System.out.println("折扣後金額: " + discounted);
    }
}
