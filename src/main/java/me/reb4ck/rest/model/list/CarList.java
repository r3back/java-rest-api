package me.reb4ck.rest.model.list;

import me.reb4ck.rest.model.Car;

import java.util.List;

public final class CarList {
    private List<Car> carList;

    public CarList() {
    }

    protected CarList(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public static CarList of(List<Car> carList){
        return new CarList(carList);
    }
}
