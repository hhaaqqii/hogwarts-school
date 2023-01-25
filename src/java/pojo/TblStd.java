package pojo;
// Generated Oct 8, 2022 10:51:21 PM by Hibernate Tools 4.3.1

import DAO.DAOstudent;
import java.util.List;
import javax.faces.bean.ManagedBean;




/**
 * TblStd generated by hbm2java
 */
@ManagedBean
public class TblStd  implements java.io.Serializable {


     private Integer idStudent;
     private String namaStudent;
     private String gender;
     private String address;
     private String kelasStudent;

     
     public void save_student()
     {
         DAO.DAOstudent add = new DAOstudent();
         add.add_student(this);
     }
     
     
     
      public List<TblStd> getAllRecordsstd()
     {
         DAOstudent stu = new DAOstudent();
         List<TblStd> lstu = stu.retrieveTblStd();
         return lstu;
     }
      
    public TblStd() {
    }

    public TblStd(String namaStudent, String gender, String address, String kelasStudent) {
       this.namaStudent = namaStudent;
       this.gender = gender;
       this.address = address;
       this.kelasStudent = kelasStudent;
    }
   
    public Integer getIdStudent() {
        return this.idStudent;
    }
    
    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }
    public String getNamaStudent() {
        return this.namaStudent;
    }
    
    public void setNamaStudent(String namaStudent) {
        this.namaStudent = namaStudent;
    }
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public String getKelasStudent() {
        return this.kelasStudent;
    }
    
    public void setKelasStudent(String kelasStudent) {
        this.kelasStudent = kelasStudent;
    }




}

