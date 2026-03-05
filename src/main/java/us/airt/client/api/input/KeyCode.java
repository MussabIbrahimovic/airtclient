package us.airt.client.api.input;

public enum KeyCode {
    RIGHT_SHIFT(344);

    private final int code;

    KeyCode(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }

    public static KeyCode fromCode(int code) {
        for (KeyCode keyCode : values()) {
            if (keyCode.code == code) {
                return keyCode;
            }
        }
        return null;
    }
}
