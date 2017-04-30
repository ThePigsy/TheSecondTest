package com.ricky.dubbo.provider.stub;

import com.ricky.dubbo.api.DemoService;
import com.ricky.dubbo.api.model.User;

public class DemoServiceStub implements DemoService {

	private DemoService demoService;
	
	public DemoServiceStub(DemoService demoService){
		this.demoService = demoService;
	}
    @Override
    public String sayHello(String name) {
    	System.out.println("DemoServiceStub : " + name);
    	return demoService.sayHello(name);
    }

    @Override
    public User findUserById(long id) {
    	System.out.println("DemoServiceStub...");
    	return demoService.findUserById(id);
    }
    
    @Override
    public String test(Object obj){
    	System.out.println("DemoServiceStub...");
    	return demoService.test(obj);
    }
    
    @Override
    public String testAsync(String input){
    	System.out.println("DemoServiceStub...");
    	return demoService.testAsync(input);
    }

}