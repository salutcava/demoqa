import java.text.SimpleDateFormat;
import java.util.Date;

public class App {
    public static String timestamp() {
        // Timestamp to make each screenshot name unique
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

    public static String date() {
        // Timestamp to make each screenshot name unique
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }
}