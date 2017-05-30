package config;


import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.jsp.jstl.core.Config;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  public WebInitializer() {
  }

  protected WebApplicationContext createServletApplicationContext() {
    AnnotationConfigWebApplicationContext cfg = new AnnotationConfigWebApplicationContext();
    cfg.register(new Class[]{Config.class});
    cfg.register(SecurityConfig.class);
    return cfg;
  }

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[0];
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[0];
  }


  protected String[] getServletMappings() {
    return new String[]{"/"};
  }

  protected WebApplicationContext createRootApplicationContext() {
    AnnotationConfigWebApplicationContext cfg = new AnnotationConfigWebApplicationContext();
    cfg.register(new Class[]{RootConfig.class});
    cfg.register(SecurityConfig.class);
    return cfg;
  }
}
