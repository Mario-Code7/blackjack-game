package com.pluralsight;

public class Players {
    private String name;
    private Hand hand;

    public Players(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    @Override
    public String toString() {
        return "Players{" +
                "name='" + name + '\'' +
                ", hand=" + hand +
                '}';
    }
}
