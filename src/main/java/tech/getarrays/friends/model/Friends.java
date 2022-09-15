package tech.getarrays.friends.model;

import javax.persistence.*;
import java.io.Serializable;
//Serializable helps transform this class into diff types of strings
@Entity
public class Friends implements Serializable {
    //    This gives it primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String restaurant;
    private String reservationTime;
    private String phone;
    private String imageUrl;
    @Column(nullable = false, updatable = false)
    private String friendCode;


    public Friends() {
    }

    public Friends(String name, String restaurant, String reservationTime, String phone, String imageUrl, String friendCode) {
        this.name = name;
        this.restaurant = restaurant;
        this.reservationTime = reservationTime;
        this.phone = phone;
        this.imageUrl = imageUrl;
        this.friendCode = friendCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getRestaurant(){
        return restaurant;
    }
    public void setRestaurant(String restaurant){
       this.restaurant =  restaurant;
    }
    public String getReservationTime(){
        return reservationTime;
    }
    public void setReservationTime(String reservationTime){
        this.reservationTime = reservationTime;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getImageUrl(){
        return imageUrl;
    }
    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }
    public String getFriendCode(){
        return friendCode;
    }
    public void setFriendCode(String friendCode){
        this.friendCode = friendCode;
    }
    @Override
    public String toString(){
        return "Friends{" +
                "id=" + id +
                ", name=' " + name + '\'' +
        ", restaurant=' " + restaurant + '\'' +
        ", reservationTime=' " + reservationTime + '\'' +
        ", phone=' " + phone + '\'' +
        ", imageUrl=' " + imageUrl + '\'' +
        ", friendCode=' " + friendCode + '\'' +
                '}';
    }
}