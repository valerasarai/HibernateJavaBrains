package com.valerastudy.HibernateMaps;

import javax.persistence.*;

/*
//Single table strategy
//--------------------------------------------------------------------
@Entity(name = "MATERIALS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "MATERIALS_TYPE",
        discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("M")
*/

/*
//Table per class strategy
//--------------------------------------------------------------------
@Entity(name = "MATERIALS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
*/

//Joined strategy
//--------------------------------------------------------------------
@Entity(name = "MATERIALS")
@Inheritance(strategy = InheritanceType.JOINED)

public class MaterialsInheritance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int materialsID;
    private String materialsName;

    public int getMaterialsID() {
        return materialsID;
    }

    public void setMaterialsID(int materialsID) {
        this.materialsID = materialsID;
    }

    public String getMaterialsName() {
        return materialsName;
    }

    public void setMaterialsName(String materialsName) {
        this.materialsName = materialsName;
    }
}
