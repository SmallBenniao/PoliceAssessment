package com.police.assessment.policeassessment.bean;

import java.io.Serializable;
import java.util.List;

public class QuestionBean implements Serializable{

    private int type;
    private String title;

    private List<String> options;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
