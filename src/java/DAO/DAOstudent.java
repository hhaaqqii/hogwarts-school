/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.TblStd;
import pojo.hogwartsUtil;

/**
 *
 * @author aleak
 */
public class DAOstudent {
     public List<TblStd> getBy(String uNstd, String uGen, String uKls, String uAds) 
   {
       Transaction trans = null;
       TblStd std = new TblStd();
       List<TblStd> student = new ArrayList();
       
       Session session = hogwartsUtil.getSessionFactory().openSession();
       try{
           trans = session.beginTransaction();
           Query query = session.createQuery("from TblStd where namaStudent=:uNstd AND gender=:uGen AND kelas=:uKls AND String address=:uAds");
           query.setString("uNstd", uNstd);
           query.setString("uGen", uGen);
           query.setString("uTlp", uKls);
           query.setString("uAds", uAds);
           std = (TblStd) query.uniqueResult();
           student = query.list();
           trans.commit();
       } catch (Exception e){
           System.out.println(e);
       }
       return student;
   }
    
     
      public void add_student(TblStd student)
   {
       Transaction trans = null;
       Session session = hogwartsUtil.getSessionFactory().openSession();
       try{
           trans = session.beginTransaction();
           session.save(student);
           trans.commit();
       }catch(Exception e){
           System.out.println(e);
       }
   }
      
      
      
      public List<TblStd> retrieveTblStd()
   {
       List std1= new ArrayList(); 
       TblStd teach = new TblStd();
       Transaction trans = null;
       Session session = hogwartsUtil.getSessionFactory().openSession();
       try{
           trans = session.beginTransaction();
           Query query = session.createQuery("from TblStd");
           std1 = query.list();
           std1.add(teach.getNamaStudent());
           std1.add(teach.getGender());
           std1.add(teach.getClass());
           std1.add(teach.getAddress());
           trans.commit();
       }catch(Exception e){
           System.out.println(e);
       }
       return std1;
   }
}
