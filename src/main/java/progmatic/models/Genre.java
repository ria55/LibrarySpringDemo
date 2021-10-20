package progmatic.models;

public enum Genre {

    // any changes in this order may cause unexpected problems

    UNKNOWN("nem ismert"),
    LITERARY("szépirodalom"),
    FANTASY("fantasy"),
    SCIENCE_FICTION("tudományos fantasztikus"),
    CRIME("krimi"),
    THRILLER("thriller"),
    HISTORICAL("történelmi"),
    ROMANCE("romantikus"),
    YOUNG_ADULT("ifjúsági"),
    CHILDREN("gyerekirodalom");

    public final String HUN_NAME;

    Genre(String hunName) {
        HUN_NAME = hunName;
    }

}
