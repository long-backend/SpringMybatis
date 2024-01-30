package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Users {
    public String getName() {
        return name;
    }

    public Long getSalary() {
        return salary;
    }

    public Integer getId() {
        return id;
    }

    public void setAddressid(int addressid) {
        this.addressid = addressid;
    }

    public int getAddressid() {
        return addressid;
    }

    public void setDifficultcontent(String difficultcontent) {

        this.difficultcontent = difficultcontent;

    }

    public void setDifficultcode(int difficultcode) {
        this.difficultcode = difficultcode;

        switch (difficultcode) {
            case 0:
                difficultcontent = "easy";
                break;
            case 1:
                difficultcontent = "medium";
                break;
            case 2:
                difficultcontent = "difficult";
                break;
            default:
                difficultcontent = "";
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getDifficultcontent() {
        return difficultcontent;
    }

    public int getDifficultcode() {
        return difficultcode;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    private String difficultcontent;
    private int difficultcode;
    private int addressid;

    @NotBlank(message = "name cannot be blank")
    private String name;

    @NotNull(message = "salary cannot be blank")
    private Long salary;

    private Integer id;
}
