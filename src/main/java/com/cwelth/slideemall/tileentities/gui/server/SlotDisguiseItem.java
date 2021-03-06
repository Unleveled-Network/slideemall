package com.cwelth.slideemall.tileentities.gui.server;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;

public class SlotDisguiseItem extends SlotItemHandler {
    public SlotDisguiseItem(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }

    @Override
    public int getItemStackLimit(@Nonnull ItemStack stack) {
        return 1;
    }

    @Override
    public boolean isItemValid(@Nonnull ItemStack stack) {
        if(stack.getItem() instanceof ItemBlock)
        {
            if(Block.getBlockFromItem(stack.getItem()).hasTileEntity(Block.getBlockFromItem(stack.getItem()).getDefaultState()))
                return false;
            else {
                if(!Block.getBlockFromItem(stack.getItem()).isOpaqueCube(Block.getBlockFromItem(stack.getItem()).getDefaultState()))
                    return false;
                else
                    return true;
            }
        }
        else return false;
    }
}
