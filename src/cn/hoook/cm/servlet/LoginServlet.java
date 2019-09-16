package cn.hoook.cm.servlet;


import cn.hoook.util.ValidateUtil.ValidateUtils;
import cn.hoook.util.md5.MD5Code;
import cn.hoook.util.servlet.DispatcherServlet;
import cn.hoook.util.vo.LoginDao;

import java.io.IOException;


public class LoginServlet extends DispatcherServlet {
    public void login()  {
        String mid = request.getParameter("mid");
        String password =request.getParameter("password");
        if (ValidateUtils.validateEmpty(mid)&&ValidateUtils.validateEmpty(password)){
            password = new MD5Code().getMD5ofStr("{[" + password + "]}");
            System.out.println(password +"js");//jiayancaozuo meixie

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
