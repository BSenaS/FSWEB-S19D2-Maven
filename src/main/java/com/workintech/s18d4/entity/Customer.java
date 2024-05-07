package com.workintech.s18d4.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


//Her customer sadece 1 tane address'e sahip olacak, Address ile Customer 1 to 1 bir ilişkiye sahip olacak.
//OneToOne ilişki de, JoinCOlumn'u nere de yapıp, veriyi tuttuğumuz farketmez.
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customer",schema = "fsweb")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "salary")
    private Double salary;

    //OneToOne'da mappedBy kullanılmaz.
    //CascadeType.All -> customer'da birşey silinrse addresste de sil,veya o işlemi yap.
    //Customer'a select attığımız da address id'sini görmek istiyoruz.
    //Müşterinin adresi ne?
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;


    //Bir Customer'in birden fazla accountu olabilir
    //JoinColumn'u Account tarafına atarızki Customer içerisin de birden fazla Account_id Columnu oluşmasın.
    //mappedBy : -> Accountta oluşan customer instancesı. (içerideki instance'ın ismi yazılır)
    //Burada bir account listesi var.
    @JsonManagedReference //-> infinite loopu önler
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Account> accounts = new ArrayList<>();

}
