# AIRT.US Client (Foundation)

This repository now contains a **working Java 21 foundation** for the AIRT.US client architecture with:

- Module system and module registry
- 7-category module catalog with broad feature coverage descriptors
- Priority-based event bus
- JSON/YAML config service
- Profile manager
- JavaScript engine facade
- Version support constants for `1.8.9` through `1.21.1`

## Build

```bash
./gradlew test
```

or

```bash
gradle test
```

## Notes

This is the implementation baseline intended for incremental expansion into full per-module runtime behavior.
