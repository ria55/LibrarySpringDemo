package progmatic.models;

public enum BookState {

    // any changes in this order may cause unexpected problems

    UNCATEGORIZED("kategória nélküli"),
    DISCARDED("selejt"),
    POOR("szétesik"),
    GOOD("jó"),
    BRAND_NEW("új");

    public final String HUN_NAME;

    BookState(String hunName) {
        HUN_NAME = hunName;
    }

}
