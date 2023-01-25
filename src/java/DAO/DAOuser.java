/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import pojo.TblUser;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.hogwartsUtil;

/**
 *
 * @author aleak
 */
public class DAOuser {
    public List <TblUser> retrieveTblUser()
    {
        //menampilkan data ke tabel
        List stud = new ArrayList();
        TblUser stud1 = new TblUser();
        Transaction trans = null;
        Session session = hogwartsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblUser");
            stud = query.list();
            stud.add(stud1.getIdUser());
            stud.add(stud1.getUsername());
            stud.add(stud1.getPassword());
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return stud;
    }
    
    public List<TblUser> getByID(String idU){
        //SEARCH, mencari data untuk manipulasi data, ex. edit, search, delete
        TblUser usr = new TblUser();
        List <TblUser> iUsr = new ArrayList();
        
        Transaction trans = null;
        Session session = hogwartsUtil.getSessionFactory().openSession();
        
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblUser where id_user = :id");
            query.setString("id", idU);
            usr = (TblUser) query.uniqueResult();
            iUsr = query.list();
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return iUsr; 
    }
    
    public void deleteUser(int idU){
        Transaction trans = null;
        Session session = hogwartsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            TblUser usr = (TblUser) session.load(TblUser.class, new Integer(idU));
            session.delete(usr);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
                
    }
    
    
    public void editUser(TblUser usr)
    {
        Transaction trans = null;
        Session session = hogwartsUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(usr);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
                
    }   
    
    public void resetUser(TblUser usr)
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
