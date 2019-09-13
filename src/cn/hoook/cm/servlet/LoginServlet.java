package cn.hoook.cm.servlet;


import cn.hoook.util.ValidateUtil.ValidateUtils;
import cn.hoook.util.servlet.DispatcherServlet;
import cn.hoook.util.vo.LoginDao;

import java.io.IOException;


public class LoginServlet extends DispatcherServlet {
    public void login()  {
        String mid = super.request.getParameter("mid");
        String password = super.request.getParameter("password");
        if (ValidateUtils.validateEmpty(mid)&&ValidateUtils.validateEmpty(password)){
            System.out.println(password);//jiayancaozuo meixie
            if (mid != null){
                try {
                if (LoginDao.checkLogin(mid,password)){
                    request.setAttribute("mid",mid);
                        super.response.getWriter().print("success");
                }else{
                    super.response.getWriter().print("error");
                }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
