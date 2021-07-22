package model;

public enum Result {

    WIN("WIN"),

    LOSE("LOSE"),

    TIE("TIE"),

    UNSURE("UNSURE");

    String value;

    Result(String value) {
        this.value = value;
    }

    public String getValue()
    {
        return this.value;
    }
}
