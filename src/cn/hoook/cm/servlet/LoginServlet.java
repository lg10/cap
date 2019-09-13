package cn.hoook.cm.servlet;


import cn.hoook.cm.vo.Member;
import cn.hoook.util.ValidateUtil.ValidateUtils;
import cn.hoook.util.md5.MD5Code;
import cn.hoook.util.servlet.DispatcherServlet;


public class LoginServlet extends DispatcherServlet {
    public void login() {
        String mid = super.request.getParameter("mid");
        String password = super.request.getParameter("password");
        if (ValidateUtils.validateEmpty(mid)&&ValidateUtils.validateEmpty(password)){
            Member lo = new Member();
            lo.setMid(mid);
            lo.setPassword(new MD5Code().getMD5ofStr("{["+password+"]}"));
            System.out.println(lo.getPassword()+"+++++");
            System.out.println(lo.getStatus()+"______");
            System.out.println(lo.getMid()+"______");
            System.out.println(lo.getPassword()+"______");
            if (lo.getMid() != null){
                super.request.getSession().setAttribute("lo",map.get("lo"));
            }
        }
    }

}
