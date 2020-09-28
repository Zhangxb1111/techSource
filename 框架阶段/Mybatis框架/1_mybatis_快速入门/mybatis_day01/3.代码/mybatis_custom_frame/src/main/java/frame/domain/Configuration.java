package frame.domain;

import java.util.HashMap;
import java.util.Map;

public class Configuration {
    private String driver;
    private String url;
    private String username;
    private String password;
    //String : mapperId   //frame.domain.Configuration.test  全类名 + 方法的名称
    // Mapper: 封装sql语句和返回值类型
    private Map<String ,Mapper> mappers = new HashMap<>();

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, Mapper> mappers) {
        this.mappers = mappers;
    }
}
