package org.pozopardo.iplytics.proman.model;

import java.util.Date;

public class Project {
    private final String name;
    private final Date date;
    private final int buffer;

    public Project(String name, Date date, int buffer ) {
        this.name = name;
        this.date = date;
        this.buffer = buffer;
    }
}
