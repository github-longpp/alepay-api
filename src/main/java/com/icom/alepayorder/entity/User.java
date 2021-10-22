package com.icom.alepayorder.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "user", schema = "gate_schema")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    @Basic
    @Column(name = "user_name")
    private String userName;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "phone")
    private String phone;

    @Basic
    @Column(name = "full_name")
    private String fullName;

    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "gender")
    private String gender;

    @Basic
    @Column(name = "address")
    private String address;

    @Basic
    @Column(name = "district")
    private String district;

    @Basic
    @Column(name = "device_id")
    private String deviceId;

    @Basic
    @Column(name = "city")
    private String city;

    @Basic
    @Column(name = "country")
    private String country;

    @Basic
    @Column(name = "post_code")
    private String postCode;

    @Basic
    @Column(name = "birth_date")
    private Date birthDate;

    @Basic
    @Column(name = "identity")
    private String identity;

    @Basic
    @Column(name = "identity_date")
    private Date identityDate;

    @Basic
    @Column(name = "identity_place")
    private String identity_place;

    @Basic
    @Column(name = "money")
    private int money;

    @Basic
    @Column(name = "rice")
    private int rice;

    @Basic
    @Column(name = "seed")
    private int seed;

    @Basic
    @Column(name = "point")
    private int point;

    @Basic
    @Column(name = "exp")
    private int exp;

    @Basic
    @Column(name = "level")
    private String level;

    @Basic
    @Column(name = "login_count")
    private int loginCount;

    @Basic
    @Column(name = "vip")
    private String vip;

    @Basic
    @Column(name = "photo")
    private String photo;

    @Basic
    @Column(name = "notify")
    private boolean notify;

    @Basic
    @Column(name = "provider")
    private String provider;

    @Basic
    @Column(name = "external_id")
    private String externalId;

    @Basic
    @Column(name = "type")
    private String type;

    @Basic
    @Column(name = "attend")
    private String attend;

    @Basic
    @Column(name = "verify_code")
    private String verifyCode;

    @Basic
    @Column(name = "verify_key")
    private String verifyKey;

    @Basic
    @Column(name = "refer_code")
    private String referCode;

    @Basic
    @Column(name = "friend_code")
    private String friendCode;

    @Basic
    @Column(name = "status")
    private String status;

    @Basic
    @Column(name = "create_date")
    private Timestamp createDate;

    @Basic
    @Column(name = "update_date")
    private Timestamp updateDate;

}
