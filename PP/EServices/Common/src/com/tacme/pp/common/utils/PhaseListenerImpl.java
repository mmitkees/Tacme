package com.tacme.pp.common.utils;

import java.util.Locale;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class PhaseListenerImpl implements PhaseListener {
    public PhaseListenerImpl() {
        super();
    }

    public void afterPhase(PhaseEvent phaseEvent) {
    }

    public void beforePhase(PhaseEvent phaseEvent) {
        String locale;
        locale = (String)JSFUtils.getFromSession("locale");
        if(locale!=null)
        phaseEvent.getFacesContext().getViewRoot().setLocale(new Locale(locale));
    }

    public PhaseId getPhaseId() {
        return null;
    }
}
