package service;

import model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CarService {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Car> getAllCars() {
        return sessionFactory.getCurrentSession().createQuery("from Car").list();
    }

    public void saveCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }
}
