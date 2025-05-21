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
        String text = this.getTitle() + " " + this.getText();

        String charsToRemove = ".,;:()'!?\n";
        for (char c : charsToRemove.toCharArray()) {
            text = text.replace(String.valueOf(c), "");
        }


        for (String s : text.split(" ")) {
            if (h.isEntity(s)) {
                NamedEntity ne = this.getNamedEntity(s);
                if (ne == null) {
                    String category = h.getCategory(s);
                    // Si no hay clasificacion definida para esta named entity, su tipo sera
                    // generico.
                    if(category == null) {
                        category = "Other";
                    } else {
                        if (category.equals("Person")) {
                            Persona entity = new Persona(category, 0, s, null, 0, null, null, null);
							entity.setFrequency(1);
                    		this.namedEntityList.add(entity);
						}
						else if (category.equals("Company")) {
							Organizacion entity = new Organizacion(category ,0, s,null, null, 0, null);
							entity.setFrequency(1);
                    		this.namedEntityList.add(entity);
						}
						else if (category.equals("Event")) {
							Evento entity = new Evento(category, 0, s, null, null, null, null);
							entity.setFrequency(1);
                    		this.namedEntityList.add(entity);
						}
						else if (category.equals("Product")) {
							Producto entity = new Producto(category, 0, s, null, null, null);
							entity.setFrequency(1);
                    		this.namedEntityList.add(entity);
						}
						else if (category.equals("Date")) {
							Fecha entity = new Fecha(category, 0, s, null, null);
							entity.setFrequency(1);
                    		this.namedEntityList.add(entity);
						}
						else if (category.equals("Place") || category.equals("Country") || category.equals("City")) {
							Lugar entity = new Lugar(category, 0, s, null, null, null, null);
							entity.setFrequency(1);
                    		this.namedEntityList.add(entity);
						}
                    }
                } else {
                    ne.incFrequency();
                }
            }
        }
    }

	
	public void prettyPrint() {
		System.out.println("**********************************************************************************************");
		System.out.println("Title: " + this.getTitle());
		System.out.println("Publication Date: " + this.getPublicationDate());
		System.out.println("Link: " + this.getLink());
		System.out.println("Text: " + this.getText());
		System.out.println("**********************************************************************************************");	
	}

	public void prettyPrintH(int totalEntities, int totalFrequency, java.util.Map<String, Integer> globalCount) {
		System.out.println("**********************************************************************************************");
		System.out.println("Title: " + this.getTitle());
		System.out.println("Publication Date: " + this.getPublicationDate());
		System.out.println("Link: " + this.getLink());
		System.out.println("Text: " + this.getText());
		// Imprimir resumen global
		System.out.println("=== Entidades globales ===");
		System.out.println("Cantidad total de entidades: " + totalEntities);
		System.out.println("Frecuencia acumulada: " + totalFrequency);
		System.out.println("Categoria\tNombre\t\tFrecuencia");
		for (String key : globalCount.keySet()) {
			String[] parts = key.split("\\|");
			String categoria = parts[0];
			String nombre = parts[1];
			int frecuencia = globalCount.get(key);
			System.out.printf("%-10s\t%-16s\t%d\n", categoria, nombre, frecuencia);
		}
		System.out.println("**********************************************************************************************");	
	}
	
	public void prettyPrintH() {
		System.out.println("**********************************************************************************************");
		System.out.println("Title: " + this.getTitle());
		System.out.println("Publication Date: " + this.getPublicationDate());
		System.out.println("Link: " + this.getLink());
		System.out.println("Text: " + this.getText());
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



