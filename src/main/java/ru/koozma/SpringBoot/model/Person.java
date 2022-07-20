package ru.koozma.SpringBoot.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="Person2")
public class Person {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="fullname")
    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 10,max = 100,message = "имя должно содержать от 10 до 100 символов")
    private String fullName;
    @Column(name="birthday")
    @Min(value = 1980,message = "Год рождения должен быть не меньше 1980")
    private int birthday;
    @OneToMany(mappedBy = "owner")
    private List<Book> books;

    public Person(int id, String fullName, int birthday) {
        this.id = id;
        this.fullName = fullName;
        this.birthday = birthday;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
