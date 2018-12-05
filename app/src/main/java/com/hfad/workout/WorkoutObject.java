package com.hfad.workout;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class WorkoutObject {

    @Id
    public long id;

    private String name;
    private String description;
    private String image;
    private String caption;
    private String link;
    private String latitude;
    private String longtitude;

    //this list is meant to be used to provide information to the WorkoutListFragment
    static WorkoutObject[] workouts = {
            new WorkoutObject("CIS Building", "The Computer Information Systems (CIS) building was constructed to house the Information Systems and Operations" +
                    "Management Department from the Cameron School of Business and the Department of Computer Science from the College of Arts and Sciences." +
                    "The CIS Building, a new 51,731 square-foot state-of-the-art facility on the UNCW campus, opened January 10, 2007 for the new school semester." +
                    "Work on the facility began on July 29, 2004 with the groundbreaking, and competed in December of 2006." +
                    "The building cost approximately $12.8 million and was funded by the North Carolina State Bond campaign of 2000." +
                    "Housed within the new building is the Financial Markets Room and, thanks to a donation from Edward Jones and over 50 if its financial advisers, the Edward Jones Financial Lab." +
                    "Both rooms contain a stock board and ticker, however the Edward Jones Financial Lab also includes the Bloomberg Trading Terminal." +
                    "With this terminal, students and faculty have the ability to trade stocks directly with the New York Stock Exchange, NASDAQ and more.",
                    "cis.jpg",
                    "(A front view of the CIS building)",
                    "https://library.uncw.edu/web/collections/archives/bnl/cis.html",
                    "34.2261017",
                    "-77.87184949415777"),

    new WorkoutObject("Bear Hall","Bear Hall opened at its present site in 1972 as the home for the Business and Economics Departments."+
                          "Currently, the Departments of Computer Science, Mathematics and Statistics, and Philosophy and Religion occupy classrooms, teaching labs and faculty offices."+
                          "The College of Arts and Science also resides here. ",
                          "bear.jpg",
                          "(A front view of Bear Hall)",
                          "https://library.uncw.edu/web/collections/archives/bnl/19.html",
                          "34.228545",
                          "-77.87280469680556"),

    new WorkoutObject("Dobo Hall","Opened for use in 1996, the New Science Building contained classrooms, laboratories and faculty offices for the Chemistry and Biology Departments."+
                          "Known as Dobo Hall since its 1999 dedication to the Dobo brothers, it is currently used by the Department of Biology and Marine Biology and the Department of Chemistry.",
                          "dobo.jpg",
                          "(A front view of Dobo Hall)",
                          "https://library.uncw.edu/web/collections/archives/bnl/25.html",
                          "34.2257237",
                          "-77.86848956387306"),

    new WorkoutObject("Cameron Hall","Funding for Cameron Hall began in 1985, with occupancy starting in 1988."+
                          "As the home of the Cameron School of Business, the building contains classrooms and faculty offices."+
                          "he official naming dedication was held on October 5, 1988.",
                          "cameron.jpg",
                          "(A front view of Cameron Hall)",
                          "https://library.uncw.edu/web/collections/archives/bnl/24.html",
                          "34.226041800000004",
                          "-77.8695462604443"),

    new WorkoutObject("Deloach Hall"," Originally called the Physics-Chemistry Building, this structure housed classrooms for those departments."+
                          "Groundbreaking took place in July of 1967, occupation began in 1968, with the official renaming ceremony to DeLoach Hall in October of 1985."+
                          "Currently the building holds offices and classrooms for the Department of Physics, Department of Physical Oceanography and the Department of Earth Sciences."+
                          "The Department of Chemistry was housed here until Dobo Hall opened. DeLoach Hall contains a large teaching auditorium and several laboratories.",
                          "deloach.jpg",
                          "(A front view of Deloach Hall)",
                          "https://library.uncw.edu/web/collections/archives/bnl/2.html",
                          "34.228831799999995",
                          "-77.87445745000001")
    };

    public WorkoutObject(String name, String description, String image,String caption, String link,
                          String latitude,String longtitude) {
        this.name=name;
        this.description=description;
        this.image=image;
        this.caption=caption;
        this.link=link;
        this.latitude=latitude;
        this.longtitude=longtitude;
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
