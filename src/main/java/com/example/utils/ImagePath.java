package com.example.utils;

import org.sikuli.script.Pattern;

public class ImagePath {
        private static String getResourcePath(String relativePath) {
                return ImagePath.class.getClassLoader().getResource(relativePath).getPath();
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

        public static final Pattern RandomSummon150 = new Pattern(
                        getResourcePath("images/general/RandomSummon150.png"));

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

        // Farm Meat
        public static final Pattern GWQuest150 = new Pattern(getResourcePath("images/templates/GW/GWQuest150.png"));
        public static final Pattern Ygg150 = new Pattern(getResourcePath("images/templates/GW/Ygg150.png"));
        public static final Pattern RewardScreen = new Pattern(getResourcePath("images/templates/GW/Reward150.png"));
        public static final Pattern Checker150 = new Pattern(getResourcePath("images/templates/GW/Checker150.png"));

        // CEQ
        public static final Pattern Kaguya150 = new Pattern(getResourcePath("images/templates/CEQ/Kaguya150.png"));

        // UBHN
        public static final Pattern RaidTargetUbhn = new Pattern(
                        getResourcePath("images/templates/Ubhn/RaidTargetUbhn.png"));
        public static final Pattern UbhnPending150 = new Pattern(
                        getResourcePath("images/templates/Ubhn/UbhnPending150.png"));

}