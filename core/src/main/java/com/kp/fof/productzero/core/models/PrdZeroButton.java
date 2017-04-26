package com.kp.fof.productzero.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

@Model(adaptables=Resource.class)
public class PrdZeroButton {
	
	private String title="";
	private String link="";

    @PostConstruct
    protected void init() {
    	title = "GO";
        link = "https://www.google.com";
    }

    public String getTitle() {
        return title;
    }
    
    public String getLink() {
        return link;
    }

}
