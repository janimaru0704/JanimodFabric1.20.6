package net.janimaru.janimod.util;

import net.janimaru.janimod.Janimod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> DETECTABLE_ORES = createTag("detectable_ores");
        public static final TagKey<Block> RUBY_ORES = createTag("ruby_ores");
        public static final TagKey<Block> MAPLE_LOGS = createTag("maple_logs");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(Janimod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> MAPLE_LOGS = createTag("maple_logs");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(Janimod.MOD_ID, name));
        }
    }
}
