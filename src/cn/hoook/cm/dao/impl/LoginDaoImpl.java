package cn.hoook.cm.dao.impl;

import cn.hoook.cm.dao.ILoginDAO;
import cn.hoook.util.dao.AbstractDAOImpl;
import cn.hoook.util.vo.Member;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class LoginDaoImpl extends AbstractDAOImpl implements ILoginDAO {
    public LoginDaoImpl(Connection conn) {
        super(conn);
    }

    @Override
    public Member findLogin(Member vo) throws SQLException {
        Member member = new Member();
        String sql = "SELECT mid,name,phone,flag,title,status FROM member  WHERE mid=? AND password=?  ";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, vo.getMid());
        super.pstmt.setString(2, vo.getPassword());
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()) {
            member.setMid(rs.getString(1));
            member.setName(rs.getString(2));
        }
        return member;
    }

    @Override
    public boolean doUpdateByPass(String mid, String password) throws SQLException {
        return false;
    }

    @Override
    public List<Member> findAllBySplit(Integer currentPage, Integer lineSize, String title) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCountByTitle(String title) throws SQLException {
        return null;
    }

    @Override
    public boolean doUpdateByStatus(String mid, Integer status) throws SQLException {
        return false;
    }

    @Override
    public boolean doUpdateByunlockStatus(String mid, Integer status) throws SQLException {
        return false;
    }

    @Override
    public boolean doUpdateByLastdate(String mid, Date lastdate) throws SQLException {
        return false;
    }

    @Override
    public boolean doCreate(Member vo) throws SQLException {
        String sql = "INSERT INTO member(mid,name,password,email)VALUES(?,?,?,?,?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, vo.getMid());
        super.pstmt.setString(2, vo.getName());
        super.pstmt.setString(3, vo.getPassword());
        super.pstmt.setString(4, vo.getEmail());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdate(Member vo) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(String id) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemoveBtch(Set<String> ids) throws SQLException {
        return false;
    }

    @Override
    public List<Member> findAll() throws SQLException {
        return null;
    }

    @Override
    public Member findById(String id) throws SQLException {
        return null;
    }

    @Override
    public List<Member> findAllBySplit(Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount() throws SQLException {
        return null;
    }

    @Override
    public List<Member> findAllBySplit(String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount(String keyWords) throws SQLException {
        return null;
    }
}
