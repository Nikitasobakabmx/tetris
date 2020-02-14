package com.laba.two.carshop.repositories;

import com.laba.two.carshop.model.ClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<ClientEntity, String> {
}














//package com.laba.two.restfull.db.dao;
//
//import com.laba.two.restfull.db.model.Accaunt;
//import com.laba.two.restfull.db.model.Game;
//import com.laba.two.restfull.db.HibernateSessionFactoryUtil;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//import java.util.List;
//
//public class AccauntRepositories {
//    public Accaunt findByEmail(String email){
//        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Accaunt.class, email);
//    }
//
//    public void save(Accaunt acc){
//        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        Transaction tx1 = session.beginTransaction();
//        session.update(acc);
//        tx1.commit();
//        session.close();
//    }
//
//    public void delete(Accaunt user) {
//        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        Transaction tx1 = session.beginTransaction();
//        session.delete(user);
//        tx1.commit();
//        session.close();
//    }
//
//    public Game findGameById(int id) {
//        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Game.class, id);
//    }
//
//    public void update(Accaunt user) {
//        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        Transaction tx1 = session.beginTransaction();
//        session.update(user);
//        tx1.commit();
//        session.close();
//    }
//
//    public List<Accaunt> findAll() {
//        List<Accaunt> users = (List<Accaunt>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From accaunt").list();
//        return users;
//    }
//}
