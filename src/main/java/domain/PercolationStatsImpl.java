package domain;

import domain.data.PercolationStatsData;

import java.util.Random;
import java.util.Scanner;

/**
 * Реализация {@link PercolationStats}.
 */
public class PercolationStatsImpl implements PercolationStats {

    @Override
    public PercolationStatsData execute(int size, int trials) {
        //TODO реализовать метод выполнения эксперимента
        Percolation percolation = new PercolationImpl2(size);
        double[] pvalue = new double[trials];
        double p = 0;
        double pMin = 1;
        double pMax = 0;
        Random random = new Random();

        for (int i = 0; i < trials; i++) {
            percolation.closeAllCell();
            while (!percolation.hasPercolation()) {
                int x = random.nextInt(size);
                int y = random.nextInt(size);
                percolation.openCell(x, y);
            }
            pvalue[i] = ((double) percolation.getOpenCellsCount()) / size / size;
        }

        for (double v : pvalue) {
            if (v > pMax) pMax = v;

            if (v < pMin) pMin = v;

            p += v;
        }
        p = p / pvalue.length;

        return new PercolationStatsData(size, trials, p, pMin, pMax);
    }

}
