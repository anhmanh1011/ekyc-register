package com.ksa.ekycregister.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class KsaPotentialCustomerDTO extends AbstractDTO<String> {
    private String id;
    private String phoneNumber;
    private String email;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createDate;

    public KsaPotentialCustomerDTO() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setCreateDate(java.time.LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public java.time.LocalDateTime getCreateDate() {
        return this.createDate;
    }
}