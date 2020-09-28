package com.itheima.domain;

import java.util.*;

public class User {

    public User() {
    }

    public User(String username, Integer id , Date birthday){
        this.username = username;
        this.id = id;
        this.birthday = birthday;
    }

    private Integer id;
    private String username;
    private Date birthday;

    private List<String> list = new ArrayList<String>();
    private Set<String> set = new HashSet<String>();
    private String[] strs ;
    private Map<String ,String>  map = new HashMap<String, String>();
    private Properties  properties;

    public String[] getStrs() {
        return strs;
    }

    public void setStrs(String[] strs) {
        this.strs = strs;
    }

    public void print(){
        System.out.println("list:"+list.size());
        System.out.println("set:"+set.size());
        System.out.println("数组："+strs.length);
        Set<String> keySets = map.keySet();
        for (String key : keySets) {
            System.out.println(key + "::" + map.get(key));
        }
        //获取所有的属性名-- 枚举类型
        Enumeration enumeration = properties.propertyNames();
        while(enumeration.hasMoreElements()){  // 判断是否存在下一个元素
            Object key = enumeration.nextElement();
            System.out.println(key + "::" + properties.get(key));
        }
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
