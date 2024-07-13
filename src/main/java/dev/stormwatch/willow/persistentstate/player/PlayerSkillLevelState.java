package dev.stormwatch.willow.persistentstate.player;

import java.util.HashMap;
import java.util.Map;

public class PlayerSkillLevelState
{

	private final Map<Skill, LevelContainer> skillLevels = new HashMap<>();

	private enum Skill
	{
		WOODCUTTING,
		MINING,
		FARMING,
		EXCAVATING,
		FIGHTING
	}

	private record LevelContainer(int xp, int level) {}
}