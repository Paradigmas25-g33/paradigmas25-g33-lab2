package httpRequest;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


/* Esta clase se encarga de realizar efectivamente el pedido de feed al servidor de noticias
 * Leer sobre como hacer una http request en java
 * https://www.baeldung.com/java-http-request
 * */

public class httpRequester {
	
	public String getFeedRss(String urlFeed){
		//String feedRssXml = null;
		try {
			HttpClient client = HttpClient.newHttpClient();

			HttpRequest request = HttpRequest.newBuilder()
						.uri(URI.create(urlFeed))
						.GET()
						.build();
			
						HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
						
						if (response.statusCode() == 200) {
							return response.body(); // XML del feed
						} else {
							System.err.println("Error: código de estado HTTP " + response.statusCode());
							return null;
						}
		}
		catch (Exception exc){
			System.err.println("Excepción al obtener el feed RSS: " + exc.getMessage());
			return null;
		}
	}

	public String getFeedReedit(String urlFeed) {
		String feedReeditJson = null;
		return feedReeditJson;
	}

}
