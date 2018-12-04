package com.hfad.workout;

public class WorkoutObject {

    private String name;
    private String description;
    private String image;
    private String caption;
    private String link;
    private String latitude;
    private String longtitude;

    private WorkoutObject(String name, String description, String image,String caption, String link,
                          String latitude,String longtitude) {
        this.name=name;
        this.description=description;
        this.image=image;
        this.caption=caption;
        this.link=link;
        this.latitude=latitude;
        this.longtitude=longtitude;
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name=name;
    }

    private String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description=description;
    }

    private String getImage() {
        return image;
    }

    private void setImage(String image) {
        this.image=image;
    }

    private String getCaption() {
        return caption;
    }

    private void setCaption(String caption) {
        this.caption=caption;
    }

    private String getLink() {
        return link;
    }

    private void setLink(String link) {
        this.link=link;
    }

    private String getLatitude() {
        return latitude;
    }

    private void setLatitude(String latitude) {
        this.latitude=latitude;
    }

    private String getLongtitude() {
        return longtitude;
    }

    private void setLongtitude(String longtitude) {
        this.longtitude=longtitude;
    }

}
