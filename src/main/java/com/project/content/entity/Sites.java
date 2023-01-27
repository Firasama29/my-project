package com.project.content.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "table")
public class Sites implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SITES")
    @SequenceGenerator(name = "SEQ_SITES", sequenceName = "seq_sites")
    private Long id;

    private String name;


    public Sites() {}

    public Sites(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString () {
        return "Sites{" + "id:" + id + "name" + name + "}";
    }
}
