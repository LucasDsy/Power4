package app.model;

public class Grid extends Element {

    private int height;
    private int width;

    private Token[][] grid_matrix;

    public Grid(int x, int y, int width, int height) {
        super(x,y);
        this.width = width;
        this.height = height;
    }

}