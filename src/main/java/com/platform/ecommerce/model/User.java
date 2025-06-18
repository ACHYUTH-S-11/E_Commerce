package com.platform.ecommerce.model;
 
import jakarta.persistence.*;
import java.util.List;
 
@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    private String name;
 
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems;
 
    public User() {}
 
    public User(Long userId, String name) {
        this.userId = userId;
        this.name = name;
    }
 
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
 
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}