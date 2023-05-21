package org.j2os.project.domain;

import java.io.Serializable;

public class Cinema implements Serializable {
    private long id;
    private String title;
    private int from;
    private int to;
    private String name;
    private String family;

    public Cinema() {
    }

    public Cinema(long id, String title, int from, int to, String name, String family) {
        this.id = id;
        this.title = title;
        this.from = from;
        this.to = to;
        this.name = name;
        this.family = family;
    }

    public Cinema(String title, int from, int to, String name, String family) {
        this.title = title;
        this.from = from;
        this.to = to;
        this.name = name;
        this.family = family;
    }

    public long getId() {
        return id;
    }

    public Cinema setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Cinema setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getFrom() {
        return from;
    }

    public Cinema setFrom(int from) {
        this.from = from;
        return this;
    }

    public int getTo() {
        return to;
    }

    public Cinema setTo(int to) {
        this.to = to;
        return this;
    }

    public String getName() {
        return name;
    }

    public Cinema setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Cinema setFamily(String family) {
        this.family = family;
        return this;
    }
}
