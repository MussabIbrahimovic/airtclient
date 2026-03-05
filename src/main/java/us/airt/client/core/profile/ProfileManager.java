package us.airt.client.core.profile;

import us.airt.client.core.config.ConfigService;

import java.io.IOException;
import java.nio.file.Path;

public final class ProfileManager {
    private final ConfigService configService;
    private final Path profileDirectory;

    public ProfileManager(ConfigService configService, Path profileDirectory) {
        this.configService = configService;
        this.profileDirectory = profileDirectory;
    }

    public void save(Profile profile) throws IOException {
        configService.saveJson(profileDirectory.resolve(profile.name() + ".json"), profile);
    }

    public Profile load(String name) throws IOException {
        return configService.loadJson(profileDirectory.resolve(name + ".json"), Profile.class);
    }
}
