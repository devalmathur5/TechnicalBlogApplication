package technicalblog.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import technicalblog.model.User;

import javax.persistence.*;

@Repository
public class UserRepository {

    @PersistenceUnit(unitName = "technicalblog")
    EntityManagerFactory emf;

    public void registerUser(User newUser) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(newUser);
            transaction.commit();
        }catch(Exception e) {
            transaction.rollback();
        }
    }

    public User checkUser(String username, String password){
        try {
            EntityManager em = emf.createEntityManager();
            TypedQuery query = em.createQuery("select u from User u " +
                    "where u.username = :username and u.password = :password",User.class);
            query.setParameter("username", username);
            query.setParameter("password", password);

            return (User) query.getSingleResult();
        }catch(NoResultException nre){
            return null;
        }
    }
}
