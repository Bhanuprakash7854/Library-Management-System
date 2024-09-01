package com.library.Library.Management.System.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String author;
    private boolean isBorrowed;
    @ManyToOne
    private User borrowedBy;
}
