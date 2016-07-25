<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://xmlns.oracle.com/adf/faces/rich" prefix="af"%>
<f:view>
  <af:document id="d1">
  <%--<af:resource type="javascript"
               source="http://demoserver.tacme.net:12127/js/jquery-1.7.1.min.js"/>--%>
  <%--<af:resource type="javascript"
               source="http://demoserver.tacme.net:12127/js/jquery.simplemodal.js"/>--%>               
    <af:messages id="m1"/>
    <af:form id="f1" usesUpload="true">
      <af:panelStretchLayout id="psl1" topHeight="50px" startWidth="40px"
                             endWidth="105px">
        <f:facet name="bottom"/>
        <f:facet name="center">
          <af:region value="#{bindings.VisitProvDetTFDef1.regionModel}"
                     id="r1"/>
        </f:facet>
        <f:facet name="top">
          <af:panelGroupLayout layout="scroll"
                               xmlns:af="http://xmlns.oracle.com/adf/faces/rich"
                               id="pgl2">
            <%--<af:image source="/new home.PNG" id="i1"/>--%>
            <af:panelGroupLayout layout="scroll"
                                 xmlns:af="http://xmlns.oracle.com/adf/faces/rich"
                                 id="pgl1">
              <%--<af:selectOneChoice label="Select language" autoSubmit="true"
                                  value="#{localeBean.language}" id="soc1"
                                  valueChangeListener="#{localeBean.SelectLang}">
                <af:selectItem label="Arabic" value="ar" id="si2"/>
                <af:selectItem label="English" value="en" id="si1"/>
              </af:selectOneChoice>--%>
            </af:panelGroupLayout>
          </af:panelGroupLayout>
        </f:facet>
      </af:panelStretchLayout>
      <af:panelFormLayout id="pfl1" rendered="false">
    <!--    <af:inputText value="#{bindings.un.inputValue}"
                      label="#{bindings.un.hints.label}"
                      required="#{bindings.un.hints.mandatory}"
                      columns="#{bindings.un.hints.displayWidth}"
                      maximumLength="#{bindings.un.hints.precision}"
                      shortDesc="#{bindings.un.hints.tooltip}" id="it1">
          <f:validator binding="#{bindings.un.validator}"/>
        </af:inputText>
        <af:inputText value="#{bindings.pwrd.inputValue}"
                      label="#{bindings.pwrd.hints.label}"
                      required="#{bindings.pwrd.hints.mandatory}"
                      columns="#{bindings.pwrd.hints.displayWidth}"
                      maximumLength="#{bindings.pwrd.hints.precision}"
                      shortDesc="#{bindings.pwrd.hints.tooltip}" id="it2">
          <f:validator binding="#{bindings.pwrd.validator}"/>
        </af:inputText>
        <af:commandButton actionListener="#{bindings.login_db.execute}"
                          text="login_db"
                          disabled="#{!bindings.login_db.enabled}" id="cb1"/> -->
      </af:panelFormLayout>
    </af:form>
  </af:document>
</f:view>