/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Scanner;
/**
 *
 * @author jordiarmbar
 */
public class Funciones {
    /**
     * Crea una carpeta con el nombre especificado en el directorio actual del usuario,
     * si no existe previamente.
    */
    public static void createFolder(String folderName){
        String path = System.getProperty("user.dir");
        String separator = File.separator;
        String FolderRoute = path + separator + folderName;
        File carpeta = new File(FolderRoute);
        if(!carpeta.exists()){
            carpeta.mkdir(); // Crea la carpeta
        }
        
    }
    
    /**
     * Crea un archivo con el contenido especificado dentro del directorio indicado.
     * Si el archivo ya existe, se añade contenido al final.
    */
    
    public static void createFile(String path, String fileName, String content){
            File directory = new File(path);

        // Crear el directorio si no existe
        if (!directory.exists()) {
            directory.mkdirs();
        }

        File file = new File(directory, fileName);

        try (FileWriter writer = new FileWriter(file, true)) { // 'true' para añadir contenido
            writer.write(content + System.lineSeparator()); // Añade salto de línea al final
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
    
    /**
     * Muestra e imprime en consola una lista de los archivos en el directorio indicado.
     */

    public static String[] showListFiles(String path) throws IOException {
        File folder = new File(path);

        if (!folder.exists() || !folder.isDirectory()) {
            return new String[0];
        }

        String[] documentList = folder.list();

        if (documentList == null || documentList.length == 0) {
            return new String[0];
        }

        for (int i = 0; i < documentList.length; i++) {
            System.out.println(i + " - " + documentList[i]);
        }

        return documentList;
    }
    
    /**
     * Retorna el contenido completo de un archivo de texto.
     */
    
    public static String showFile(String path, String fileName) throws IOException {
        File file = new File(path, fileName); // Combina path y fileName


        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        }

        return content.toString();
    }
    
    /**
     * Sobrescribe el contenido de un archivo con nuevo texto.
     */ 
    
    public static boolean overWriteFile(String path, String fileName, String newContent) throws IOException {
        File file = new File(path, fileName);

        if (!file.exists() || !file.isFile()) {
            return false;
        }

        try (FileWriter writer = new FileWriter(file, false)) { // false = sobrescribir
            writer.write(newContent);
        }

        return true;
    }
    
    /**
     * Elimina un archivo específico.
     */
    
    public static void deleteFile(String path, String fileName){
        File file = new File(path, fileName);
        file.delete();
    }
    
    /**
     * Cuenta la cantidad total de caracteres en un archivo.
     */
    
     public static int countChars(String path, String fileName) throws IOException {
        File file = new File(path, fileName);

        if (!file.exists() || !file.isFile()) {
            return -1; // Indica que el archivo no existe o es inválido
        }

        int count = 0;
        try (FileReader reader = new FileReader(file)) {
            int ch;
            while ((ch = reader.read()) != -1) {
                count++;
            }
        }

        return count;
    }
     
     /**
     * Cuenta el número total de palabras en un archivo.
     */
     
    public static int countWords(String path, String fileName) throws IOException {
        File file = new File(path, fileName);

        if (!file.exists() || !file.isFile()) {
            return -1; // Archivo no válido
        }

        int wordCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.trim().split("\\s+"); // separa por espacios múltiples
                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }
        }

        return wordCount;
    }


}

