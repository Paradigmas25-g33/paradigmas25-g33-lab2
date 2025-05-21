package parser;

import java.io.ByteArrayInputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

import feed.Article;
import feed.Feed;
import httpRequest.httpRequester;

import javax.xml.parsers.DocumentBuilder;

public class RssParser extends GeneralParser {

    @Override
    public Object parse(String input) {
        Feed feed = new Feed("RSS Feed");

        try {
			// creo el parser para el XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = factory.newDocumentBuilder();

            ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes("UTF-8"));
            Document xmldoc = docBuilder.parse(inputStream);
            xmldoc.getDocumentElement().normalize();

			// obtengo todos los items del feed
            NodeList itemNodes = xmldoc.getElementsByTagName("item");

			// recorro los items y extraigo la información
            for (int i = 0; i < itemNodes.getLength(); i++) {
                Node node = itemNodes.item(i);

				// verifico que el nodo sea un elemento (y no un texto o comentario)
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element itemElement = (Element) node;

					// extraigo la informacion que necesito
                    String title = getTagValue("title", itemElement);
                    String description = getTagValue("description", itemElement);
                    String pubDateStr = getTagValue("pubDate", itemElement);
                    String link = getTagValue("link", itemElement);

					// convierto la fecha de publicación a un objeto Date
                    Date publicationDate = null;
                    if (pubDateStr != null && !pubDateStr.isEmpty()) {
                        try {
                            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
                            publicationDate = new Date(dateFormat.parse(pubDateStr).getTime());
                        } catch (ParseException e) {
                            System.err.println("Error parsing pubDate: " + pubDateStr);
                        }
                    }

					// creo un objeto Article con la información extraída y lo agrego al feed
                    Article article = new Article(title, description, publicationDate, link);
                    feed.addArticle(article);
                }
            }

        } catch (Exception e) {
            System.err.println("Error parsing RSS feed: " + e.getMessage());
            e.printStackTrace();
        }

        return feed;
    }

	// metodo auxiliar para obtener el valor de un tag específico, evita segmentation faults
    private String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag);

		if (nodeList != null && nodeList.getLength() > 0) {
            Node node = nodeList.item(0);
            if (node != null && node.getFirstChild() != null) {
                return node.getTextContent();
            }
        }
		// devuelvo una cadena vacía si no se encuentra el tag (o si no tiene contenido)
        return "";
    }

    public static void main(String[] args) {
        System.out.println("************* RssParser Test *************");
        RssParser parser = new RssParser();

		// creo un objeto httpRequester para obtener el feed RSS
        httpRequester requester = new httpRequester();
        String feedRss = requester.getFeedRss("https://rss.nytimes.com/services/xml/rss/nyt/Business.xml");
        Feed result = (Feed) parser.parse(feedRss);

        if (result != null) {
            System.out.println("Parseo exitoso. Elementos extraídos:");
            //result.prettyPrint(1); // muestra los elementos de manera legible
        } else {
            System.err.println("Error al parsear el archivo RSS");
        }
    }
}
