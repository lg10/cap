package cn.hoook.cm.servlet;


import cn.hoook.cm.factory.ServiceFactory;
import cn.hoook.cm.service.ILoginService;
import cn.hoook.cm.service.impl.ILoginServiceImpl;
import cn.hoook.util.ValidateUtil.ValidateUtils;
import cn.hoook.util.md5.MD5Code;
import cn.hoook.util.servlet.DispatcherServlet;
import cn.hoook.util.vo.Member;

import java.io.IOException;
import java.util.HashMap;
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
                    ILoginService ILoginService = new ILoginServiceImpl();
                    Map<String,Object> map = ILoginService.login(vo);
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
    public void Register(){
        String mid = request.getParameter("mid");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        if (ValidateUtils.validateEmpty(mid)&&ValidateUtils.validateEmpty(password)
            &&ValidateUtils.validateEmpty(email)&&ValidateUtils.validateEmpty(phone)){
            Member vo = new Member();
            vo.setMid(mid);
            vo.setPassword(new MD5Code().getMD5ofStr("{[" + password + "]}"));
            vo.setName(name);
            vo.setEmail(email);
            vo.setPhone(phone);
            try {
                ILoginService ILoginService = new ILoginServiceImpl();
                if (ILoginService.insert(vo)) {
                    super.response.getWriter().print("success");
                } else {
                    super.response.getWriter().print("error");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            try {
                super.response.getWriter().print("error");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
