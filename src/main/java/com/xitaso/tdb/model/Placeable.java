package com.xitaso.tdb.model;

import com.xitaso.tdb.valueobjects.Dimension;
import com.xitaso.tdb.valueobjects.Point;

import java.util.Objects;

public abstract class Placeable {
    private Dimension dimension;
    private Point location;

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = Objects.requireNonNull(dimension);
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = Objects.requireNonNull(location);
    }
}
