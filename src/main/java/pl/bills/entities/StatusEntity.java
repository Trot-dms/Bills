package pl.bills.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by trot on 08.01.17.
 */

@Entity
@Table(name = "status")
public class StatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "status_id")
    private Integer id;
    @Column(length = 50)
    private String name;

    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
    private Set<BillsEntity> billsEntity;

    public StatusEntity() {
    }

    public StatusEntity(String name) {
        this.name = name;
    }

    public Set<BillsEntity> getBillsEntity() {
        return billsEntity;
    }

    public void setBillsEntity(Set<BillsEntity> billsEntity) {
        this.billsEntity = billsEntity;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
