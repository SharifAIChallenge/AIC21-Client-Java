package client.model;

/**
 * the visible map for the agent (and its data such as other visible agent or cells' resources)
 * will store here
 */
public class Map {
    private Cell[][] cells;
    private int width;
    private int height;
    private int manhattanDistance;

    //cells array is a [height][width] array
    public Map(Cell[][] cells, int width, int height, int manhattanDistance, int currentX, int currentY) {
        this.width = width;
        this.height = height;
        this.manhattanDistance = manhattanDistance;
        this.cells = cells;
        this.cells = createCompressedCells(currentX, currentY);
    }

    /*
     * transform {cells} array which is a [height][width] array to
     * a [2 * distance][2 * distance] array
     *
     * @return a compressed array that is a [2*distance + 1][2*distance + 1] array
     */
    private Cell[][] createCompressedCells(int midX, int midY) {
        Cell[][] compressedCells = new Cell[2 * manhattanDistance + 1][2 * manhattanDistance + 1];

        int starterI = Math.max(midY - manhattanDistance, 0), endI = Math.min(midY + manhattanDistance, height);
        int starterJ = Math.max(midX - manhattanDistance, 0), endJ = Math.min(midX + manhattanDistance, width);
        int xTransform = manhattanDistance - midX;
        int yTransform = manhattanDistance - midY;

        for (int i = starterI; i < endI; i++) {
            for (int j = starterJ; j < endJ; j++) {
                try {
                    compressedCells[j + yTransform][i + xTransform] = cells[j][i];
                } catch (IndexOutOfBoundsException ignored) {
                }
            }
        }

        return compressedCells;
    }

    /*
     * the top left cell has coordinate (0, 0)
     * [x] indicate horizontal moves
     * [y] indicate vertical moves
     *
     * @param x, y are relative to current cell of ant
     */
    public Cell getCell(int x, int y, int distance) {
        if (Math.abs(x) + Math.abs(y) > distance)
            return null;
        if (distance + x >= width | distance + x < 0)
            return null;
        if (distance + y < 0 | distance + y >= height)
            return null;

        return cells[distance + y][distance + x];
    }
}
