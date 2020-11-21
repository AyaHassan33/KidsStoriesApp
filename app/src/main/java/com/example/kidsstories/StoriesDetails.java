package com.example.kidsstories;

public class StoriesDetails {
    private int picture;
    private String storyName;
    private int imageStory;
    private String stories;

    public StoriesDetails(int picture, String storyName , int imageStory , String stories) {
        this.picture = picture;
        this.storyName = storyName;
        this.imageStory=imageStory;
        this.stories = stories;
    }

    public int getPicture() {
        return picture;
    }

    public String getStoryName() {
        return storyName;
    }

    public int getImageStory() {
        return imageStory;
    }

    public String getStories() {
        return stories;
    }
}
