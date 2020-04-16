import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpToHttpsTest {
    public static void main (String[] args) throws MalformedURLException {

        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers () {
                        return null;
                    }

                    public void checkClientTrusted (
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }

                    public void checkServerTrusted (
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }
                }
        };
// Activate the new trust manager
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
        }
        String path = "/resources/PDF/Ue279d3ed316ff28024cc24c21717235c3877ff6cjm.pdf";

        StringBuffer outResult = new StringBuffer();

        int responseCode = 400;
        String charset = "UTF-8";
        String boundary = Long.toHexString(System.currentTimeMillis());
        String CRLF = "\r\n";

        InputStream is;
        URL url = new URL("https://portal.docuchain.kr" + path);
        try {
            HttpsURLConnection ucon = (HttpsURLConnection) url.openConnection();

            is = ucon.getInputStream();
            byte[] idata = new byte[1024000];
            int length = 0;

            while ((length = is.read()) != -1) {
                outResult.append((char) length);
            }
            is.close();
            System.out.println(outResult);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
