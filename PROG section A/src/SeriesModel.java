public class SeriesModel {
    private String seriesId;
    private String seriesName;
    private int seriesAge;
    private int seriesNumberOfEpisodes;

    // Parameterized constructor to initialize all fields
    public SeriesModel(String seriesId, String seriesName, int seriesAge, int seriesNumberOfEpisodes) {
        this.seriesId = seriesId;
        this.seriesName = seriesName;
        this.seriesAge = seriesAge;
        this.seriesNumberOfEpisodes = seriesNumberOfEpisodes;
    }

    // Getter methods
    public String getSeriesId() {
        return seriesId;
    }
    public String getSeriesName() {
        return seriesName;
    }
    public int getSeriesAge() {
        return seriesAge;
    }
    public int getSeriesNumberOfEpisodes() {
        return seriesNumberOfEpisodes;
    }

    // Setter methods
    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }
    public void setSeriesAge(int seriesAge) {
        this.seriesAge = seriesAge;
    }
    public void setSeriesNumberOfEpisodes(int seriesNumberOfEpisodes) {
        this.seriesNumberOfEpisodes = seriesNumberOfEpisodes;
    }
}