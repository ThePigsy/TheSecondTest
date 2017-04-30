package com.ricky.dubbo.consumer;

import java.io.IOException;
import java.util.concurrent.Future;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.rpc.RpcContext;
import com.ricky.dubbo.api.DemoService;
import com.ricky.dubbo.api.model.User;
/**
 * Dubbo Consumer client
 *
 */
public class ConsumerApp2 {

    public static void main(String[] args) throws Exception {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "consumer.xml" }, ConsumerApp2.class);
        context.start();

//        System.out.println("CurrentThread:" + Thread.currentThread().getName());
//        CallbackService callbackService = (CallbackService) context.getBean("callbackService"); // 获取远程服务代理
//        callbackService.addListener("http://10.20.160.198/wiki/display/dubbo/foo.bar", new CallbackListener(){
//            
//        	public void changed(String msg) {
//                System.out.println("callback1:" + msg + Thread.currentThread().getName());
//            }
//        	
//        });
        
        
        DemoService demoService = (DemoService) context.getBean("demoService2"); // 获取远程服务代理
//        NofifyImpl notify = (NofifyImpl) context.getBean("demoCallback");
        
        String hello = demoService.sayHello("ricky2"); // 执行远程方法
        System.out.println(hello); // 显示调用结果
      
        User user = demoService.findUserById(15);
        System.out.println(user); // 显示调用结果
        
        Future<User> future = RpcContext.getContext().getFuture();
        
        try {
            System.in.read();   // 按任意键退出
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}