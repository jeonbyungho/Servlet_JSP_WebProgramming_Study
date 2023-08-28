import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        URL url = new URL("https://www.albamon.com/_next/data/pnjgVDl8rToqeqr_W0a40/jobs/total.json?page=1&");
        
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json; charset=UTF-8");

        StringBuilder strb = new StringBuilder();
        BufferedReader rd;

        rd = new BufferedReader(
            new InputStreamReader(conn.getInputStream(), "UTF-8"));

        String line;
        while((line = rd.readLine()) != null){
            strb.append(line);
        }

        rd.close();
        conn.disconnect();

        System.out.println(strb.toString());

    }
}
