package httpRequest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;


/* Esta clase se encarga de realizar efectivamente el pedido de feed al servidor de noticias
 * Leer sobre como hacer una http request en java
 * https://www.baeldung.com/java-http-request
 * */

public class httpRequester {
	
	public String getFeedRss(String urlFeed){
		String feedRssXml = null;
		HttpURLConnection con = null;

		try {
			URI uri = new URI(urlFeed);
			URL url = uri.toURL();
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int status = con.getResponseCode();
			if (status == 200) {
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer content = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					content.append(inputLine);
				}
				in.close();
				feedRssXml = content.toString(); // XML del feed
			} else {
				System.err.println("Error: código de estado HTTP " + status);
			}
		} catch (Exception e) {
			System.err.println("Error creating URL or opening connection: " + e.getMessage());
		} finally {
			if (con != null) {
				con.disconnect();
			}
		}

		return feedRssXml;
	}

	public String getFeedReedit(String urlFeed) {
		String feedReeditJson = null;
		return feedReeditJson;
	}
	
	public static void main(String[] args) {
        httpRequester requester = new httpRequester();
        String urlFeed = "https://rss.nytimes.com/services/xml/rss/nyt/Business.xml"; // URL de prueba
        String feedContent = requester.getFeedRss(urlFeed);

        if (feedContent != null) {
            System.out.println("Feed RSS obtenido:");
            System.out.println(feedContent);
        } else {
            System.err.println("No se pudo obtener el feed RSS.");
        }
    }

}
