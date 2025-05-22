package feed;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import namedEntity.NamedEntity;
import namedEntity.EntityTypes.*;
import namedEntity.heuristic.Heuristic;

/*Esta clase modela el contenido de un articulo (ie, un item en el caso del rss feed) */

public class Article {
	private String title;
	private String text;
	private Date publicationDate;
	private String link;
	
	public List<NamedEntity> namedEntityList = new ArrayList<NamedEntity>();
	
	
	public Article(String title, String text, Date publicationDate, String link) {
		super();
		this.title = title;
		this.text = text;
		this.publicationDate = publicationDate;
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	@Override
	public String toString() {
		return "Article [title=" + title + ", text=" + text + ", publicationDate=" + publicationDate + ", link=" + link
				+ "]";
	}
	
	
	
	public NamedEntity getNamedEntity(String namedEntity){
		for (NamedEntity n: namedEntityList){
			if (n.getName().compareTo(namedEntity) == 0){				
				return n;
			}
		}
		return null;
	}
	

	public void computeNamedEntities(Heuristic h) {
		// limpiar texto
		String text = (getTitle() + " " + getText())
			.replaceAll("[\\.,;:()'’!?\\n]", " ");
	
		// itero cada palabra del articulo
		for (String s : text.split("\\s+")) {
			if (!h.isEntity(s)) continue;
	
			// si ya existe, incremento y sigo
			NamedEntity existing = getNamedEntity(s);
			if (existing != null) {
				existing.incFrequency();
				continue;
			}

			// obtengo la categoria
			String category = h.getCategory(s);
			NamedEntity entity;

			if (category.equals("Other")) {
				// intento encontrar un entity con name="Other"
				NamedEntity other = getNamedEntity("Other");
				if (other != null) {
					other.incFrequency();
					continue;
				}
				// si no existe, creo la única instancia:
				entity = new NamedEntity("Other", 1, "Other", null) {
					@Override
					public String getCategory() { return "Other"; }
				};
			
			} else if (category.equals("Person")) {
				entity = new Persona("Person", 1, s, null, 0, s, s, "");

			} else if (category.equals("Company")) {
				entity = new Organizacion("Company", 1, s, null, "", 0, "");

			} else if (category.equals("Product")) {
				entity = new Producto("Product", 1, s, null, "", "");

			} else if (category.equals("Event")) {
				entity = new Evento("Event", 1, s, null, "", null, null);

			} else if (category.equals("Date")) {
				entity = new Fecha("Date", 1, s, null, null);

			} else {
				entity = new Lugar("Place", 1, s, null, "", null, null);

			} 

			// agrego a la lista
			namedEntityList.add(entity);
		}
	}
	

	
	public void prettyPrint() {
		System.out.println("**********************************************************************************************");
		System.out.println("Title: " + this.getTitle());
		System.out.println("Publication Date: " + this.getPublicationDate());
		System.out.println("Link: " + this.getLink());
		System.out.println("Description: " + this.getText());
		System.out.println("**********************************************************************************************");	
	}

	public void prettyPrintH() {
		System.out.println("**********************************************************************************************");
		System.out.println("Title: " + this.getTitle());
		System.out.println("Publication Date: " + this.getPublicationDate());
		System.out.println("Link: " + this.getLink());
		System.out.println("Description: " + this.getText());
		// Imprimir entidades de este artículo
		System.out.println("=== Entidades del artículo ===");
		if (namedEntityList.isEmpty()) {
			System.out.println("No se detectaron entidades nombradas.");
		} else {
			System.out.println("Categoria\tNombre\t\tFrecuencia");
			for (NamedEntity ne : namedEntityList) {
				System.out.printf("%-10s\t%-16s\t%d\n", ne.getCategory(), ne.getName(), ne.getFrequency());
			}
		}
		System.out.println("**********************************************************************************************");
	}
	
	public static void main(String[] args) {
		  Article a = new Article(
            "Elon Musk y Apple lanzan un nuevo producto en USA",
            "El evento de Apple fue presentado por Elon Musk en California el 20 de mayo de 2025.",
            new Date(),
            "https://www.nytimes.com/2023/04/05/technology/apple-musk-event.html"
        );

        // Instanciar una heurística (puedes cambiar por RandomHeuristic si querés)
        namedEntity.heuristic.Heuristic heuristic = new namedEntity.heuristic.QuickHeuristic();

        // Computar entidades nombradas
        a.computeNamedEntities(heuristic);

        // Imprimir artículo y entidades nombradas encontradas
        a.prettyPrint();
        System.out.println("Entidades nombradas encontradas:");
        for (namedEntity.NamedEntity ne : a.namedEntityList) {
            System.out.println(ne);
        }
	}
	
	
}



