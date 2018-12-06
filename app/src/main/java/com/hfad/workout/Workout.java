//package com.hfad.workout;
//public class Workout {
//    private Integer name;
//    private Integer description;
//    private Integer image;
//    private Integer caption;
//    private Integer link;
//    private double latitude;
//    private double longitude;
//
//    public static final Workout[] workouts = {
//            new Workout(R.string.CIS,
//                    R.string.CIS_text,
//                    R.drawable.cis,
//                    R.string.CIS_caption,
//                    R.string.CIS_link,
//                    34.2261017,
//                    -77.87184949415777
//                    ),
//            new Workout(R.string.Bear,
//                    R.string.Bear_text,
//                    R.drawable.bear,
//                    R.string.Bear_caption,
//                    R.string.Bear_link,
//                    34.228545,
//                    -77.87280469680556
//                    ),
//            new Workout(R.string.Dobo,
//                    R.string.Dobo_text,
//                    R.drawable.dobo,
//                    R.string.Dobo_caption,
//                    R.string.Dobo_link,
//                    34.2257237,
//                    -77.86848956387306
//                     ),
//            new Workout(R.string.Cameron,
//                  R.string.Cameron_text,
//                  R.drawable.cameron,
//                  R.string.Cameron_caption,
//                  R.string.Cameron_link,
//                    34.226041800000004,
//                    -77.8695462604443
//            ),
//
//            new Workout(R.string.Deloach,
//                    R.string.Deloach_text,
//                    R.drawable.deloach,
//                    R.string.Deloach_caption,
//                    R.string.Deloach_link,
//                    34.228831799999995,
//                    -77.87445745000001
//            ),
//    };
//    //Each Workout has a name and description
//    private Workout(Integer name, Integer description, Integer image, Integer caption, Integer link, double latitude, double longitude) {
//        this.name = name;
//        this.description = description;
//        this.image=image;
//        this.caption=caption;
//        this.link=link;
//        this.latitude=latitude;
//        this.longitude=longitude;
//
//    }
//    public Integer getDescription() {
//
//        return description;
//    }
//    public Integer getName() {
//        return name;
//    }
//    public Integer getImage() {
//        return image;
//    }
//    public Integer getCaption() {
//        return caption;
//    }
//    public Integer getLink() {
//        return link;
//    }
//    public int getImageResourceId() {
//        return image;
//    }
//
//    public double getLatitude() {
//        return latitude;
//    }
//    public double getLongitude() {
//        return longitude;
//    }
//}