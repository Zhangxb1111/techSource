package com.itheima.provider;

import com.itheima.domain.User;

public class UserProvider {

    public String findByQuery(User user){
        StringBuffer sb = new StringBuffer();
        sb.append("select * from user where 1=1");
        if(user.getUsername() != null){
            sb.append(" and username like '%" + user.getUsername()+"%' ");
        }
        if(user.getSex()!= null){
            sb.append(" and sex = '" + user.getSex()+"'");
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer();
        sb.append("select * from user where username like '%"+ "王" + "%'");
        System.out.println(sb.toString());
    }
}
