package com.bookstore.mybookstoreapp.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(unique = true)
    @EqualsAndHashCode.Include
    private String email;

    @Column(unique = true)
    @Size(min = 3, max = 12)
//    groups = UserRegisterValidationGroup.class, message = "Username needs to be between 3 - 12 characters.")
    @EqualsAndHashCode.Include
//    @UniqueUser(groups = UserRegisterValidationGroup.class)
    private String username;

    @Size(min = 6, max = 200)
//    groups = UserRegisterValidationGroup.class, message = "Password needs to be between 4 - 200 characters.")
    private String password;

    private Date joined;

    @OneToMany(mappedBy = "user")
    private Set <Review> reviews; // user ma set swoich review


    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    private Long points; // zsumowana ilość puntów za Votes w review

    @Transient
    private int logged;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_category", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private Set<Category> categories;                   // user ma subskrypcje do categorii (many to many)

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_subs", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "sub_id"))
    private Set<User> subbedToUsers;

    public User(){}

    public User(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.roles = user.getRoles();
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<User> getSubbedToUsers() {
        return subbedToUsers;
    }

    public void setSubbedToUsers(Set<User> subbedToUsers) {
        this.subbedToUsers = subbedToUsers;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Date getJoined() {
        return joined;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public Long getPoints() {
        return points;
    }

    public int getLogged() {
        return logged;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setJoined(Date joined) {
        this.joined = joined;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public void setLogged(int logged) {
        this.logged = logged;
    }
}
