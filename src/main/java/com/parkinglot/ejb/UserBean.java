/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkinglot.ejb;

import com.park.parkinglot.common.CarDetails;
import com.park.parkinglot.common.UserDetails;
import com.park.parkinglot.entity.Car;
import com.park.parkinglot.entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Andrei Marica
 */
@Stateless
public class UserBean {

    private static final Logger LOG = Logger.getLogger(CarBean.class.getName());
    
    @PersistenceContext
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public List<UserDetails> getAllCars() {
        LOG.info("getAllUsers");
        try {
            Query query = em.createQuery("SELECT u FROM User u");
            List<Car> cars = (List<Car>) query.getResultList();
            //List<Car> cars = (List<Car>) em.createQuery("SELECT c FROM Car c").getResultList();
            return copyUsersToDetails(cars);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    private List<UserDetails> copyUsersToDetails(List<User> users) {
        List<UserDetails> detailsList = new ArrayList<>();
        for(User user: users){
            UserDetails userDetails = new UserDetails(user.getId(),
                                                   user.getUsername(),
                                                   user.getEmail(),
                                                   user.getPosition());
            detailsList.add(userDetails);
        }
        return detailsList;  
    }
}
