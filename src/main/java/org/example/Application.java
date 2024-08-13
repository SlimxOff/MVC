package org.example;

import org.example.config.WebConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

public class Application {
    public static void main(String[] args) throws LifecycleException {
        // Создание и настройка Spring Context
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);
        context.refresh();

        // Создание и настройка Tomcat
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        File base = new File(System.getProperty("java.io.tmpdir"));
        Context rootCtx = tomcat.addContext("/", base.getAbsolutePath());

        // Создание и настройка DispatcherServlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        Tomcat.addServlet(rootCtx, "dispatcher", dispatcherServlet).setLoadOnStartup(1);
        rootCtx.addServletMappingDecoded("/", "dispatcher");

        // Запуск Tomcat
        tomcat.start();
        tomcat.getServer().await();
    }
}