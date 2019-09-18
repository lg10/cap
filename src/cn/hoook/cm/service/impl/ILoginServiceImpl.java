package cn.hoook.cm.service.impl;

import cn.hoook.cm.dao.ILoginDAO;
import cn.hoook.cm.dao.impl.LoginDaoImpl;
import cn.hoook.cm.factory.DAOFactory;
import cn.hoook.cm.service.ILoginService;
import cn.hoook.util.database.DatabaseConnection;
import cn.hoook.util.vo.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;


public class ILoginServiceImpl implements ILoginService {
    private Connection conn=null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;

    @Override
    public Map<String, Object> login(Member vo) throws Exception {

            Map<String, Object> map = new HashMap<String, Object>();
            ILoginDAO  ILogin = new LoginDaoImpl();
            Member member = ILogin.findLogin(vo);
            if (member.getMid() != null) {
                map.put("member", member);
            } else {
                map.put("member", null);
            }
            map.put("member", member);
            return map;
    }

    @Override
    public boolean insert(Member vo) throws Exception {
            ILoginDAO ILogin = new LoginDaoImpl();
            return ILogin.doCreate(vo);
    }

    @Override
    public Map<String, Object> listSplit(int currentPage, int lineSize) throws Exception {
        return null;
    }

    @Override
    public boolean updataByPass(String mid, String password) throws Exception {
        return false;
    }

    @Override
    public boolean updateByStatus(String mid, Integer status) throws Exception {
        return false;
    }

    @Override
    public Map<String, Object> listSplit(int currentPage, int lineSize, String title) throws Exception {
        return null;
    }
}
