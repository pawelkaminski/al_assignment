package al.assignment.symbolprocessor;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class WebCurrentBook {

    static String getCurrentWeb (String symbol) {
        String uri = "https://api.pro.coinbase.com/products/" + symbol + "/book?level=3";

        HttpsURLConnection con = null;
        try {
            URL url = new URL(uri);
            con = (HttpsURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            br.close();
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            // TODO(pawelk): process exception
            return "";
        } finally {
            if (con != null) {
                try {
                    con.disconnect();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}
