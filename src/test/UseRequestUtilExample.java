package test;

import javax.servlet.http.Cookie;
import org.apache.catalina.util.RequestUtil;

public class UseRequestUtilExample {
  public static void main(String[] args) {
    Cookie cookie = new Cookie("user", "cindy");
    cookie.setDomain("brainysoftware.com");
    cookie.setPath("/commerce");
    cookie.setMaxAge(600); // 10 minutes
    cookie.setComment("This is an authorized user.");

    String encodedCookie = RequestUtil.encodeCookie(cookie);
    System.out.println(encodedCookie);

  }
}