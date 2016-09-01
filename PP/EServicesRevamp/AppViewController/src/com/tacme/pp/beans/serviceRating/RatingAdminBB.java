package com.tacme.pp.beans.serviceRating;

import com.tacme.pp.common.utils.ADFUtils;

import javax.faces.event.ActionEvent;

public class RatingAdminBB {
    public RatingAdminBB() {
    }

    public void printChart(ActionEvent actionEvent) {
        
        System.out.println(actionEvent.getComponent().getAttributes().get("chartId"));
     //   ADFUtils.printDVTComponent((String)actionEvent.getComponent().getAttributes().get("chartId"));
        // Add event code here...
    }
}
