package topic.topicTypes.sports;

public class Tennis extends Sports {
    private int numberOfSets;

    public Tennis(String category, int frequency, String name, int numberOfSets) {
        super(category, frequency, name);
        this.numberOfSets = numberOfSets;
    }

    public int getNumberOfSets() {
        return numberOfSets;
    }

    public void setNumberOfSets(int numberOfSets) {
        this.numberOfSets = numberOfSets;
    }

    public void play() {
        System.out.println("Playing a tennis match with " + numberOfSets + " sets.");
    }
}