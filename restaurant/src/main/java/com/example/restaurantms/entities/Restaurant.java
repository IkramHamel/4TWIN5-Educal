package com.example.restaurantms.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant implements Serializable {

   // private static final long serialVersionUID = 795450928237931201L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nomRestaurant, menu;
    private Date dateOuverture, dateFermeture;


    public Restaurant(String nomRestaurant, String menu, Date dateOuverture, Date dateFermeture) {
        super();
        this.dateFermeture = dateFermeture;
        this.dateFermeture = dateFermeture;
        this.nomRestaurant = nomRestaurant;
        this.menu = menu;
    }

}
