package cn.hoook.cm.factory;


import cn.hoook.cm.service.ILoginService;
import cn.hoook.cm.service.impl.ILoginServiceImpl;


public class ServiceFactory {
    public  static ILoginService getIMemberServiceInstance(){
        return new ILoginServiceImpl();
    }

}
