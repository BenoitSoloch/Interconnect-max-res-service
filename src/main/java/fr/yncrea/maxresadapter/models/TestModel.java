package fr.yncrea.maxresadapter.models;

public class TestModel {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "name='" + name + '\'' +
                '}';
    }
}
