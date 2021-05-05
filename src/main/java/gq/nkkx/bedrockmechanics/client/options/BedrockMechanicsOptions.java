package gq.nkkx.bedrockmechanics.client.options;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.moandjiezana.toml.Toml;
import com.moandjiezana.toml.TomlWriter;
import gq.nkkx.bedrockmechanics.BedrockMechanics;
import lombok.Data;
import lombok.Getter;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

@Data
@Getter
public class BedrockMechanicsOptions {

    private static final Gson gson = new GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create();

    private static final String FILE_NAME = "bedrock-mechanics.toml";

    @SerializedName("controller")
    private ControllerOptions controllerOptions;

    @SerializedName("mechanics")
    private MechanicsOptions mechanicsOptions;

    @SerializedName("gui")
    private GuiOptions guiOptions;

    public static BedrockMechanicsOptions init() throws IOException {
        File file = createParent(new File("config/" + FILE_NAME));
        if (!file.exists()) {
            BedrockMechanics.getLogger().info("Creating config file...");
            URL resource = BedrockMechanics.class.getClassLoader().getResource(FILE_NAME);
            if (resource == null) {
                throw new FileNotFoundException("Could not find the configuration resource.");
            }
            FileUtils.copyURLToFile(resource, file);
        }
        Map<String, Object> toml = new Toml().read(file).toMap();
        return gson.fromJson(gson.toJson(toml), BedrockMechanicsOptions.class);
    }

    private static File createParent(File file) throws IOException {
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            throw new IOException("Could not create the config folder.");
        }
        return file;
    }

    public void save() {
        try {
            new TomlWriter().write(this, createParent(new File("config/" + FILE_NAME)));
        } catch (IOException exception) {
            BedrockMechanics.getLogger().error("An error occurred while attempting to save the configuration.");
        }
    }

}
