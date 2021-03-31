package client.model;

/**
 * the visible map for the agent (and its data such as other visible agent or cells' resources)
 * will store here
 */
public class Map {
    private Cell[] cells;
    private int antCurrentX;
    private int antCurrentY;

    //cells array is a [width][height] array
    public Map(Cell[] cells, int currentX, int currentY) {
        this.cells = cells;
        this.antCurrentX = currentX;
        this.antCurrentY = currentY;
    }

    public Cell[] getCells() {
        return cells;
    }

    public int getAntCurrentX() {
        return antCurrentX;
    }

    public int getAntCurrentY() {
        return antCurrentY;
    }
}
