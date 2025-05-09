package parser;

import java.io.ByteArrayInputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

import feed.Article;
import feed.Feed;

import httpRequest.httpRequester;

import javax.xml.parsers.DocumentBuilder;

/* Esta clase implementa el parser de feed de tipo rss (xml)
 * https://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm 
 * */

public class RssParser extends GeneralParser {

	@Override
	public Object parse(String input) {
		Feed feed = new Feed(input);
		Document xmldoc = null;
		//TODAVIA NO ESTA TERMINADO, PELA TERMINALO
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = factory.newDocumentBuilder();

			//Reading the XML
			StringBuilder xmlBuilder = new StringBuilder(); 
			xmlBuilder.append(input);
				 
			//Parsing the XML Document
			ByteArrayInputStream inputStream = new ByteArrayInputStream(xmlBuilder.toString().getBytes("UTF-8"));
			xmldoc = docBuilder.parse(inputStream);
		} catch (Exception e) {
			System.err.println("Error parsing XML: " + e.getMessage());
		}

		for(int i = 0; i < 5; i++) {
			//System.out.println("Articulo " + i + ": " + article.toString());
			String title = xmldoc.getElementsByTagName("title").item(i).getTextContent();
			String description = xmldoc.getElementsByTagName("description").item(i).getTextContent();
			String pubDate = xmldoc.getElementsByTagName("pubDate").item(i).getTextContent();
			String link = xmldoc.getElementsByTagName("link").item(i).getTextContent();
			SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
        	Date publicationDate = null;
			try {
				publicationDate = new Date(dateFormat.parse(pubDate).getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
	
			Article article = new Article(title, description, publicationDate, link);
			feed.addArticle(article);
		}

		return feed;
	}


	public static void main(String[] args) {
		System.out.println("************* RssParser Test *************");
		RssParser parser = new RssParser();
	
		httpRequester requester = new httpRequester();
		String feedRss = requester.getFeedRss("https://rss.nytimes.com/services/xml/rss/nyt/Business.xml");
		Feed result = (Feed) parser.parse(feedRss);
	
		if (result != null) {
			System.out.println("Parseo exitoso. Elementos extraídos:");
			System.out.println(result);
		} else {
			System.err.println("Error al parsear el archivo RSS.");
		}
	}
}
