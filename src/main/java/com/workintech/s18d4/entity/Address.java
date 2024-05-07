package com.workintech.s18d4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//1.Entity tanımlarken herzaman @Entity ve @Table anatasyonlarını kullan, table içerisine postgresql table isim karsılıgı + için de buluındugu schema ismini yaz.

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "address",schema = "fsweb")
public class Address {
    //PK ANATASYONLARINA DİKKAT

    //Bu id'yi joinColumn ile customer tablosuna yazıyoruz.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "no")
    private Integer no;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "description")
    private String description;

    //cascadeType.All -> Demiyoruz çünkü bir adress silindiğin de customerin silinmesini istemeyiz.
    //Bura da joinColumn yapmadıgımız için bu Jpa seviyesin de kalacak, bir adres karsılıgı olmayacak veritabanında.
    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    private Customer customer;

}
