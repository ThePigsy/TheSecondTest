package com.ricky.dubbo.consumer;

import java.util.concurrent.Future;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.EchoService;
import com.ricky.dubbo.api.DemoService;
import com.ricky.dubbo.api.model.User;

/**
 * Dubbo Consumer client
 *
 */
public class ConsumerApp {

    public static void main(String[] args) throws Exception {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "consumer.xml" }, ConsumerApp.class);
        context.start();

        DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理
        String hello = demoService.sayHello("ricky"); // 执行远程方法
        System.out.println(hello); // 显示调用结果

        User user = demoService.findUserById(15);
        System.out.println(user); // 显示调用结果
        
//      回声测试
        EchoService echoService = (EchoService) demoService; // 强制转型为EchoService
        Object status = echoService.$echo("OK"); // 回声测试可用性
        System.out.println("status : " + status + "; " + status.getClass().getName());
        
        
		//        上下文信息
		//xxxService.xxx(); // 远程调用
		boolean isConsumerSide = RpcContext.getContext().isConsumerSide(); // 本端是否为消费端，这里会返回true
		String serverIP = RpcContext.getContext().getRemoteHost(); // 获取最后一次调用的提供方IP地址
		String application = RpcContext.getContext().getUrl().getParameter("application"); // 获取当前服务配置信息，所有配置信息都将转换为URL的参数
		
		System.out.println("isConsumerSide:" + isConsumerSide);
		System.out.println("serverIP:" + serverIP);
		System.out.println("application:" + application);
		

		RpcContext.getContext().setAttachment("index", "0311");
		demoService.test("1");
		// ...
		//yyyService.yyy(); // 注意：每发起RPC调用，上下文状态会变化
		
		isConsumerSide = RpcContext.getContext().isConsumerSide(); // 本端是否为消费端，这里会返回true
		serverIP = RpcContext.getContext().getRemoteHost(); // 获取最后一次调用的提供方IP地址
		application = RpcContext.getContext().getUrl().getParameter("application"); // 获取当前服务配置信息，所有配置信息都将转换为URL的参数
		
		System.out.println("isConsumerSide:" + isConsumerSide);
		System.out.println("serverIP:" + serverIP);
		System.out.println("application:" + application);
		
		
		System.out.println("\n\n---------------\n\n");
		
		String object = demoService.testAsync("Input of TestAsync"); // 此调用会立即返回null
		System.out.println(object);
		
		
		Future<String> fooFuture = RpcContext.getContext().getFuture(); // 拿到调用的Future引用，当结果返回后，会被通知和设置到此Future。
		System.out.println(fooFuture.get());
    }
}