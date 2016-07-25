package com.app.view.bundle;

import java.util.HashMap;
import java.util.Iterator;
import java.util.ListResourceBundle;
import java.util.Map;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;

import oracle.jbo.uicli.binding.JUCtrlActionBinding;

public class DatabaseResourceBundle extends ListResourceBundle {
    private Object[][] stored = null;
    private final String GENERIC_PAGEDEFINITION = "com_app_view_GenericPageDef";
    public DatabaseResourceBundle() {
        super();
    }
    
    protected Object[][] getContents() {
        if (stored == null) {
            initResourceBundle();
        }
        return stored;
    }

    /** synchronized initialization of reading resource bundle */
    private synchronized void initResourceBundle() {
        Map map = new HashMap();
        map = getResourceBundle(getLocaleCode());

        // copy all values from map in object array
        if (map.size() == 0) {
            stored = new Object[0][0];
        } else {
            Object[][] returnValue = new Object[map.size()][2];
            int ii = 0;
            for (Iterator keyIter = map.keySet().iterator(); keyIter.hasNext();
            ) {
                Object key = keyIter.next();
                returnValue[ii][0] = key;
                returnValue[ii][1] = map.get(key);
                ii++;
            }
            stored = returnValue;
        }
    }
    
    public String getLocaleCode() {
        return "en";
    }

    private Map getResourceBundle(String locale) {
        Map map = new HashMap();
        BindingContext bindingContext = BindingContext.getCurrent();
        if (bindingContext == null) {
            throw new RuntimeException("No ADFM Binding Context found!!");
        }
        DCBindingContainer container =
            bindingContext.findBindingContainer(GENERIC_PAGEDEFINITION);
        if (container != null) {
            JUCtrlActionBinding getResourceBundleBinding =
                (JUCtrlActionBinding)container.findCtrlBinding("getResourceBundle");
            getResourceBundleBinding.getParamsMap().put("locale", locale);              
            Object result = getResourceBundleBinding.execute();
            if (result instanceof Map) {
                map = (Map)result;
            }
        }        
        return map;
    }
}
