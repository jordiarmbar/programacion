/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view.console;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Scanner;
import static model.Funciones.countChars;
import static model.Funciones.countWords;
import static model.Funciones.createFile;
import static model.Funciones.createFolder;
import static model.Funciones.deleteFile;
import static model.Funciones.overWriteFile;
import static model.Funciones.showFile;
import static model.Funciones.showListFiles;
/**
 *
 * @author jordiarmbar
 */
public class Main {
    
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String fileName = "E:\\Programación 0485\\fichero_ejemplo.txt";
        String path = "E:\\Programación 0485\\GestionFicheros\\";
        String opcion = null;
        do{
        

            try{
                System.out.println("-- GESTIoN DE FICHEROS --");
                System.out.println("Elige las siguientes opciones:");
                System.out.println("1. Crear una carpeta");
                System.out.println("2. Crear archivo");
                System.out.println("3. Ver listado archivos");
                System.out.println("4. Ver contenido del archivo");
                System.out.println("5. Modificar archivo");
                System.out.println("6. Borrar archivo");
                System.out.println("7. Contar caracteres");
                System.out.println("8. Contar palabras");
                System.out.println("Z. Salir");
                System.out.print("Opcion: ");
                opcion = keyboard.next();

                switch (opcion) {
                    case "1":
                        System.out.print("Escribe el nombre de la carpeta: ");
                        String folderName = keyboard.next();
                        createFolder(folderName);
                        System.out.println(" ");
                        break;
                        
                    case "2":
                                              
                        System.out.print("Escribe el nombre del archivo: ");
                        fileName = keyboard.next();

                        // Asegurarse de que tenga la extensión .txt
                        if (!fileName.toLowerCase().endsWith(".txt")) {
                            fileName += ".txt";
                        }

                        keyboard.nextLine(); // Limpiar el buffer después de next()
                        System.out.print("Escribe el contenido del archivo: ");
                        String content = keyboard.nextLine();

                        createFile(path, fileName, content);
                        System.out.println(" ");
                        break;
                        
                    case "3":
                        System.out.println(" ");
                        showListFiles(path);
                        System.out.println(" ");
                        break;
                        
                    case "4":
                        System.out.print("Escribe el nombre del archivo a mostrar: ");
                        String fileToShow = keyboard.next();
                        
                        System.out.println(" ");
                        String contenido = showFile(path, fileToShow);
                        System.out.print("Contenido del archivo: ");
                        System.out.print(contenido);
                                                
                        System.out.println(" ");
                        break;
                        
                    case "5":
                        System.out.print("Nombre del archivo a modificar: ");
                        fileName = keyboard.next();

                        keyboard.nextLine(); 
                        System.out.print("Nuevo contenido: ");
                        String newContent = keyboard.nextLine();

                        overWriteFile(path, fileName, newContent);
                     
                        System.out.println(" ");
                        break;
                    
                    case "6":
                        System.out.print("Elige el archivo que quieras borrar: ");
                        fileName = keyboard.next();
                        deleteFile(path, fileName);
                        
                        System.out.println(" ");
                        break;
                    
                    case "7":
                        System.out.print("Escribe el nombre del archivo: ");
                        fileName = keyboard.next();

                        int charCount = countChars(path, fileName);

                        if (charCount == -1) {
                            System.out.println("El archivo no existe o no es válido.");
                        } else {
                            System.out.println("Numero de caracteres: " + charCount);
                        }
                        System.out.println(" ");
                        break;
                    
                    case "8":
                        System.out.print("Nombre del archivo: ");
                        fileName = keyboard.next();

                        int wordCount = countWords(path, fileName);

                        if (wordCount == -1) {
                            System.out.println("El archivo no existe o no es válido.");
                        } else {
                            System.out.println("Numero de palabras: " + wordCount);
                        }
                        System.out.println(" ");
                        break;
                    
                    default:
                        System.out.println("Opcion incorrecta");
                }   
            }catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
            
        }while (!opcion.equals("Z"));
    }
    

}
