package controller;

import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.CarService;

import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping(path = "cars", method = RequestMethod.GET)
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @RequestMapping(path = "cars", method = RequestMethod.POST)
    public String saveCar(@RequestBody Car car) {
        carService.saveCar(car);
        return "Car " + car.getId() + " saved";
    }
}
