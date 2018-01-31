package fr.aston.guide.models;

import java.io.Serializable;

public class Hotel implements Serializable {

    private String name;
    private String category;
    private String email;
    private String phone;
    private String site;
    private String image;
    private String stars;

    public Hotel(String name, String category, String email, String phone, String site, String stars, String image) {
        this.name = name;
        this.category = category;
        this.email = email;
        this.phone = phone;
        this.site = site;
        this.image = image;
        this.stars = stars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }
}
