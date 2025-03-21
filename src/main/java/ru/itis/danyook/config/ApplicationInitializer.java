package ru.itis.danyook.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) {


        AnnotationConfigWebApplicationContext springWebContext = new AnnotationConfigWebApplicationContext();
        springWebContext.register(WebMvcConfig.class);
        springWebContext.register(DataBaseConfig.class);
        servletContext.addListener(new ContextLoaderListener(springWebContext));
        ServletRegistration.Dynamic dispatcherServlet =
                servletContext.addServlet("dispatcher", new DispatcherServlet(springWebContext));
        dispatcherServlet.setLoadOnStartup(1);
        dispatcherServlet.addMapping("/");


    }

}

