public class SwitchCaseDataLogic {

    public static void main(String[] args) {
        // 設定查詢參數
        int season = 2025;
        String team = "";

        // 依據賽季年度進行數據分類邏輯
        switch (season) {
            case 2023:
            case 2024:
                team = "Los Angeles Lakers";
                break;
            case 2025:
                team = "Sacramento Kings";
                break;
            default:
                team = "Unknown Team";
                break;
        }

        // 執行結果輸出
        System.out.println("Season: " + season + ", Assigned Team: " + team);

        // 進行分區屬性判定
        switch (team) {
            case "Los Angeles Lakers":
            case "Sacramento Kings":
            case "Golden State Warriors":
                System.out.println("Region: West");
                break;
            case "Celtics":
            case "Bucks":
                System.out.println("Region: East");
                break;
            default:
                System.out.println("Region: N/A");
                break;
        }
    }
}
