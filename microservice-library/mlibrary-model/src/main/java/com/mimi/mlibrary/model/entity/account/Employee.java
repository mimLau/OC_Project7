package com.mimi.mlibrary.model.entity.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@DiscriminatorValue("Employee")
public class Employee extends Account {

}
