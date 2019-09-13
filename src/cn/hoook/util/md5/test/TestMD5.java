package cn.hoook.util.md5.test;

import cn.hoook.util.md5.MD5Code;

public class TestMD5 {
    public static void main(String[] args){
        System.out.println(new MD5Code().getMD5ofStr("{[123456]}"));
    }
}
