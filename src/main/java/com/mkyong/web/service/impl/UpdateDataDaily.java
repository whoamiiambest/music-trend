package com.mkyong.web.service.impl;

import java.util.TimeZone;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.mkyong.web.controller.HelloController;

public class UpdateDataDaily  extends DispatcherServlet {
    private static final long ONE_DAY_SECONDS = 24 * 60 * 60; // seconds in one day
    private static final long SLEEP_UPDATED_MILLISECOND = 5 * 60 * 1000; // milliseconds in 5 minutes

    /**
     *
     */
    private static final long serialVersionUID = 1L;


 // Define time zone
    TimeZone timeZone;

    HelloController hello = new HelloController();
    @Override
    protected WebApplicationContext initWebApplicationContext() {
        // Define application context when start server
        WebApplicationContext context = super.initWebApplicationContext();
        
        final HelloController bean1 = (HelloController) context.getBean("helloController");
        ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
        exec.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("aaaaaaaaaaaaaaa");
                int retryTime = 0;
                do {
                    try {
                        System.out.println("bbbbbbbbbbbbb");
                        bean1.updateData();
                        
                        break;
                     } catch (Exception e) {
                        try {
                            // Sleep 15 minutes = 900000 before retry update again
                            Thread.sleep(300);
                        } catch (InterruptedException e1) {
                            // Show error
                            e1.printStackTrace();
                        }
                    }
                    retryTime++;
                    System.out.println("Retry time = " + retryTime);
                } while (retryTime < 5);


            }
        }, 30, 90, TimeUnit.SECONDS); // Update database at midnight everyday
        return context;
    }
}