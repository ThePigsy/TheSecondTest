package com.ricky.dubbo.consumer;

import java.util.HashMap;
import java.util.Map;

import com.ricky.dubbo.api.model.User;
import com.ricky.dubbo.api.Nofify;

class NofifyImpl implements Nofify {
    public Map<Long, User>    ret    = new HashMap<Long, User>();
    public Map<Long, Throwable> errors = new HashMap<Long, Throwable>();
    
    public void onreturn(User msg, Long id) {
        System.out.println("onreturn:" + msg);
        ret.put(id, msg);
    }
    
    public void onthrow(Throwable ex, Long id) {
        errors.put(id, ex);
    }
}