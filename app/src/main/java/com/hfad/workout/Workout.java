package com.hfad.workout;
public class Workout {
    private Integer name;
    private Integer description;
    private Integer image;
    private Integer caption;
    private Integer link;

    private String convertedName;
    private String convertedName2;
    private Integer test;

    public static final Workout[] workouts = {
            new Workout(R.string.CIS,
                    R.string.CIS_text,
                    R.drawable.cis,
                    R.string.CIS_caption,
                    R.string.CIS_link
                    ),
            new Workout(R.string.Bear,
                    R.string.Bear_text,
                    R.drawable.cis,
                    R.string.Bear_caption,
                    R.string.Bear_link
                    ),
            new Workout(R.string.Dobo,
                    R.string.Dobo_text,
                    R.drawable.cis,
                    R.string.Dobo_caption,
                    R.string.Dobo_link
                     ),
            new Workout(R.string.Cameron,
                  R.string.Cameron_text,
                  R.drawable.cameron,
                  R.string.Cameron_caption,
                  R.string.Cameron_link),

            new Workout(R.string.Deloach,
                    R.string.Deloach_text,
                    R.drawable.deloach,
                    R.string.Deloach_caption,
                    R.string.Deloach_link),
    };
    //Each Workout has a name and description
    private Workout(Integer name, Integer description, Integer image, Integer caption, Integer link) {
        this.name = name;
        this.description = description;
        this.image=image;
        this.caption=caption;
        this.link=link;

    }
    public Integer getDescription() {

        return description;
    }
    public Integer getName() {
        return name;
    }
    public Integer getImage() {
        return image;
    }
    public Integer getCaption() {
        return caption;
    }
    public Integer getLink() {
        return link;
    }


}