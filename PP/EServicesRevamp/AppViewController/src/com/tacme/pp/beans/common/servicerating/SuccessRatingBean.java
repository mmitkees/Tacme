package com.tacme.pp.beans.common.servicerating;

import com.tacme.pp.common.utils.ADFUtils;

import javax.faces.event.ActionEvent;

import oracle.binding.OperationBinding;

public class SuccessRatingBean {
    public SuccessRatingBean() {
    }

    public void submitRecord(ActionEvent actionEvent) {
        System.out.println("--------------------");
        String param =
            (String)actionEvent.getComponent().getAttributes().get("rvalue");
        System.out.println(param);
        ADFUtils.setBoundAttributeValue("RatingKey", param);
        
        ADFUtils.findOperation("Commit").execute();
        System.out.println("--------------------");
        ADFUtils.addScriptOnPartialRequest("showThanks(" +param+
                                           ");");
    }
}
