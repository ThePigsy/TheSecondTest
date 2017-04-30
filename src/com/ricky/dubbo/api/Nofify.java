package com.ricky.dubbo.api;

import com.ricky.dubbo.api.model.User;

public interface Nofify {
    public void onreturn(User msg, Long id);
    public void onthrow(Throwable ex, Long id);
}