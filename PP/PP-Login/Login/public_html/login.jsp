<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.ResourceBundle"%>
<%@ page language="java" import="java.util.*"%>
<%@ page import="java.io.File"%>
<%@ page import="java.net.*"%>
<%

  response.setHeader("Cache-Control", "no-cache, no-store");
  response.setHeader("Pragma", "no-cache");
  response.setHeader("Expires", "0");
  response.setContentType("text/html; charset=UTF-8");
//  

ResourceBundle envBundle = ResourceBundle.getBundle("com.pp.tacme.login.view.EnviromentVars");
String portalUrl = envBundle.getString("PORTAL-URL");
String assetsUrl = envBundle.getString("portal-assets-url");
    String requestId=request.getParameter("request_id");
  String locale="ar";
    if(requestId==null || requestId.equals("")){
    //    response.sendRedirect(portalUrl);
    }
  //this is the default Locale

  Cookie[] cookies = request.getCookies();
  if(cookies != null){
  for(Cookie cookie : cookies){
    if("pp-locale".equals(cookie.getName())){
        locale = cookie.getValue();
        break;
    }
}
  }


java.util.Locale myLocale = (java.util.Locale) new Locale(locale);
  final String language = myLocale.getLanguage();
  
  final String textDirection = ("ar".equalsIgnoreCase(language) ||
              "he".equalsIgnoreCase(language) ||
              "iw".equalsIgnoreCase(language)) ? "rtl" : "ltr";
  final String cssPrefix = "ltr".equalsIgnoreCase(textDirection)?"":"_rtl" ;
    String activeAR="";
    String activeEN="";
    ResourceBundle msgBundle=null;
    if("fr".equalsIgnoreCase(language)){
        msgBundle  = ResourceBundle.getBundle("com.pp.tacme.login.view.LoginMsgs");
    activeAR="";
    activeEN="active";
   } else if("ar".equalsIgnoreCase(language)){
        msgBundle  = ResourceBundle.getBundle("com.pp.tacme.login.view.LoginMsgs_ar");
      activeEN="";
    activeAR="active";
        }
    else
        msgBundle  = ResourceBundle.getBundle("com.pp.tacme.login.view.LoginMsgs");

String reqId = "";
reqId=request.getParameter("request_id");
String errorMsg="";
String errorCode=request.getParameter("p_error_code");
if(errorCode!=null){
errorMsg=msgBundle.getString(errorCode);
}


