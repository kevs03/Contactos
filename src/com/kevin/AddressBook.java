package com.kevin;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddressBook {
    private HashMap<String,String> contactos = new HashMap<>();

    public void load() throws IOException{
        String separador = FileSystems.getDefault().getSeparator();
        String fileName = String.format("src%scom%skevin%scontactos.csv",separador,separador,separador);
        Path path = Paths.get(fileName);
        ArrayList<String> lines = new ArrayList<>();

        if (!Files.exists(path)){
            File file = new File(String.valueOf(path));
            file.createNewFile();
        }
        lines = (ArrayList<String>) Files.readAllLines(path);

        for (var contacto : lines){
            var infoContacto = contacto.split(",");
            contactos.put(infoContacto[0].trim(),infoContacto[1].trim());
        }
    }

    public void save() throws IOException{
        String separator = FileSystems.getDefault().getSeparator();
        String fileName = String.format("src%scom%skevin%scontactos.csv",separator,separator,separator);
        Path path = Paths.get(fileName);

        ArrayList<String> saveContactos = new ArrayList<>();

        for (var contacto : contactos.entrySet()){
            saveContactos.add(contacto.getKey() + ", " + contacto.getValue());
        }
        Files.write(path,saveContactos);
    }

    public void list() throws IOException{
        for(var contact : contactos.entrySet()){
            System.out.println(String.format("Numero: %s, Nombre: %s",
                    contact.getKey(),contact.getValue()));
        }
        if (contactos.entrySet().isEmpty()){
            System.out.println("Aun no hay contactos guardados");
        }
    }

    public void create(String nombre, String telefono) throws IOException {
        contactos.put(telefono,nombre);
        save();
        load();
    }

    public void delete(String telefono) throws IOException {
        var del = contactos.remove(telefono);
        save();
        load();
    }
}
