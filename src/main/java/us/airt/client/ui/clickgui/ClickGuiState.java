package us.airt.client.ui.clickgui;

public final class ClickGuiState {
    private boolean open;

    public boolean isOpen() {
        return open;
    }

    public void open() {
        this.open = true;
    }

    public void close() {
        this.open = false;
    }

    public void toggle() {
        this.open = !this.open;
    }
}
