package com.ricky.dubbo.api;

import com.ricky.dubbo.api.model.User;

public interface DemoService {

    public String sayHello(String name);

    public User findUserById(long id);
    
    public String test(Object obj);
    
    public String testAsync(String input);
}