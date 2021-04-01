package client.model;

/**
 * the visible map for the agent (and its data such as other visible agent or cells' resources)
 * will store here
 */
public class Map {
    private Cell[][] cells;
    private int width;
    private int height;
    private int antCurrentX;
    private int antCurrentY;

    //cells array is a [width][height] array
    public Map(Cell[][] cells, int width, int height, int currentX, int currentY) {
        this.width = width;
        this.height = height;
        this.cells = cells;
        this.antCurrentX = currentX;
        this.antCurrentY = currentY;
    }

    /**
     * the top left cell has coordinate (0, 0)
     * [x] indicate horizontal moves
     * [y] indicate vertical moves
     *
     * @param dx,dy are relative to current cell of ant
     */
    public Cell getRelativeCell(int dx, int dy) {
        int x = antCurrentX + dx;
        int y = antCurrentY + dy;

        if (x < 0 | x >= width | y < 0 | y >= height)
            return null;

        return cells[x][y];
    }
}
