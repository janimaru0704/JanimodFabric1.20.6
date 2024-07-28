package net.janimaru.janimod.item.custom;

import net.janimaru.janimod.item.ModItems;
import net.janimaru.janimod.util.ModTags;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class OreDetectorItem extends Item {

    public OreDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getWorld().isClient()) return ActionResult.SUCCESS;

        BlockPos pos = context.getBlockPos();
        PlayerEntity player = Objects.requireNonNull(context.getPlayer());
        boolean isNotFound = true;

        for (int i = pos.getY(); i >= -64; i--) {
            BlockPos nPos = new BlockPos(pos.getX(), i, pos.getZ());
            BlockState state = context.getWorld().getBlockState(nPos);
            if (state.isIn(ModTags.Blocks.DETECTABLE_ORES)) {
                player.sendMessage(Text.translatable("item.janimod.ore_detector.msg",
                        state.getBlock().getName(), nPos.getX(), nPos.getY(), nPos.getZ()), true);
                isNotFound = false;
                break;
            }
        }
        if (isNotFound) {
            player.sendMessage(Text.translatable("item.janimod.ore_detector.msg_fail"), true);
        }

        context.getStack().damage(1, player, EquipmentSlot.MAINHAND);
        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("item.janimod.ore_detector.tooltip"));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
