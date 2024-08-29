/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reservation.dining.model;

import reservation.model.foodAvailability;

/**
 *
 * @author user
 */
public class DiningOption {
 
    private int Id;
    private int hotelId;
    private String optionName;
    private String description;
    private double price;
    private foodAvailability foodAvalability;

    public int getResId() {
        return Id;
    }

    public void setResId(int resId) {
        this.Id = resId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public foodAvailability getFoodAvalability() {
        return foodAvalability;
    }

    public void setFoodAvalability(foodAvailability foodAvalability) {
        this.foodAvalability = foodAvalability;
    }
    
    
    
    
    
}
