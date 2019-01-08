import java.io.FileInputStream;
import java.util.Properties;

public class Props {
    private static Properties defaultProps = new Properties();
    static {
        try {
            FileInputStream in = new FileInputStream("./src/main/resources/config.properties");
            defaultProps.load(in);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String key) {
        return defaultProps.getProperty(key);
    }
}