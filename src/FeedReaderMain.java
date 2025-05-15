import parser.RssParser;
import parser.SubscriptionParser;
import subscription.Subscription;
import feed.Feed;
import httpRequest.httpRequester;
import subscription.SingleSubscription;

public class FeedReaderMain {

	private static void printHelp(){
		System.out.println("Please, call this program in correct way: FeedReader [-ne]");
	}
	
	public static void main(String[] args) {
		System.out.println("************* FeedReader version 1.0 *************");
		if (args.length == 0) {

			//Leer el archivo de suscription por defecto;
			SubscriptionParser parser = new SubscriptionParser();
			Subscription subscription = parser.parse(System.getProperty("user.dir") + "/config/subscriptions.json");
			
			//Llamar al httpRequester para obtenr el feed del servidor
			httpRequester requester = new httpRequester();
			String feedUrlRss = null;
			String feedContentRss = null;
			RssParser rssParser = new RssParser();
			Feed resultRss = new Feed("RSS Feed");
				//String feedUrlReddit = null;
				//String feedContentReddit = null;

			for (SingleSubscription singleSubscription : subscription.getSubscriptionsList()) {
				String UrlType = singleSubscription.getUrlType();
				
				if ("rss".equals(UrlType)) {
					
					feedUrlRss = singleSubscription.getUrl();
					feedContentRss = requester.getFeedRss(feedUrlRss);
					resultRss = (Feed) rssParser.parse(feedContentRss);
				
				} else if ("reddit".equals(UrlType)){
					System.out.println("Funciòn no implementada");
					return;
					//String feedUrl = singleSubscription.getUrl();
					//String feedContent = requester.getFeedRss(feedUrl);
				} else {
					System.err.println("Url no encontrada");
				}
			}
			
			//Llamar al Parser especifico para extrar los datos necesarios por la aplicacion 
			
			/*
			Llamar al constructor de Feed
			LLamar al prettyPrint del Feed para ver los articulos del feed en forma legible y amigable para el usuario
			*/
			resultRss.prettyPrint();
			
		} else if (args.length == 1){
			
			/*
			Leer el archivo de suscription por defecto;
			Llamar al httpRequester para obtenr el feed del servidor
			Llamar al Parser especifico para extrar los datos necesarios por la aplicacion 
			Llamar al constructor de Feed
			Llamar a la heuristica para que compute las entidades nombradas de cada articulos del feed
			LLamar al prettyPrint de la tabla de entidades nombradas del feed.
			 */
			
		}else {
			printHelp();
		}
	}

}
