package org.j2os.project.domain;

import java.io.Serializable;

public class Film implements Serializable {

    private long id;
    private String title;
    private int from;
    private int to;
    private int count;

    public Film() {
    }

    public Film(long id, String title, int from, int to, int count) {
        this.id = id;
        this.title = title;
        this.from = from;
        this.to = to;
        this.count = count;
    }

    public Film(String title, int from, int to, int count) {
        this.title = title;
        this.from = from;
        this.to = to;
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public Film setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Film setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getFrom() {
        return from;
    }

    public Film setFrom(int from) {
        this.from = from;
        return this;
    }

    public int getTo() {
        return to;
    }

    public Film setTo(int to) {
        this.to = to;
        return this;
    }

    public int getCount() {
        return count;
    }

    public Film setCount(int count) {
        this.count = count;
        return this;
    }
}
