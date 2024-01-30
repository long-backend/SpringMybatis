package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SearchDTO {

    @Size(min = 6, max = 32, message = "Username must be between 6 and 32 characters")
    private String name;

    public String getName() {
        return name;
    }

    public String getSalary() {
        return salary;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public int getPage() {
        return page;
    }

    @NotBlank(message = "salary cannot be blank")
    private String salary;
    private int page;
}
