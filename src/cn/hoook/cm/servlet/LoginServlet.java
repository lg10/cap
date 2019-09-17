package cn.hoook.cm.servlet;


import cn.hoook.cm.factory.ServiceFactory;
import cn.hoook.util.ValidateUtil.ValidateUtils;
import cn.hoook.util.md5.MD5Code;
import cn.hoook.util.servlet.DispatcherServlet;
import cn.hoook.cm.dao.impl.LoginDao;
import cn.hoook.util.vo.Member;

import java.io.IOException;
import java.util.Map;


public class LoginServlet extends DispatcherServlet {
    public void login()  {
        String mid = request.getParameter("mid");
        String password =request.getParameter("password");
        if (ValidateUtils.validateEmpty(mid)&&ValidateUtils.validateEmpty(password)){
            Member vo = new Member();
            vo.setMid(mid);
            vo.setPassword(new MD5Code().getMD5ofStr("{[" + password + "]}"));
//            password = new MD5Code().getMD5ofStr("{[" + password + "]}");
            System.out.println(vo.getPassword() +"js");

                try {
                    Map<String,Object> map = ServiceFactory.getIMemberServiceInstance().login(vo);
                    Member member = (Member) map.get("member");
                    if (member.getMid() != null){
                        super.request.getSession().setAttribute("member",map.get("member"));
                        super.response.getWriter().print("success");
                    }else{
                        super.response.getWriter().print("error");
                    }
//                if (LoginDao.checkLogin(mid,password)){
//                    request.setAttribute("mid",mid);
//                    super.response.getWriter().print("success");
//                }else{
//                    super.response.getWriter().print("error");
//                }
                } catch (Exception e) {
                    e.printStackTrace();
                }

        }


    }

}
