package com.valerastudy.HibernateMaps;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/*
//Single table strategy
//--------------------------------------------------------------------
@Entity(name = "MATERIALS1")
@DiscriminatorValue("M1")
*/

//Table per class And Joined strategy
//--------------------------------------------------------------------
@Entity(name = "MATERIALS1")
public class MaterialsInheritance1 extends MaterialsInheritance{
    private String strong;

    public String getStrong() {
        return strong;
    }

    public void setStrong(String strong) {
        this.strong = strong;
    }
}
