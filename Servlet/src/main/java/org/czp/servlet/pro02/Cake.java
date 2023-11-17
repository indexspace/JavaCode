package org.czp.servlet.pro02;

public class Cake {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;

    public Cake(String id, String name) {
        this.id = id;
        this.name = name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
