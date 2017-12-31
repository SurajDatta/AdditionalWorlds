package org.terasology.surajworld;
import org.terasology.math.Region3i;
import org.terasology.world.generation.Border3D;
import org.terasology.world.generation.facets.base.BaseBooleanFieldFacet3D;

public class BushFacet extends BaseBooleanFieldFacet3D {

    public BushFacet(Region3i targetRegion, Border3D border) {
        super(targetRegion, border);
    }

}
