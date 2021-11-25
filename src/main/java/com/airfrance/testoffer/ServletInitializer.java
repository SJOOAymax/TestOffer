package com.airfrance.testoffer;


import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SessionTrackingMode;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(TestOfferApplication.class);
  }

  @Override
  public void onStartup(ServletContext servletContext)
      throws ServletException {
    servletContext.getSessionCookieConfig().setHttpOnly(true);
    final Set<SessionTrackingMode> sessionTrackingModes = new HashSet<>();
    sessionTrackingModes.add(SessionTrackingMode.COOKIE);
    servletContext.setSessionTrackingModes(sessionTrackingModes);
    super.onStartup(servletContext);
  }

}
