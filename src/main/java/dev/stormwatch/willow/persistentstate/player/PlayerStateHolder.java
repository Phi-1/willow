package dev.stormwatch.willow.persistentstate.player;

import java.util.UUID;

public record PlayerStateHolder
        (
                UUID playerUUID,
                PlayerSkillLevelState playerSkillLevelState
        ) {}