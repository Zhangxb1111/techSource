package cn.itcast.demo05_jdbctemplate;

public class Product {
    private int pid;
    private String pname;
    private int price;
    private String flag;

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", flag='" + flag + '\'' +
                '}';
    }

    public Product() {
    }

    public Product(int pid, String pname, int price, String flag) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.flag = flag;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
