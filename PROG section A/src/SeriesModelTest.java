import org.junit.Test;
import static org.junit.Assert.*;

public class SeriesModelTest {

    @Test
    public void testConstructorAndGetters() {
        // Arrange
        String seriesId = "101";
        String seriesName = "Extreme Sports";
        int seriesAge = 12;
        int seriesNumberOfEpisodes = 10;

        // Act
        SeriesModel series = new SeriesModel(seriesId, seriesName, seriesAge, seriesNumberOfEpisodes);

        // Assert
        assertEquals("The series ID should match the constructor argument", seriesId, series.getSeriesId());
        assertEquals("The series name should match the constructor argument", seriesName, series.getSeriesName());
        assertEquals("The series age should match the constructor argument", seriesAge, series.getSeriesAge());
        assertEquals("The number of episodes should match the constructor argument", seriesNumberOfEpisodes, series.getSeriesNumberOfEpisodes());
    }

    @Test
    public void testSetters() {
        // Arrange
        SeriesModel series = new SeriesModel("102", "Initial Name", 10, 5);

        // Act
        series.setSeriesName("New Name");
        series.setSeriesAge(15);
        series.setSeriesNumberOfEpisodes(20);

        // Assert
        assertEquals("The series name should be updated", "New Name", series.getSeriesName());
        assertEquals("The series age should be updated", 15, series.getSeriesAge());
        assertEquals("The number of episodes should be updated", 20, series.getSeriesNumberOfEpisodes());
    }
}