package com.pritchvolution.init;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;

import java.util.Random;

public class PritchvolutionCommands {
    /*
    public static void init() {
        String warp = "warp";
        CommandRegistrationEvent.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(literal(warp)
                .requires(source -> source.hasPermissionLevel(2))
                .then(
                        CommandManager.literal("random").executes((context -> {
                            final long text = InfinityMethods.getRandomSeed(new Random());
                            WarpLogic.requestWarpById(context, text);
                            return 1;
                        }))
                )
                .then(
                        CommandManager.literal("existing").then(
                                argument("existing", DimensionArgumentType.dimension()).executes(context -> {
                                    final Identifier identifier = context.getArgument("existing", Identifier.class);
                                    WarpLogic.requestWarpToExisting(context, identifier);
                                    return 1;
                                })
                        )
                )
                .then(
                        CommandManager.literal("id").then(
                                argument("id", IntegerArgumentType.integer())
                                        .executes(context -> {
                                            final int value = IntegerArgumentType.getInteger(context, "id");
                                            WarpLogic.requestWarpById(context, value);
                                            return 1;
                                        })
                        )
                )
                .then(
                        argument("text", StringArgumentType.string())
                                .executes(context -> {
                                    final String text = StringArgumentType.getString( context, "text");
                                    WarpLogic.requestWarpByText(context, text);
                                    return 1;
                                })
                )
        ));
        CommandRegistrationEvent.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(literal("respawn")
                .requires(source -> source.hasPermissionLevel(2)).executes(context -> {
                    WarpLogic.respawnAlive(context.getSource().getPlayer());
                    return 1;
                })));
    }

     */
}
