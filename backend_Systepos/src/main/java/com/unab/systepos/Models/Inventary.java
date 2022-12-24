package com.unab.systepos.Models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name="inventary")
public class Inventary implements Serializable {
    @Id
    @Column(name="id_inventary")
    private String id_inventary;
    @Column(name="fecha_inicio")
    private Date fecha_inicio;
    @Column(name="total_items")
    private double total_items;
    @ManyToOne
    @JoinColumn(name="id_user")
    private User user;
    
    @Override
    public String toString() {
        return "inventary [id_inventary=" + id_inventary+ ", fecha_inicio=" + fecha_inicio + ", total_items="
                + total_items + ", user=" + user + "]";
    }

    

}
