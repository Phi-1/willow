package dev.stormwatch.willow.state.player;

import dev.stormwatch.willow.Willow;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.impl.networking.PayloadTypeRegistryImpl;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class PlayerProfessionState
{
    public static final Identifier PROFESSION_SYNC = Identifier.of(Willow.MOD_ID, "profession_sync");

    private final ServerPlayerEntity player;
    private final Map<Profession, Integer> professionXP = new HashMap<>();

    public PlayerProfessionState(ServerPlayerEntity player)
    {
        this(player, 0, 0, 0, 0, 0);
    }

    public PlayerProfessionState(ServerPlayerEntity player, int woodcuttingXP, int miningXP, int excavatingXP, int farmingXP, int fightingXP)
    {
        this.player = player;
    }

    public ToolMaterial getToolLevel(Profession profession)
    {
        // TODO
        return ToolMaterials.WOOD;
    }

    public void increaseProfessionXP(Profession profession, int xp)
    {
        int total = this.professionXP.getOrDefault(profession, 0) + xp;
        this.professionXP.put(profession, total);
        this.syncToClient();
    }

    private void syncToClient()
    {
        ProfessionStatePayload data = new ProfessionStatePayload(
                this.professionXP.getOrDefault(Profession.WOODCUTTING, 0),
                this.professionXP.getOrDefault(Profession.MINING, 0),
                this.professionXP.getOrDefault(Profession.EXCAVATING, 0),
                this.professionXP.getOrDefault(Profession.FARMING, 0),
                this.professionXP.getOrDefault(Profession.FIGHTING, 0)
                );
        ServerPlayNetworking.send(this.player, data);
    }

    public record ProfessionStatePayload(int woodcuttingXP, int miningXP, int excavatingXP, int farmingXP, int fightingXP) implements CustomPayload
    {
        public static final CustomPayload.Id<ProfessionStatePayload> ID = new CustomPayload.Id<>(PROFESSION_SYNC);
        public static final PacketCodec<RegistryByteBuf, ProfessionStatePayload> CODEC = PacketCodec.tuple
                (
                        PacketCodecs.INTEGER, ProfessionStatePayload::woodcuttingXP,
                        PacketCodecs.INTEGER, ProfessionStatePayload::miningXP,
                        PacketCodecs.INTEGER, ProfessionStatePayload::excavatingXP,
                        PacketCodecs.INTEGER, ProfessionStatePayload::farmingXP,
                        PacketCodecs.INTEGER, ProfessionStatePayload::fightingXP,
                        ProfessionStatePayload::new
                );

        @Override
        public Id<? extends CustomPayload> getId()
        {
            return ID;
        }
    }

    public enum Profession
    {
        WOODCUTTING,
        MINING,
        EXCAVATING,
        FARMING,
        FIGHTING
    }
}
