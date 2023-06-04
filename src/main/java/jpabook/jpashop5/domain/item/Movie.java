package jpabook.jpashop5.domain.item;

import javax.persistence.Entity;

@Entity
public class Movie extends Item {

    private String author;
    private String isbn;
}
