package hiber.dao;

import hiber.model.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDaoImp implements UserDao {

   private final SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> getUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> getUserByCarModel(String model) {
      TypedQuery<User> query
              = sessionFactory.getCurrentSession().createQuery("FROM User u RIGHT JOIN FETCH u.car WHERE u.car.model=:model");
      query.setParameter("model", model);
      return query.getResultList();
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> getUserByCarModelAndSeries(String model, int series) {
      TypedQuery<User> query
              = sessionFactory.getCurrentSession().createQuery("FROM User u RIGHT JOIN FETCH u.car WHERE u.car.model=:model AND u.car.series=:series");
      query.setParameter("model", model);
      query.setParameter("series", series);
      return query.getResultList();
   }

}
