package com.ricky.dubbo.provider.impl;

import java.util.concurrent.TimeUnit;

import com.alibaba.dubbo.rpc.RpcContext;
import com.ricky.dubbo.api.DemoService;
import com.ricky.dubbo.api.model.User;

public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

    @Override
    public User findUserById(long id) {

        User user = new User();
        user.setId(id);
        user.setName("Ricky");
        user.setAge(26);

        return user;
    }
    
    @Override
    public String test(Object obj){
    	 // 服务方法实现
        boolean isProviderSide = RpcContext.getContext().isProviderSide(); // 本端是否为提供端，这里会返回true
        String clientIP = RpcContext.getContext().getRemoteHost(); // 获取调用方IP地址
        String application = RpcContext.getContext().getUrl().getParameter("application"); // 获取当前服务配置信息，所有配置信息都将转换为URL的参数
        
        System.out.println("isProviderSide:" + isProviderSide);
		System.out.println("clientIP:" + clientIP);
		System.out.println("application:" + application);
		
		String value = RpcContext.getContext().getAttachment("index");
		System.out.println("value:" + value);
//        
//        // ...
//        yyyService.yyy(); // 注意：每发起RPC调用，上下文状态会变化
//        boolean isProviderSide = RpcContext.getContext().isProviderSide(); // 此时本端变成消费端，这里会返回false
		return "Okay";
    }
    
    @Override
    public String testAsync(String input){
    	try {
    		System.out.println("in testAsync method...");
			TimeUnit.SECONDS.sleep(12);
			System.out.println("be ready to exit testAsync method...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	return input + "---" + input;
    }

}