import java.util.ArrayList;
import java.util.List;

public class P05_PolicyLogic {

    public static void main(String[] args) {
        // 模擬執行：查詢 2018 年投保「醫療險」可以理賠的項目
        String searchCategory = "Medical";
        int searchYear = 2018;

        System.out.println("查詢類別：" + searchCategory + " | 投保年份：" + searchYear);
        
        // 呼叫邏輯方法
        List<String> results = getEligibleClaims(searchCategory, searchYear);

        System.out.println("=== 可申請理賠項目 ===");
        if (results.isEmpty()) {
            System.out.println("查無符合條件的理賠項目。");
        } else {
            for (String item : results) {
                System.out.println("・ " + item);
            }
        }
    }


    public static List<String> getEligibleClaims(String category, int year) {

        List<String> claims = new ArrayList<>();

        // 使用 switch 進行分類
        switch (category.toLowerCase()) {
            case "medical": // 醫療險邏輯
                if (year >= 2010 && year <= 2015) {
                    claims.add("住院日額給付 (舊制)");
                    claims.add("手術慰問金");
                } else if (year >= 2016 && year <= 2024) {
                    claims.add("實支實付醫療險 (新制)");
                    claims.add("居家療養金");
                }
                break;

            case "accident": // 意外險邏輯
                if (year >= 2000) {
                    claims.add("意外受傷門診理賠");
                    claims.add("骨折專案津貼");
                }
                break;

            case "life": // 壽險邏輯
                if (year <= 2005) {
                    claims.add("滿期祝壽金 (高利率時代保單)");
                } else {
                    claims.add("身故保險金");
                }
                break;

            default:
                System.out.println("警告：未知險種");
                break;
        }

        return claims;
    }
}
