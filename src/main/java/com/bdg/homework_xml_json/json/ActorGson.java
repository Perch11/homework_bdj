package com.bdg.homework_xml_json.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import net.bytebuddy.description.method.MethodDescription;

import java.io.*;

import java.lang.reflect.Type;
import java.util.List;

public class ActorGson {
    /**
     * Serializes an Actor object to JSON format using the Gson library and writes it to a file.
     * @param actor The Actor object to be serialized.
     * @param path The file path to which the serialized JSON data will be written.
     * @throws RuntimeException if there is an IOException when writing the serialized JSON data to the file.
     */
    public void serializeGson(Actor actor, File path) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (Writer writer = new FileWriter(path)) {
            gson.toJson(actor, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Serializes a List of Actor objects to JSON format using the Gson library and writes it to a file.
     * @param actors The List of Actor objects to be serialized.
     * @param path The file path to which the serialized JSON data will be written.
     * @throws RuntimeException if there is an IOException when writing the serialized JSON data to the file.
     */
    public void serializeListGson(List<Actor> actors, File path) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (Writer writer = new FileWriter(path)) {
            gson.toJson(actors, writer);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Deserializes an Actor object from a JSON file using the Gson library.
     * @param path The file path from which to read the JSON data.
     * @return The deserialized Actor object.
     * @throws RuntimeException if there is an IOException when reading the JSON data from the file.
     */
    public Actor desSerializeGson(File path) {

        Gson gson = new Gson();
        try (Reader reader = new FileReader(path)) {
            return gson.fromJson(reader, Actor.class);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    /**
     * Deserializes a List of Actor objects from a JSON file using the Gson library.
     * @param path The file path from which to read the JSON data.
     * @return The deserialized List of Actor objects.
     * @throws RuntimeException if there is an IOException when reading the JSON data from the file.
     */
    public List<Actor> deSerializeListGson(File path) {

        Gson gson = new Gson();
        try (Reader reader = new FileReader(path)) {
            Type listType = new TypeToken<List<Actor>>() {
            }.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
