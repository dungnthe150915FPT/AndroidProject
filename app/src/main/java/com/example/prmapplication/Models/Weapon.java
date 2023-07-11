package com.example.prmapplication.Models;

import org.jetbrains.annotations.NotNull;

public class Weapon {
    // id, displayname, description, image, muzzleVelocity, fireRate, damage, ammo,
    // reloadTime, bulletSpeed, type, , fireMode, price
    private int id;
    private String displayName;
    private String description;
    private String image;
    private String fireRate;
    private String damage;
    private String ammo;
    private String reloadTime;
    private String bulletSpeed;
    private String type;
    private String fireMode;
    private String price;

    // Constructor
    public Weapon() {
    }

    public Weapon(int id, String displayName, String description, String image, String fireRate, String damage, String ammo,
            String reloadTime, String bulletSpeed, String type, String fireMode, String price) {
        this.id = id;
        this.displayName = displayName;
        this.description = description;
        this.image = image;
        this.fireRate = fireRate;
        this.damage = damage;
        this.ammo = ammo;
        this.reloadTime = reloadTime;
        this.bulletSpeed = bulletSpeed;
        this.type = type;
        this.fireMode = fireMode;
        this.price = price;
    }

    // Getter and Setter
    public int getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getFireRate() {
        return fireRate;
    }

    public String getDamage() {
        return damage;
    }

    public String getAmmo() {
        return ammo;
    }

    public String getReloadTime() {
        return reloadTime;
    }

    public String getBulletSpeed() {
        return bulletSpeed;
    }

    public String getType() {
        return type;
    }

    public String getFireMode() {
        return fireMode;
    }

    public String getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setFireRate(String fireRate) {
        this.fireRate = fireRate;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public void setAmmo(String ammo) {
        this.ammo = ammo;
    }

    public void setReloadTime(String reloadTime) {
        this.reloadTime = reloadTime;
    }

    public void setBulletSpeed(String bulletSpeed) {
        this.bulletSpeed = bulletSpeed;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFireMode(String fireMode) {
        this.fireMode = fireMode;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    // toString
    @NotNull
    @Override
    public String toString() {
        return "Weapon{" +
                "id=" + id +
                ", displayName='" + displayName + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", fireRate=" + fireRate +
                ", damage=" + damage +
                ", ammo=" + ammo +
                ", reloadTime=" + reloadTime +
                ", bulletSpeed=" + bulletSpeed +
                ", type='" + type + '\'' +
                ", fireMode='" + fireMode + '\'' +
                ", price=" + price +
                '}';
    }
}
