package net.janimaru.janimod.item.custom;

import net.janimaru.janimod.Janimod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.Objects;
import java.util.function.Predicate;

public class OreDetectorItem extends Item {
    private static final TagKey<Block> ORE_DETECTED = TagKey.of(RegistryKeys.BLOCK,
            new Identifier(Janimod.MOD_ID, "ore_detected"));

    public OreDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getWorld().isClient) return ActionResult.SUCCESS;
        Janimod.LOGGER.info("OreDetectorItem::useOnBlock was called.");

        BlockPos pos = context.getBlockPos();
        PlayerEntity player = Objects.requireNonNull(context.getPlayer());
        boolean isNotFound = true;

        for (int i = pos.getY(); i >= -64; i--) {
            BlockPos nPos = new BlockPos(pos.getX(), i, pos.getZ());
            BlockState state = context.getWorld().getBlockState(nPos);
            if (state.streamTags().anyMatch(Predicate.isEqual(ORE_DETECTED))) {
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
}
