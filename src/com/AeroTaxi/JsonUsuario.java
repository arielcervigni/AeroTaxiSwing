package com.AeroTaxi;

import com.google.gson.*;

import java.io.*;
import java.util.ArrayList;

public class JsonUsuario {

    public Gson gson = new Gson();

    public JsonUsuario() {

    }

    public ArrayList<Usuario> traerUsuarios (File file) {
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = null;
        BufferedReader bf;
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            bf = new BufferedReader(new FileReader(file));
            jsonElement = jsonParser.parse(bf);
            bf.close();
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }

        if (!jsonElement.isJsonNull()){
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            for (JsonElement je : jsonArray)
            {
                JsonObject jsonObject = je.getAsJsonObject();
                Usuario aux = gson.fromJson(jsonObject,Usuario.class);
                usuarios.add(aux);
            }
        }

        return usuarios;


    }

}
