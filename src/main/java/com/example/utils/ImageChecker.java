package main.java.com.example.utils;

import org.sikuli.script.Pattern;

public class ImageChecker {
    private static String getResourcePath(String relativePath) {
        return ImageChecker.class.getClassLoader().getResource(relativePath).getPath();
    }

    // General images
    public static final Pattern MaxBackup150 = new Pattern(
            getResourcePath("images/general/MaxBackup150.png"));
    public static final Pattern PendingBattle150 = new Pattern(
            getResourcePath("images/general/PendingBattle150.png"));
    public static final Pattern PartyOkBTN = new Pattern(
            getResourcePath("images/general/PartyOkButton150.png"));
    public static final Pattern YourTurn150 = new Pattern(
            getResourcePath("images/general/YourTurn150.png"));
    public static final Pattern LoadingSplash150 = new Pattern(
            getResourcePath("images/general/LoadingSplash150.png"));
    public static final Pattern BackButton150 = new Pattern(
            getResourcePath("images/general/BackButton150.png"));

    // Templates images path below

    // Akasha
    public static final Pattern RaidTargetAkasha = new Pattern(
            getResourcePath("images/templates/akasha/RaidTargetAkasha.png"));
    public static final Pattern PendingBookmark = new Pattern(
            getResourcePath("images/templates/akasha/PendingBookmark.png"));
    public static final Pattern AkashaPending150 = new Pattern(
            getResourcePath("images/templates/akasha/AkashaPending150.png"));
    public static final Pattern Hades150 = new Pattern(
            getResourcePath("images/templates/akasha/Hades150.png"));
    public static final Pattern Bubz150 = new Pattern(
            getResourcePath("images/templates/akasha/Bubz150.png"));
    public static final Pattern RaidBookmark = new Pattern(
            getResourcePath("images/templates/akasha/RaidBookmark.png"));
}