package de.thedesigncraft;

import de.thedesigncraft.discord.botstuff.essential.EmbedTemplates;
import de.thedesigncraft.discord.botstuff.essential.manage.commands.discord.slash.ISlashCommand;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CopyPermissionsSlashCommand implements ISlashCommand {
    @Override
    public @NotNull String name() {
        return ISlashCommand.super.name();
    }

    @Override
    public @Nullable List<OptionData> options() {
        List<OptionData> returnList = new ArrayList<>();
        returnList.add(new OptionData(OptionType.ROLE, "source", "The role to copy the permissions from", true));
        returnList.add(new OptionData(OptionType.ROLE, "target", "The role to copy the permissions to", true));
        return returnList;
    }

    @Override
    public @NotNull String version() {
        return "v1.0.0-alpha.1";
    }

    @Override
    public @NotNull String category() {
        return "Test";
    }

    @Override
    public @NotNull String description() {
        return "Copies the permissions from one role to another";
    }

    @Override
    public boolean globalCommand() {
        return true;
    }

    @Override
    public @Nullable List<Guild> guilds() {
        return null;
    }

    @Override
    public boolean guildOnly() {
        return true;
    }

    @Override
    public @NotNull Emoji commandEmoji() {
        return Emoji.fromUnicode("U+1F9EA");
    }

    @Override
    public @Nullable List<Permission> requiredPermissions() {
        return Collections.singletonList(Permission.MANAGE_ROLES);
    }

    @Override
    public void performSlashCommand(@NotNull SlashCommandInteractionEvent event) {

        Guild guild = event.getGuild();

        try {
            guild.getRoleById(event.getOption("target").getAsRole().getIdLong()).getManager().setPermissions(guild.getRoleById(event.getOption("source").getAsRole().getIdLong()).getPermissions()).queue();
            event.reply("Permissions copied").queue();
        } catch (Exception e) {
            event.replyEmbeds(EmbedTemplates.issueEmbed(e.getMessage(), false)).queue();
        }

    }

}
