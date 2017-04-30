package com.ricky.dubbo.provider;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ricky.dubbo.api.DemoService;
import com.ricky.dubbo.consumer.ConsumerApp;

/**
 * Dubbo provider
 *
 */
public class ProviderApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "provider.xml" }, ProviderApp.class);
        context.start();

        System.out.println("Dubbo provider start...");        
        

        try {
            System.in.read();   // 按任意键退出
        } catch (IOException e) {
            e.printStackTrace();
        } 
        

    }
}