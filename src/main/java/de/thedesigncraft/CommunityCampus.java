package de.thedesigncraft;

import de.thedesigncraft.discord.botstuff.essential.manage.Main;
import de.thedesigncraft.discord.botstuff.essential.manage.commands.discord.manage.categories.CommandCategory;
import de.thedesigncraft.discord.botstuff.essential.manage.commands.discord.manage.categories.CommandCategoryBuilder;
import de.thedesigncraft.discord.botstuff.essential.manage.versions.Version;
import de.thedesigncraft.discord.botstuff.essential.manage.versions.VersionBuilder;
import de.thedesigncraft.discord.botstuff.essential.setup.StartupSetup;
import net.dv8tion.jda.api.entities.emoji.Emoji;

import java.util.Collections;
import java.util.List;

public class CommunityCampus extends StartupSetup {

    public static void main(String[] args) {

        setMainPackage("de.thedesigncraft");
        setProjectName("CommunityCampus");
        setVersions(versions());
        setCommandCategories(categories());
        setToken(Version.Type.ALPHA, "MTA3MTQ3NTE3NzM0NDQ3OTMwMw.GQhCqL.BegAtI6NKTW70vI_SviLEPQ9zFc_9giRQsTtQk");

        new Main();

    }

    private static List<Version> versions() {
        return Collections.singletonList(
                new VersionBuilder()
                        .setName("v1.0.0-alpha.1")
                        .setType(Version.Type.ALPHA)
                        .build()
        );
    }

    private static List<CommandCategory> categories() {
        return Collections.singletonList(
                new CommandCategoryBuilder()
                        .setName("Test")
                        .setEmoji(Emoji.fromUnicode("U+1F9EA"))
                        .build()
        );
    }

}
