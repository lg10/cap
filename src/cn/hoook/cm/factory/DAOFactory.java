package cn.hoook.cm.factory;

import cn.hoook.cm.dao.ILoginDAO;
import cn.hoook.cm.dao.impl.LoginDaoImpl;


import java.sql.Connection;

public class DAOFactory {
    public  static ILoginDAO getIMemberDAOInstance(Connection conn){
        return new LoginDaoImpl(conn);
    }

}
