package com.hfad.workout;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class WorkoutObject {

    @Id
    public long id;

    public String buildId;

    private String name;
    private String description;
    private String image;
    private String caption;
    private String link;
    private String latitude;
    private String longtitude;

    public WorkoutObject(String buildId, String name, String description, String image,String caption, String link,
                          String latitude,String longtitude) {
        this.buildId=buildId;
        this.name=name;
        this.description=description;
        this.image=image;
        this.caption=caption;
        this.link=link;
        this.latitude=latitude;
        this.longtitude=longtitude;
    }

    public WorkoutObject() {
    }

    public String getBuildId() {
        return buildId;
    }

    public void setId(String buildId) {
        this.buildId=buildId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description=description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image=image;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption=caption;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link=link;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude=latitude;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude=longtitude;
    }

}
