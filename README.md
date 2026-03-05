# AIRT.US Client (Foundation)

This repository contains a Java 21 foundation for the AIRT.US client architecture with:

- Module system and module registry
- 7-category module catalog with broad feature coverage descriptors
- Priority-based event bus
- JSON/YAML config service
- Profile manager
- JavaScript engine facade
- Right Shift GUI toggle controller (ClickGUI state + renderer)
- Version support constants for `1.8.9` through `1.21.1`

## Build

```bash
gradle test
```

## GUI keybind

- **Right Shift** (`keyCode 344`) toggles the ClickGUI.
- In a Minecraft integration, forward keyboard events into `AirtClient#onKeyInput(int keyCode, boolean pressed)`.
- When open, call `AirtClient#renderClickGuiIfOpen()` from your render hook.

## Notes

This is still a baseline intended for incremental expansion into full in-game rendering and module behaviors.
