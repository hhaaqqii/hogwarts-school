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
import pojo.TblTcr;
import pojo.hogwartsUtil;

/**
 *
 * @author aleak
 */
public class DAOteacher {
    public List<TblTcr> getBy(String uNtcr, String uGen, String uTlp, String uGaji, String uAds) 
   {
       Transaction trans = null;
       TblTcr tcr = new TblTcr();
       List<TblTcr> teacher = new ArrayList();
       
       Session session = hogwartsUtil.getSessionFactory().openSession();
       try{
           trans = session.beginTransaction();
           Query query = session.createQuery("from TblTcr where namaTeacher=:uNtcr AND gender=:uGen AND tlpn=:uTlp AND gaji=:uGaji AND String address=:uAds");
           query.setString("uNtcr", uNtcr);
           query.setString("uGen", uGen);
           query.setString("uTlp", uTlp);
           query.setString("uGaji", uGaji);
           query.setString("uAds", uAds);
           tcr = (TblTcr) query.uniqueResult();
           teacher = query.list();
           trans.commit();
       } catch (Exception e){
           System.out.println(e);
       }
       return teacher;
   }
    
    
    public void add_teacher(TblTcr teacher)
   {
       Transaction trans = null;
       Session session = hogwartsUtil.getSessionFactory().openSession();
       try{
           trans = session.beginTransaction();
           session.save(teacher);
           trans.commit();
       }catch(Exception e){
           System.out.println(e);
       }
   }
    
    
    public List<TblTcr> retrieveTblTcr()
   {
       List tcr1 = new ArrayList();
       TblTcr teach = new TblTcr();
       Transaction trans = null;
       Session session = hogwartsUtil.getSessionFactory().openSession();
       try{
           trans = session.beginTransaction();
           Query query = session.createQuery("from TblTcr");
           tcr1 = query.list();
           tcr1.add(teach.getNamaTeacher());
           tcr1.add(teach.getGender());
           tcr1.add(teach.getNoTelp());
           tcr1.add(teach.getGaji());
           tcr1.add(teach.getAddress());
           trans.commit();
       }catch(Exception e){
           System.out.println(e);
       }
       return tcr1;
   }
    
    
    
    public List<TblTcr> getbyID(String idT)
   {
       TblTcr tea = new TblTcr();
       List<TblTcr> iTea = new ArrayList();
       
       Transaction trans = null;
       Session session = hogwartsUtil.getSessionFactory().openSession();
       
       try{
           trans = session.beginTransaction();
           Query query = session.createQuery("from TblTcr where id_teacher= :id");
           query.setString("id", idT);
           tea = (TblTcr) query.uniqueResult();
           iTea = query.list();
           trans.commit();
       } catch (Exception e){
           System.out.println(e);
       }
       return iTea;
   }
    
    
    public void deleteTcr(Integer idT)
   {
       Transaction trans = null;
       Session session = hogwartsUtil.getSessionFactory().openSession();
       
       try{
           trans = session.beginTransaction();
           TblTcr tea = (TblTcr) session.load(TblTcr.class, new Integer(idT));
           session.delete(tea);
           trans.commit();
       }catch (Exception e){
           System.out.println(e);
       }
   }
   
   public void editTcr(TblTcr tea)
   {
       Transaction trans = null;
       Session session = hogwartsUtil.getSessionFactory().openSession();
       
       try{
           trans = session.beginTransaction();
           session.update(tea);
           trans.commit();
       } catch (Exception e){
           System.out.println(e);
       }
   }
   
   public void resetTcr(TblTcr tea)
   {
       Transaction trans = null;
       Session session = hogwartsUtil.getSessionFactory().openSession();
       
       try{
           trans = session.beginTransaction();
           session.clear();
           trans.commit();
       }catch(Exception e){
           System.out.println(e);
       }
   }
}
