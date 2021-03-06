package com.boydti.fawe.object.mask;

import com.sk89q.worldedit.extent.Extent;
import com.sk89q.worldedit.function.mask.AbstractExtentMask;
import com.sk89q.worldedit.math.BlockVector3;

public class IdMask extends AbstractExtentMask implements ResettableMask {

    private transient int id = -1;

    public IdMask(Extent extent) {
        super(extent);
    }

    @Override
    public boolean test(Extent extent, BlockVector3 vector) {
        if (id != -1) {
            return extent.getBlock(vector).getInternalBlockTypeId() == id;
        } else {
            id = extent.getBlock(vector).getInternalBlockTypeId();
            return true;
        }
    }

    @Override
    public void reset() {
        this.id = -1;
    }

}
