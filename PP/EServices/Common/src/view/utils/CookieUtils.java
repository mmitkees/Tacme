package view.utils;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * CookieUtils
 *
 */
public class CookieUtils {

    /**
     * Return a cookie given a particular key
     *
     * @param httpServletRequest Request
     * @param cookieKey Cookie key
     * @return <code>Cookie</code> of the requested key or <code>null</code> if no cookie
     * under that name is found
     */
    public static Cookie getCookie(HttpServletRequest httpServletRequest, String cookieKey) {
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies == null) {
            return null;
        }

        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            if (cookie.getName().equals(cookieKey)) {
                return cookie;
            }
        }

        return null;
    }

    /**
     * Add a cookie with a key and value to the response
     *
     * @param httpServletResponse Response
     * @param cookieKey Cookie key
     * @param cookieValue Cookie value
     */
    public static void addCookie(HttpServletResponse httpServletResponse,
                                  int cookieExpiration,
                                  String cookieKey,
                                  String cookieValue) {
        Cookie cookie = new Cookie(cookieKey, cookieValue);
        cookie.setMaxAge(cookieExpiration);
        cookie.setPath("/");
        httpServletResponse.addCookie(cookie);
    }
    
    
    public static String getCookie(String cookieKey) {
        HttpServletRequest request = JSFUtils.getRequest();
        Cookie cookie = getCookie(request, cookieKey);
        if(cookie != null)
            return cookie.getValue();
        return null;
    }
    
    public static void addCookie(String cookieKey, String cookieValue){
        HttpServletResponse response = JSFUtils.getResponse();
        addCookie(response, 365*24*60*60, cookieKey, cookieValue);
    }
}