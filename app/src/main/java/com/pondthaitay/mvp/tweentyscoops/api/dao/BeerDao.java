package com.pondthaitay.mvp.tweentyscoops.api.dao;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BeerDao {


    @SerializedName("status")
    private String status;
    @SerializedName("message")
    private String message;
    @SerializedName("nextBeerAvailable")
    private boolean nextBeerAvailable;
    @SerializedName("beers")
    private List<Beers> beers;
    @SerializedName("nextBeerIndex")
    private int nextBeerIndex;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getNextBeerAvailable() {
        return nextBeerAvailable;
    }

    public void setNextBeerAvailable(boolean nextBeerAvailable) {
        this.nextBeerAvailable = nextBeerAvailable;
    }

    public List<Beers> getBeers() {
        return beers;
    }

    public void setBeers(List<Beers> beers) {
        this.beers = beers;
    }

    public int getNextBeerIndex() {
        return nextBeerIndex;
    }

    public void setNextBeerIndex(int nextBeerIndex) {
        this.nextBeerIndex = nextBeerIndex;
    }

    public static class Beers {
        @SerializedName("alcohol")
        private String alcohol;
        @SerializedName("image")
        private String image;
        @SerializedName("name")
        private String name;
        @SerializedName("price")
        private int price;
        @SerializedName("volume")
        private String volume;
        @SerializedName("id")
        private String id;

        public String getAlcohol() {
            return alcohol;
        }

        public void setAlcohol(String alcohol) {
            this.alcohol = alcohol;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getVolume() {
            return volume;
        }

        public void setVolume(String volume) {
            this.volume = volume;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