%>
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta http-equiv="pragma" content="no-cache"></meta>
  <meta http-equiv="cache-control" content="no-cache"></meta>
  <meta http-equiv="expires" content="0"></meta>
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"></meta>
  <meta http-equiv="description" content="This is my page"></meta>
  <meta name="viewport" content="width=1000"></meta>
  <title>
   <%=msgBundle.getString("loginHeader")%>
  </title>
  <%  if("en".equalsIgnoreCase(language))
   {
   %>
  <link rel="stylesheet" href="<%=assetsUrl%>/css/customStyle.css"></link>
  <%
   }else
    {
    %>
  <link rel="stylesheet" href="<%=assetsUrl%>/css/customStyle.css"></link>
  <link rel="stylesheet" href="<%=assetsUrl%>/css/customStyle_ar.css"></link>
  <%
    }
    %>
  <script src="<%=assetsUrl%>/js/jquery-1.7.1.min.js" type="text/javascript"/>

  <link rel="stylesheet" type="text/css" afrres="true"
        href="<%=assetsUrl%>/css/customStyle.css"/>
  <link rel="stylesheet" type="text/css" afrres="true"
        href="<%=assetsUrl%>/css/slider.css"/>
  <link rel="stylesheet" type="text/css" afrres="true"
        href="<%=assetsUrl%>/css/responsive.css"/>
  <link rel="stylesheet" type="text/css" afrres="true"
        href="<%=assetsUrl%>/css/font-awesome.min.css"/>
  <script type="text/javascript" language="javascript">
    var locale = 'en'
  </script>
  <style> 
  .x10x.p_AFHighlighted.x117 .x11a {
             background-color: #e7f0f7;
             border-top: thin solid #c0c8cf;
             border-bottom: thin solid #c0c8cf;
             border-left: thin solid #c0c8cf;
         }
         body{ margin:0px;}
         .x10x.p_AFHighlighted.x117 .x11b {
             background-color: #e7f0f7;
             border-top: thin solid #c0c8cf;
             border-bottom: thin solid #c0c8cf;
         }
         .x10x.p_AFHighlighted.x117 .x11c {
             background-color: #e7f0f7;
             border-top: thin solid #c0c8cf;
             border-bottom: thin solid #c0c8cf;
             border-right: thin solid #c0c8cf;
         }
          .x10x.x117 .x11a {
             border-left: thin solid #FFFFFF;
         }

         .x10x.x117 .x11c {
             border-right: thin solid #FFFFFF;
         }
         .login-box {   display:block; margin: auto; float:left; width:100%;}
         .login-box form{ margin: auto; width:376px; border:1px solid #cbba81; padding: 15px 28px; border-radius:5px;  }
         .login-box .section_title { text-align: center; font-size: 26px; margin-bottom:2px;  padding: 15px; 20px; }
          .login-box .login-field{ margin-bottom:20px;}
          .login-box .login-field label{ font-size:16px; color:#af2222 !important; line-height: 29px;vertical-align: bottom;}
          .login-box .login-field input{ width:318px !important; height:34px; border: 1px solid #b0a37c; color: #734708 !important;     border-radius: 5px;}
          .login-box .login-field #PersistentLogin{  width: 39px !important; height: 20px;}
          .login-box .login-checkbox-label{ font-size: 16px; font-weight: 200;}
          .button-holder{ text-align: center;}
          .button-holder input{ display: inline-block;  margin-bottom: 0; text-align: center; vertical-align: middle;  cursor: pointer;  white-space: nowrap; -webkit-user-select: none;  -moz-user-select: none; -ms-user-select: none;
    -o-user-select: none;
    user-select: none;
    color: #ffffff;
    -webkit-border-radius: 3px;
    -moz-border-radius: 3px;
    -ms-border-radius: 3px;
    -o-border-radius: 3px;
    -khtml-border-radius: 3px;
    border-radius: 3px;
    background-color: #af2222;
    background-image: none;
    font-size: 16px;
    line-height: 6px;
    padding: 15px 10px 15px 10px;
    margin: 15px 0px 15px 0px;
    width: 200px;
    border: 0px none;
    }
    .golden .button-holder input{  background-color: #A47D47;}
    .green .button-holder input{  background-color: #0C874F ;}
         
          .login_error{  width: 100%; font-size: 12px; float: left; color:red;}
		  .oam_error{  width: 100%; font-size: 12px; float: left; color:red;}
          label.mandtry:after{content:"*"; color:red; font-size: 12px; position:absolute;}
          ul li {list-style: none;}
          .social-footer-icons a, .footer-social-icons .af_goImageLink{ text-decoration: none !important;}
          .copyrightText {
            color: #45423d !important;
            text-align: center !important;
            font-size: 12px !important;
            font-weight: normal;
        }
        .content-main {
                display: block;
            float: left;
            padding-bottom:3px;
                margin: 2% auto;
        }
        .socialholder{ text-align:center; }
         </style>
 </head>
 <body>
  <div id="afr::DocWrapper">
   <div id="docrt">
    <a style="display: none;" id="docrt::skip" href="#"
       class="af_document_skip-link">Skip to content</a>
     
    <link href="<%=assetsUrl%>/images/favicon.ico" rel="shortcut icon"
          type="image/x-icon"></link>
     
    <link href="<%=assetsUrl%>/images/favicon.gif" rel="icon" type="image/gif"></link>
     
    <link href="<%=assetsUrl%>/images/favicon.png" rel="icon" type="image/png"></link>
     
    <meta content="width=device-width, initial-scale=1, user-scalable=no"
          name="viewport"></meta>
    <div id="T:mainTempBody" class="Main-Wrapper af_panelGroupLayout"
         style="width:100%;height:100%;overflow:auto;">
     <div>
      <div id="T:pt_pgl5" class="VTOH af_panelGroupLayout">
       <div>
        <div id="T:pt_pbl1" class="global-container af_panelGroupLayout"
             style="margin:0px auto;">
         <div>
          <div id="T:header" class="headerWraper af_panelGroupLayout"></div>
          <div>
           <div id="T:pt_pgl1" class="headerSection af_panelGroupLayout">
            <div>
             <div id="T:pt_pgl1sub"
                  class="headerContainer af_panelGroupLayout login-header">
              <div>
               <ul class="header-list">
                <li>
                 <a href="<%=assetsUrl%>/webcenter/">
                  <img src="<%=assetsUrl%>/images//main_logo.png"></img></a>
                </li>
                 
                <li>
                 <a href="#">
                  <img src="<%=assetsUrl%>/images//pp_textlogo1.png"></img></a>
                </li>
               </ul>
              </div>
             </div>
            </div>
           </div>
          </div>
          <div>
           <span id="T:contentContainer"
                 class="content-main af_panelGroupLayout">
            <div class="login-box">
             <form id="login_form" action='<%=envBundle.getString("OAM-URL")%>'
               onsubmit="return validateForm()"    method="post" class="loginForm">
              <div class="box_body">
               <div class="section_title">
                <%=msgBundle.getString("loginHeader")%>
               </div>
               <input type="hidden" name="successurl"
                      value='<%=envBundle.getString("PORTAL-URL")%>'/>
                
               <span id="expireTitle" style="display:none;" class="hidden">
                <%=msgBundle.getString("expireTitle")%></span>
                
               <span id="expireMessage" style="display:none;" class="hidden">
                <%=msgBundle.getString("expireMessage")%></span>
                
               <span id="expireButton" style="display:none;" class="hidden">
                <%=msgBundle.getString("expireButton")%></span>
                
               <span id="portalUrl" style="display:none;" class="hidden">login.jsp</span>
               <div class="login-field">
                <label class="login_label mandtry">
                 <%=msgBundle.getString("userName")%>
                </label>
                 
                <!--<input class="input_login required msisdn" type="text" name="j_username" value="">-->
                 
                <input type="text" name="username" id="username"
                       class="msisdn input_login required" maxlength="40"></input>
               </div>
               <div class="login-field">
                <label class="login_label mandtry">
                 <%=msgBundle.getString("password")%>
                </label>
                 
                <!-- <input class="input_login required" type="password" name="j_password" autocomplete="off"> -->
                 
                <input type="password" name="password" id="password"
                       class="input_login required" autocomplete="off"></input>
               </div>
               <div class="login-field">
                <label class="login_label login-checkbox-label">
                 <%=msgBundle.getString("RememberMe")%>
                </label>
                 
                <input type="checkbox" name="PersistentLogin"
                       id="PersistentLogin" value="true"/>
               </div>
               <input type="hidden" name="request_id" value="<%=reqId%>"/>
                
               <label class="login_error" style="display:none;"><%=msgBundle.getString("form-error-7")%></label>
			   <label class="oam_error" ><%=errorMsg%></label>
				
               <div class="button-holder">
                <input type="submit" value='<%=msgBundle.getString("login")%>'
                       class="submit-button btn-action"></input>
               </div>
               <div id="blok-login-link">
                <br></br>

               </div>
              </div>
             </form>
            </div></span>
          </div>
          <div>
           <span id="T:footerContainer"
                 class="footer-main login-footer af_panelGroupLayout">
            <span id="T:pt_pgl7" class="footer-wrap af_panelGroupLayout">
             <span id="T:footerfirstRow"
                   class="footer-first-row af_panelGroupLayout">
              <span id="T:helplineBlock"
                    class="footer-helpline-block af_panelGroupLayout">
               <div id="T:helpline-wrap" class="af_panelGroupLayout">
                <div>
                 <ul class="footer-first-insed">
                  <li>
                   <span class="fa fa-headphones"></span>
                  </li>
                   
                  <li>
                   <div class="footer-call-icon">
                    <img src="<%=assetsUrl%>/images/icon-phone.png"></img>
                   </div>
                   <div class="footer-call-icon-txt" >
                    <span class="hotline-text">
                     <%=msgBundle.getString("hotline-text")%></span>
                     
                    <span class="hotline-number">
                     <%=msgBundle.getString("hotline-number")%></span>
                   </div>
                   <span class="hotline-description">
                    <%=msgBundle.getString("hotline-description")%></span>
                  </li>
                 </ul>
                </div>
               </div></span><span id="T:disclimerBlock"
                                  class="footer-desclimer-block af_panelGroupLayout"> 
               <div id="T:desclimer-wrap" class="af_panelGroupLayout">
                <div>
                 <div id="T:pt_pgl8"
                      class="AFStretchWidth footer-copyright af_panelGroupLayout"
                      align="center">
                  <div>
                   <div id="T:pt_pgl22"
                        class="VTOH footer-copyright-text af_panelGroupLayout"
                        style="padding: 15px 0 0px 0;">
                    <div>
                     <span class="copyrightText">
                      <%=msgBundle.getString("last-updated")%></span>
                    </div>
                    <div>
                     <span class="copyrightText">
                      <%=msgBundle.getString("screen-resolution")%></span>
                    </div>
                   </div>
                  </div>
                  <div>
                   <div id="T:pt_pgl23"
                        class="footer-supported-text af_panelGroupLayout"
                        align="center">
                    <div>
                     <span class="copyrightText">
                      <%=msgBundle.getString("browser-support")%></span>
                    </div>
                   </div>
                  </div>
                  <div>
                   <span id="T:pt_pfl2"
                         class="AFStretchWidth footerLinkSocial af_panelGroupLayout">
                    <div id="T:sdf_for_oc_7993975121region1"
                         class="af_showDetailFrame">
                     <div class="af_showDetailFrame_container p_AFMedium">
                      <div id="T:sdf_for_oc_7993975121region1::div2"
                           class="af_showDetailFrame_content p_AFMedium">
                       <div id="T:oc_7993975121region1" class="af_region">
                        <span id="T:oc_7993975121region1:pgl1"
                              class="af_panelGroupLayout">
                         <div id="T:oc_7993975121region1:pc1"
                              class="af_panelCustomizable">
                          <div id="T:oc_7993975121region1:pc1::content">
                           <div>
                            <span id="T:oc_7993975121region1:j_id__ctru2pc21"
                                  class="af_panelGroupLayout">
                             <span id="T:oc_7993975121region1:panelGroupLayout1"
                                   class="footer-nav af_panelGroupLayout">
                              <ul id="pl1">
                               <li class="nav-parent no-children">
                                <a id="T:oc_7993975121region1:pt_gl3m"
                                   class="af_goLink"
                                   href="<%=assetsUrl%>/webcenter/portal/pp/footerLinks/page1">
                                 <%=msgBundle.getString("link-sitemap")%></a>
                               </li>
                                
                               <li class="nav-parent no-children">
                                <a id="T:oc_7993975121region1:pt_gl3mj_id_13"
                                   class="af_goLink"
                                   href="<%=assetsUrl%>/webcenter/portal/pp/footerLinks/page1473?_adf.ctrl-state=16zoorllsk_247&wc.contextURL%3D%2Fspaces%2Fpp%26leftWidth%3D0%25%26showFooter%3Dfalse%26showHeader%3Dfalse%26rightWidth%3D0%25%26centerWidth%3D100%25">
                                 <%=msgBundle.getString("link-contactus")%></a>
                               </li>
                                
                               <li class="nav-parent no-children">
                                <a id="T:oc_7993975121region1:pt_gl3mj_id_14"
                                   class="af_goLink"
                                   href="<%=assetsUrl%>/webcenter/portal/pp/footerLinks/page138?_adf.ctrl-state=16zoorllsk_247&wc.contextURL%3D%2Fspaces%2Fpp%26leftWidth%3D0%25%26showFooter%3Dfalse%26showHeader%3Dfalse%26rightWidth%3D0%25%26centerWidth%3D100%25">
                                 <%=msgBundle.getString("link-terms")%></a>
                               </li>
                                
                              
                              </ul></span></span>
                           </div>
                          </div>
                         </div></span>
                       </div>
                      </div>
                     </div>
                    </div></span>
                  </div>
                 </div>
                </div>
               </div>
                </span><a id="T:oc_7993975121region1:_afrCommandDelegate"
                          class="af_commandLink" onclick="return false;"
                          href="#"> 
               <span id="T:firstCell"
                     class="first-footer-cell af_panelGroupLayout"> </span>
                </a>
              <div id="T:pt_pgl9" class="af_panelGroupLayout first-footer-cell">
               <a id="T:oc_7993975121region1:_afrCommandDelegate"
                  class="af_commandLink" onclick="return false;" href="#">
                <div>
                 <div id="T:pt_pgl10" class="contact-title af_panelGroupLayout">
                  <div>
                   <span class="FooterLinkHeading">
                    <%=msgBundle.getString("connect-with-us")%></span>
                  </div>
                 </div>
                </div></a>
                <div class="socialholder">
               <div class="footer-social-icons">
                <a id="T:oc_7993975121region1:_afrCommandDelegate"
                   class="af_commandLink" onclick="return false;" href="#">
                 <span id="T:pt_pgl11"
                       class="HTOV social-footer-icons af_panelGroupLayout"></span></a><a id="T:pt_i14"
                                                                                          class="af_goImageLink"
                                                                                          href="https://www.facebook.com/uaepublicprosecution"
                                                                                          target="_blank"> 
                 <img id="T:pt_i14::icon" src="<%=assetsUrl%>/images//fb.png"
                      class="af_goImageLink_image"></img>
                  </a><a id="T:pt_i2" class="af_goImageLink"
                         href="https://twitter.com/UAE_PP" target="_blank"> 
                 <img id="T:pt_i2::icon" src="<%=assetsUrl%>/images//tw.png"
                      class="af_goImageLink_image"></img>
                  </a><a id="T:pt_i16" class="af_goImageLink"
                         href="https://www.blogger.com/" target="_blank"> 
                 <img id="T:pt_i16::icon" src="<%=assetsUrl%>/images//bing.png"
                      class="af_goImageLink_image"></img>
                  </a><a id="T:pt_i13" class="af_goImageLink"
                         href="https://www.youtube.com/" target="_blank"> 
                 <img id="T:pt_i13::icon"
                      src="<%=assetsUrl%>/images//youtube.png"
                      class="af_goImageLink_image"></img>
                  </a>
               </div> </div>
               <div> 
                <div id="T:pt_pgl13" class="af_panelGroupLayout"></div>
               </div>
               <div>
                <div id="T:pt_pgl15"
                     class="addonslink-text af_panelGroupLayout">
                 <div>
                  <%=msgBundle.getString("Add-Ons")%>
                 </div>
                </div>
               </div>
               <div class="socialholder">
                <span id="T:pt_pgl14"
                      class="HTOV social-footer-icons af_panelGroupLayout">
                 <a id="T:pt_i17" class="af_goImageLink"
                    href="https://get.adobe.com/flashplayer" target="_blank">
                  <img id="T:pt_i17::icon"
                       src="<%=assetsUrl%>/images//flash.png"
                       class="af_goImageLink_image"></img></a><a id="T:pt_i21"
                                                                 class="af_goImageLink"
                                                                 href="http://www.microsoftstore.com/store/msgulf/ar_EG/cat/Office/categoryID.67939100?icid=All_Office_subnav_22092015_O365"
                                                                 target="_blank"> 
                  <img id="T:pt_i21::icon"
                       src="<%=assetsUrl%>/images//msword.png"
                       class="af_goImageLink_image"></img>
                   </a><a id="T:pt_i18" class="af_goImageLink"
                          href="http://www.microsoftstore.com/store/msgulf/ar_EG/cat/Office/categoryID.67939100?icid=All_Office_subnav_22092015_O365"
                          target="_blank"> 
                  <img id="T:pt_i18::icon"
                       src="<%=assetsUrl%>/images//excel.png"
                       class="af_goImageLink_image"></img>
                   </a><a id="T:pt_i19" class="af_goImageLink"
                          href="http://www.adobe.com/" target="_blank"> 
                  <img id="T:pt_i19::icon"
                       src="<%=assetsUrl%>/images//adobe.png"
                       class="af_goImageLink_image"></img>
                   </a><a id="T:pt_i20" class="af_goImageLink"
                          href="http://java.com/en/" target="_blank">
                  <img id="T:pt_i20::icon" src="<%=assetsUrl%>/images//java.png"
                       class="af_goImageLink_image"></img></a></span>
               </div>
              </div></span></span></span>
          </div>
         </div>
        </div>
       </div>
      </div>
     </div>
    </div>
   </div>
  </div>
  <script src="<%=assetsUrl%>/js/caroufredsel-carousel.js"
          type="text/javascript"/>


  <script src="<%=assetsUrl%>/js/jquery.film_roll.js" type="text/javascript"/>

  <script src="<%=assetsUrl%>/js/jquery.bxslider.js" type="text/javascript"/>

  <script src="<%=assetsUrl%>/js/jquery.touchSwipe.min.js" type="text/javascript"/>

  <script src="<%=assetsUrl%>/fancybox/jquery.fancybox.js"
          type="text/javascript"/>

  <script src="<%=assetsUrl%>/fancybox/jquery.fancybox.pack.js"
          type="text/javascript"/>

  <script src="<%=assetsUrl%>/js/comman_script.js" type="text/javascript"/>


 
  function validateForm(){ 
  var username= $("#username").val();
  var password=$("#password").val();
   errorLogin=0;
  if(username == "" || password ==""){ 
      errorLogin=1;
	   $(".login_error").show();
      return false;
  }
else{
      $(".login_error").hide();  
    errorLogin = 0;
    return true;
    }

    });
  </script>
 </body>
</html>