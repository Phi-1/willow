package dev.stormwatch.willow.mixin;

import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

/**
 * Makes logs require an axe to yield drops
 */
@Mixin(Blocks.class)
public class BlocksMixin
{
	@Overwrite
	public static Block createLogBlock(MapColor topMapColor, MapColor sideMapColor)
	{
		return new PillarBlock
		(
			AbstractBlock.Settings.create()
				.mapColor(state -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor)
				.instrument(NoteBlockInstrument.BASS)
				.strength(2.0F)
				.sounds(BlockSoundGroup.WOOD)
				.burnable()
				// OVERWRITE: add tool required
				.requiresTool()
		);
	}

	@Overwrite
	public static Block createLogBlock(MapColor topMapColor, MapColor sideMapColor, BlockSoundGroup soundGroup)
	{
		return new PillarBlock
		(
			AbstractBlock.Settings.create()
				.mapColor(state -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor)
				.instrument(NoteBlockInstrument.BASS)
				.strength(2.0F)
				.sounds(soundGroup)
				.burnable()
				// OVERWRITE: add tool required
				.requiresTool()
		);
	}

	@Overwrite
	public static Block createNetherStemBlock(MapColor mapColor)
	{
		return new PillarBlock(
				AbstractBlock.Settings.create()
						.mapColor(state -> mapColor)
						.instrument(NoteBlockInstrument.BASS)
						.strength(2.0F)
						.sounds(BlockSoundGroup.NETHER_STEM)
						// OVERWRITE: add tool required
						.requiresTool()
		);
	}
}