package topic.topicTypes.culture;

public class Music extends Culture {
    private String genre;

    public Music(String category, int frequency, String name, String genre) {
        super(category, frequency, name);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Music [genre=" + genre + ", name=" + name + ", category=" + category + ", frequency=" + frequency + "]";
    }
}