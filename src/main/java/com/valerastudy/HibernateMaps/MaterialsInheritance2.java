package com.valerastudy.HibernateMaps;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/*
//Single table strategy
//--------------------------------------------------------------------
@Entity(name = "MATERIALS2")
@DiscriminatorValue("M2")
*/

//Table per class And Joined strategy
//--------------------------------------------------------------------
@Entity(name = "MATERIALS2")
public class MaterialsInheritance2 extends MaterialsInheritance {
    private String permiability;

    public String getPermiability() {
        return permiability;
    }

    public void setPermiability(String permiability) {
        this.permiability = permiability;
    }
}
