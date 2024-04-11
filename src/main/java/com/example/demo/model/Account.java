package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Account.
 *
 * @author Author
 */
@Data
@Entity
public class Account {
    @Id
    private Long id;
    private String accountNumber;
    private String bic;
    private Double amount;
}
