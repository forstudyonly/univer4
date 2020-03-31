package com.training.martynenka;

import java.io.Serializable;

public class File implements Serializable {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
