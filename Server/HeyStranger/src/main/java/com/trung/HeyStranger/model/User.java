package com.trung.HeyStranger.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends AbstractModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "middle_name")
    private String middle_name;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "verification_code")
    private String code;

    @Column(name = "is_active")
    private boolean active;

    @Column(name = "is_reported")
    private boolean reported;

    @Column(name = "is_blocked")
    private boolean blocked;

    @Column(name = "created_at")
    private String created;

    @Column(name = "updated_at")
    private String updated;
}
