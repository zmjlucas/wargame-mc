package me.zmjlucas.wargame.Commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.command.CommandSource;
import static net.minecraft.command.Commands.literal;

public class WargameCommand
{
    public static void register(CommandDispatcher<CommandSource> dispatcher)
    {
        LiteralArgumentBuilder<CommandSource> wargamecommand = literal("wargame").
                then(literal("start").
                        executes((c) -> {
                            ClientPlayerEntity player = Minecraft.getInstance().player;
                            if (player != null) {
                                player.sendChatMessage("Started");
                            }
                            return 1;
                        })).
                then(literal("stop").
                        executes((c) -> {
                            ClientPlayerEntity player = Minecraft.getInstance().player;
                            if (player != null) {
                                player.sendChatMessage("Stoped");
                            }
                            return 1;
                        })).
                then(literal("test").
                        executes((c) -> {
                            ClientPlayerEntity player = Minecraft.getInstance().player;
                            if (player != null) {
                                player.sendChatMessage("test");
                            }
                            return 1;
                        }));

        dispatcher.register(wargamecommand);
    }
}
