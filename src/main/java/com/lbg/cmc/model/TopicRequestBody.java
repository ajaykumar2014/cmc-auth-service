package com.lbg.cmc.model;

import java.io.Serializable;

public class TopicRequestBody implements Serializable {

    public TopicRequestBody(String topic_name) {
        this.topic_name = topic_name;
    }

    private String topic_name;

    public String getTopic_name() {
        return topic_name;
    }

    public void setTopic_name(String topic_name) {
        this.topic_name = topic_name;
    }
}
