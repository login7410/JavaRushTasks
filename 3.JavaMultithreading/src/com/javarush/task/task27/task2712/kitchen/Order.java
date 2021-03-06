package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by user on 20.05.2017.
 */
public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public List<Dish> getDishes() {
        return dishes;
    }

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public int getTotalCookingTime() {
        int result = 0;
        for (Dish dish : dishes) {
            result += dish.getDuration();
        }

        return result;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }


    @Override
    public String toString() {
        String list = "";
        if (dishes != null) {
            list = dishes.toString();
        }
        return "Your order: " + list + " of " + tablet;
    }
}
