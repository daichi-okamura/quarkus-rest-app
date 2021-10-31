package jp.ampnmn.rest.json;

public class Fruit {

    public String name;
    public String description;

    public Fruit() {
        // JSONシリアライズレイヤーで必須
    }

    public Fruit(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
