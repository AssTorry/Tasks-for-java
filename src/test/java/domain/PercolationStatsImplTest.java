package domain;

import domain.data.PercolationStatsData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Тест на {@link PercolationStatsImpl}.
 */
public class PercolationStatsImplTest {
    PercolationStats percolationStats = new PercolationStatsImpl();
    double precision = 0.01;

    @Test
    public void checkExecuteV1() {
        PercolationStatsData data = percolationStats.execute(10, 500);

        double expected = 0.5909;

        Assertions.assertTrue(expected + precision > data.p);
        Assertions.assertTrue(expected - precision < data.p);
    }

    @Test
    public void checkExecuteV2() {
        PercolationStatsData data = percolationStats.execute(5, 5000);

        double expected = 0.5929;

        Assertions.assertTrue(expected + precision > data.p);
        Assertions.assertTrue(expected - precision < data.p);
    }

    @Test
    public void checkExecuteV3() {
        PercolationStatsData data = percolationStats.execute(2, 10000);

        double expected = 0.6669;

        Assertions.assertTrue(expected + precision > data.p);
        Assertions.assertTrue(expected - precision < data.p);
    }
}
