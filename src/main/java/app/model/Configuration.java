package app.model;


public class Configuration {

    private float grid_width = 7;
    private float grid_height = 6;

    private Grid my_grid;

    public Configuration() {}

    public float getGridWidth() {
        return this.grid_width;
    }

    public float getGridHeight() {
        return this.grid_height;
    }

}