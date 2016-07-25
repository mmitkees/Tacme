package com.app.view.beans;

import com.app.view.utils.JSFUtils;

import java.io.Serializable;

public class testLocale implements Serializable{
    @SuppressWarnings("compatibility:7144306135959830278")
    private static final long serialVersionUID = 1L;

    public testLocale() {
    }

    public String showInEnglish() {
        System.out.println(JSFUtils.resolveExpression("#{sessionScope.locale}"));
        // Add event code here...
        return null;
    }
}
