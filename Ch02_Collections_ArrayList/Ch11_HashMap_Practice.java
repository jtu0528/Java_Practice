import java.util.HashMap;

public class Ch11_HashMap_Practice {
    public static void main(String[] args) {
        // 1. 建立 HashMap (Key: 球員名稱, Value: 效力球隊)
        HashMap<String, String> playerMap = new HashMap<>();

        // 2. 新增數據
        playerMap.put("LeBron James", "Lakers");
        playerMap.put("Stephen Curry", "Warriors");
        playerMap.put("Kevin Durant", "Suns");

        // 3. 取得數據
        String team = playerMap.get("LeBron James");
        System.out.println("查詢結果: " + team);

        // 4. 檢查是否存在特定的鍵 (Key)
        if (playerMap.containsKey("Stephen Curry")) {
            System.out.println("名單中包含 Curry 的資料");
        }

        // 5. 更新數據 (同樣用 put，會直接覆蓋舊的內容)
        playerMap.put("LeBron James", "Heat");

        // 6. 刪除特定數據
        playerMap.remove("Kevin Durant");

        // 7. 取得目前總筆數
        System.out.println("總計資料數量: " + playerMap.size());

        // 8. 顯示所有資料 (遍歷)
        for (String key : playerMap.keySet()) {
            System.out.println("球員: " + key + " | 球隊: " + playerMap.get(key));
        }

        // 9. 清空所有內容
        playerMap.clear();
        System.out.println("清空後數量: " + playerMap.size());
    }
}
