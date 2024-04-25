/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class category {

    public category(int id, String name) {
        this.id = id;
        this.name = name;
    }
    private int id;
    private String name;

    public category() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "category{" + "id=" + id + ", name=" + name + '}';
    }
    
    
    
}
