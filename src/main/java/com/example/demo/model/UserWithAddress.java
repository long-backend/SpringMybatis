package com.example.demo.model;

public class UserWithAddress {
    private String name;
    private Long salary;
    private Integer id;
    private String city;
    private String conscious;
    private String difficultcontent;
    private int difficultcode;

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

    public String getDifficultcontent() {
        return difficultcontent;
    }

    public int getDifficultcode() {
        return difficultcode;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setConscious(String conscious) {
        this.conscious = conscious;
    }

    public String getName() {
        return name;
    }

    public Long getSalary() {
        return salary;
    }

    public Integer getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getConscious() {
        return conscious;
    }


}
