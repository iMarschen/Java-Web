package bean;  
  
import java.math.BigDecimal;  
  
public class StudentInfoBean {  
      
    private Integer sno;  
      
    private String sname;  
      
    private String ssex;  
      
    private Integer sage;  
       
    private Integer cid;  
      
    private BigDecimal sbalance;  
  
    public BigDecimal getSbalance() {  
        return sbalance;  
    }  
  
    public void setSbalance(BigDecimal sbalance) {  
        this.sbalance = sbalance;  
    }  
  
    public Integer getSno() {  
        return sno;  
    }  
  
    public void setSno(Integer sno) {  
        this.sno = sno;  
    }  
  
    public String getSname() {  
        return sname;  
    }  
  
    public void setSname(String sname) {  
        this.sname = sname;  
    }  
  
    public String getSsex() {  
        return ssex;  
    }  
  
    public void setSsex(String ssex) {  
        this.ssex = ssex;  
    }  
  
    public Integer getSage() {  
        return sage;  
    }  
  
    public void setSage(Integer sage) {  
        this.sage = sage;  
    }  
  
    public Integer getCid() {  
        return cid;  
    }  
  
    public void setCid(Integer cid) {  
        this.cid = cid;  
    }  
  
}  
