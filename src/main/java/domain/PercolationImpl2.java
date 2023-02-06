package domain;

import domain.data.CellState;

import java.util.Arrays;

import static domain.data.CellState.*;

/**
 * Реализация {@link Percolation}.
 */
public class PercolationImpl2 implements Percolation {

    private final CellState[][] array;
    private final int size;
    private boolean hasPercolation;
    private int openCells;

    public PercolationImpl2(int size) {
        array = new CellState[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(array[i], LOCK);
        }
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean hasPercolation() {
        return hasPercolation;
    }

    @Override
    public void openCell(int x, int y) {
        if (array[x][y] != LOCK) return;

        openCells = openCells + 1;
        array[x][y] = OPEN;
        if (y == 0) {
            array[x][y] = FULL;
        }
        tryToPercolated();
    }

    public void tryToPercolated() {
        for (int y = 1; y < size; y++) {
            tryToPercolatedY(y);
            if (y == size - 1) {
                for (int i = 0; i < size; i++) {
                    if (array[i][y] == FULL) {
                        hasPercolation = true;
                        return;
                    }
                }
            } else {
                int sum = 0;
                for (int i = 0; i < size; i++) {
                    if (array[i][y] == FULL) {
                        sum += 1;
                    }
                }
                if (sum == 0) {
                    return;
                }
            }
        }
    }

    public void tryToPercolatedY(int y) {
        for (int i = 0; i < size; i++) {
            if (array[i][y] == OPEN) {
                if (array[i][y - 1] == FULL) {
                    array[i][y] = FULL;
                    CellState state = OPEN;
                    int k = i;
                    if (i > 0 && array[i - 1][y] == OPEN) {
                        while (state == OPEN && k > 0) {
                            array[k - 1][y] = FULL;
                            if (k > 1) {
                                state = array[k - 2][y];
                                k = k - 1;
                            } else {
                                break;
                            }
                        }
                    }
                    if (i < size - 1 && array[i + 1][y] == OPEN) {
                        while (state == OPEN && k < size - 1) {
                            array[k + 1][y] = FULL;
                            if (k < size - 2) {
                                state = array[k + 2][y];
                                k = k + 1;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public long getOpenCellsCount() {
        return openCells;
    }

    @Override
    public CellState getCellState(int x, int y) {
        return array[x][y];
    }

    @Override
    public void closeAllCell() {
        for (int i = 0; i < size; i++) {
            Arrays.fill(array[i], LOCK);
        }
        hasPercolation = false;
        openCells = 0;
    }

    public void setHasPercolation(boolean per){
        hasPercolation = per;
    }
}
