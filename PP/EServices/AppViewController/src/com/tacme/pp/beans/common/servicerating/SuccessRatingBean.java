package com.tacme.pp.beans.common.servicerating;

import com.tacme.pp.common.utils.ADFUtils;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

import oracle.binding.OperationBinding;

public class SuccessRatingBean implements Serializable {
    public SuccessRatingBean() {
    }

    public void submitRecord(ActionEvent actionEvent) {
        System.out.println("--------------------");
        String param =
            (String)actionEvent.getComponent().getAttributes().get("rvalue");
        System.out.println(param);
        if(!param.equals(ADFUtils.getBoundAttributeValue("RatingKey"))){
        ADFUtils.setBoundAttributeValue("RatingKey", param);
      
        ADFUtils.findOperation("Commit").execute();
        System.out.println("--------------------");
        ADFUtils.addScriptOnPartialRequest("showThanks(" +param+
                                           ");");
        }
    }
}
