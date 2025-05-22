import parser.RssParser;
import parser.SubscriptionParser;
import subscription.Subscription;
import feed.Feed;
import httpRequest.httpRequester;
import namedEntity.heuristic.QuickHeuristic;
import subscription.SingleSubscription;

public class FeedReaderMain {

	private static void printHelp(){
		System.out.println("Please, call this program in correct way: FeedReader [-ne]");
	}
	
	public static void main(String[] args) {
		System.out.println("************* FeedReader version 1.0 *************");
		if (args.length == 0) {
			
			SubscriptionParser parser = new SubscriptionParser();
			Subscription subscription = parser.parse(System.getProperty("user.dir") + "/../config/subscriptions.json");
			
			httpRequester requester = new httpRequester();
			Feed resultRss = new Feed("RSS Feed");
			//String feedUrlReddit = null;
			//String feedContentReddit = null;
			
			for (SingleSubscription singleSubscription : subscription.getSubscriptionsList()) {
				String UrlType = singleSubscription.getUrlType();
				
				if ("rss".equals(UrlType.toLowerCase())) {
					
					String feedUrlRss = null;
					String feedContentRss = null;
					RssParser rssParser = new RssParser();
					feedUrlRss = singleSubscription.getUrl();
					feedContentRss = requester.getFeedRss(feedUrlRss); 
					resultRss = (Feed) rssParser.parse(feedContentRss);

					
				} else if ("reddit".equals(UrlType.toLowerCase())){
					System.out.println("Funciòn no implementada");
					//String feedUrl = singleSubscription.getUrl();
					//String feedContent = requester.getFeedRss(feedUrl);
				} else {
					System.err.println("Url no encontrada");
				}
			}
			
			resultRss.prettyPrint(1);
			
		} else if (args.length == 1 && args[0].equals("-ne")) {
			
			SubscriptionParser parser = new SubscriptionParser();
			Subscription subscription = parser.parse(System.getProperty("user.dir") + "/../config/subscriptions.json");
			
			QuickHeuristic heuristic = new QuickHeuristic();
			
			httpRequester requester = new httpRequester();
			Feed resultRss = new Feed("RSS Feed");
			//String feedUrlReddit = null;
			//String feedContentReddit = null;
			
			for (SingleSubscription singleSubscription : subscription.getSubscriptionsList()) {
				String UrlType = singleSubscription.getUrlType();
				
				if ("rss".equals(UrlType.toLowerCase())) {
					
					String feedUrlRss = null;
					String feedContentRss = null;
					RssParser rssParser = new RssParser();
					feedUrlRss = singleSubscription.getUrl();
					feedContentRss = requester.getFeedRss(feedUrlRss); // FeedContentRss == NULL
					resultRss = (Feed) rssParser.parse(feedContentRss);
					
					
				} else if ("reddit".equals(UrlType.toLowerCase())){
					System.out.println("Funciòn reddit no implementada");
					//String feedUrl = singleSubscription.getUrl();
					//String feedContent = requester.getFeedRss(feedUrl);
				} else {
					System.err.println("Url no encontrada");
				}
			}

			java.util.Map<String, Integer> globalCount = new java.util.HashMap<>();
			java.util.Map<String, String> entityCategory = new java.util.HashMap<>();
			int totalEntities = 0;
			int totalFrequency = 0;
			for (int i = 0; i < resultRss.getNumberOfArticles(); i++) {
				resultRss.getArticle(i).computeNamedEntities(heuristic);
				for (namedEntity.NamedEntity ne : resultRss.getArticle(i).namedEntityList) {
					String key = ne.getCategory() + "|" + ne.getName();
					globalCount.put(key, globalCount.getOrDefault(key, 0) + ne.getFrequency());
					entityCategory.put(key, ne.getCategory());
					totalEntities++;
					totalFrequency += ne.getFrequency();
					/*
					if (ne.getCategory().equals("Person")) {
						ne.setTopic(new topic.topicTypes.sports.Formula1("Formula1", "Sports", 1));
					} else if (ne.getCategory().equals("Company")) {
						ne.setTopic(new topic.topicTypes.culture.Cinema("Cinema", "Culture", 1));
					} else if (ne.getCategory().equals("Place")) {
						ne.setTopic(new topic.topicTypes.politics.National("National", 1, "Geography"));
					} else {
						ne.setTopic(new topic.topicTypes.culture.Music("Music", "Culture", 1));
					}
						------------------FUNCIONA a MEDIAS-----------------*/
					
				}
			}
			resultRss.prettyPrint(0);
			System.out.println("\nTotal named entities found: " + totalEntities);
			System.out.println("Total frequency: " + totalFrequency);
			
			
		}else {
			printHelp();
		}
	}

}
