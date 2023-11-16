
package com.mycompany.refactoringplus.Classes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;


import java.io.FileWriter;
import java.io.Writer;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvBadConverterException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.opencsv.CSVWriter;
import java.io.File;


public class ReportAction {
    
    public static ArrayList<BitacoryEntry> bitlist = new ArrayList();
    
    
    public static String dbpath;
    
    public ReportAction(String db){
        dbpath = db;
        // Verificar la existencia de los archivos y configurar bitlist
        checkAndInitialize();
    }
    
    public static void checkAndInitialize() {
        File jsonFile = new File(dbpath+"reporting.json");
        

        if (jsonFile.exists()) {
            // Si existe el archivo JSON, cargar datos en bitlist desde el JSON
            loadBitlistFromJson();
        } else {
            // Si no existe, crear archivos en blanco y bitlist vacío
            createEmptyFiles();
        }
    }
    
    public static void loadBitlistFromJson() {
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Configuración para ignorar las diferencias de mayúsculas y minúsculas
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            File jsonFile = new File(dbpath+"reporting.json");

            // Verificar si el archivo JSON existe antes de intentar cargarlo
            if (jsonFile.exists()) {
                bitlist = objectMapper.readValue(jsonFile, new TypeReference<ArrayList<BitacoryEntry>>() {});
            } else {
                System.out.println("El archivo JSON no existe. Devolviendo una lista vacía.");
                bitlist = new ArrayList<>();
            }
        } catch (IOException e) {
            System.out.println("Error al cargar datos desde el archivo JSON");
            e.printStackTrace();
        }
    }
    
    
    public static void createEmptyFiles() {
        // Crear archivos en blanco
        try {
            new File(dbpath+"reporting.json").createNewFile();
            new File(dbpath+"reporting.csv").createNewFile();
            new File(dbpath+"reporting.xml").createNewFile();
        } catch (IOException e) {
            System.out.println("Error al crear archivos en blanco");
        }
    }
    
    public static void reportAction(int format, String path) throws IOException, DocumentException{
        

        switch (format) {
            case 0:
               
                addToXML(path);
                break;
            case 1:
                addToCSV(path);
                break;
            case 2:
                addToJSON(path);
                break;
            default:
                break;
        }
        
        System.out.println(path);
        
    }
    
    
    public static String getCountryFromIp(String ipAddress) throws IOException {
        URL url = new URL("http://ipinfo.io/" + ipAddress + "/json");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        StringBuilder jsonResponse;
        try ( // Obtener la respuesta JSON
                Scanner scanner = new Scanner(connection.getInputStream())) {
            jsonResponse = new StringBuilder();
            while (scanner.hasNext()) {
                jsonResponse.append(scanner.next());
            }
        }

        // Analizar la respuesta JSON para obtener el país
        String country = "Desconocido";
        if (jsonResponse.length() > 0) {
            String[] parts = jsonResponse.toString().split(",");
            for (String part : parts) {
                if (part.contains("\"country\"")) {
                    country = part.split(":")[1].replaceAll("\"", "").trim();
                    break;
                }
            }
        }
        return country;
    }
    
    
    // Función para agregar a archivo XML
    @SuppressWarnings("empty-statement")
    public static void addToXML(String path) throws DocumentException, UnsupportedEncodingException, IOException {
       

        Document document = DocumentHelper.createDocument();

        Element root = document.addElement("root"); // Cambiado el nombre del elemento raíz
        
        int count = 0;
        for(BitacoryEntry b: bitlist){
            Element bitacoryElement = root.addElement("bitacory"+String.valueOf(count));
            bitacoryElement.addElement("format").addText(b.getFormat());
            bitacoryElement.addElement("action").addText(b.getAction());
            bitacoryElement.addElement("ip").addText(b.getIp());
            bitacoryElement.addElement("date").addText(b.getDate());
            bitacoryElement.addElement("country").addText(b.getCountry());
            count++;
        }


        // Escribir el documento XML en el archivo especificado por path
        try (FileWriter fileWriter = new FileWriter(path)) {
            OutputFormat formatXml = OutputFormat.createPrettyPrint();
            XMLWriter writer = new XMLWriter(fileWriter, formatXml);
            writer.write(document);
        } catch (IOException e) {
            System.out.println("Error adding reporting action");
        }
        
    }

    // Función para agregar a archivo CSV
    public static void addToCSV(String path) throws IOException {
        
     
        try (CSVWriter writer = new CSVWriter(new FileWriter(path))) {

            // Arrange column name as provided in below array.
            String[] columns = new String[] { "Format", "Action", "Ip", "Date", "Country" };
            writer.writeNext(columns); // Escribir encabezados

            // Escribir datos de bitlist al archivo CSV
            for (BitacoryEntry b : bitlist) {
                String[] data = new String[] { b.getFormat(), b.getAction(), b.getIp(), b.getDate(), b.getCountry() };
                writer.writeNext(data);
            }
        } catch (IOException e) {
            System.out.println("Error adding reporting action");
        }
        
    }

    // Función para agregar a archivo JSON
    public static void addToJSON(String path) {
        
        try {

            // Creating ObjectMapper object
            ObjectMapper mapper = new ObjectMapper();

            // Configure the mapper to pretty-print the JSON
            //mapper.enable(SerializationFeature.INDENT_OUTPUT);

            // Write list to JSON file
            mapper.writeValue(new File(path), bitlist);

        } catch (IOException e) {
            System.out.println("Error adding reporting action");
        }
        
    }
    
    
    public static void addtobitlist(int format, String action, String ip, String date) throws IOException{
        
        String country = getCountryFromIp(ip);
        
        BitacoryEntry b = new BitacoryEntry(String.valueOf(format), action, ip, date, country);
        bitlist.add(b);
    }
    
    
    

    public static String readXmlFile() {
        try {
            byte[] xmlData = Files.readAllBytes(Paths.get(dbpath+"reporting.xml"));
            return new String(xmlData);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo XML");
            return null;
        }
    }
    
    public static String readCsvFile() {
        try {
            byte[] csvData = Files.readAllBytes(Paths.get(dbpath+"reporting.csv"));
            return new String(csvData);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV");
            return null;
        }
    }
    
    
    public static String readJsonFile() {
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get(dbpath+"reporting.json"));
            return new String(jsonData);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo JSON");
            return null;
        }
    }
    
    
    
}
