
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileManipulator {
    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();

        try {
            // Leggi il file di testo (.txt)
            BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Aggiungi ogni linea letta alla lista
                lines.add(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> processedLines = processLines(lines);
        try {
            // Scrivi le linee elaborate in un file di output (.txt)
            FileWriter fileWriter = new FileWriter("output.txt");
            String title = "Title\n\n";
            String start = "*\t";
            String end = "\n";
            for(String line : printTitle(title)){
                fileWriter.write(line);
            }

            title = "no mod\n\n";
            for(String line : printTitle(title)){
                fileWriter.write(line);
            }
            for (String processedLine : processedLines) {
                fileWriter.write(start + processedLine + end);
            }
            title = "maiusc\n\n";
            for(String line : printTitle(title)){
                fileWriter.write(line);
            }
            for (String processedLine : maiuscList(processedLines)) {
                fileWriter.write(start + processedLine + end);
            }
            title = "min\n\n";
            for(String line : printTitle(title)){
                fileWriter.write(line);
            }
            for (String processedLine : minList(processedLines)) {
                fileWriter.write(start + processedLine + end);
            }
            title = "underscore\n\n";
            for(String line : printTitle(title)){
                fileWriter.write(line);
            }
            for (String processedLine : underscoreList(processedLines)) {
                fileWriter.write(start + processedLine + end);
            }
            title = "camelCase\n\n";
            for(String line : printTitle(title)){
                fileWriter.write(line);
            }
            for (String processedLine : camelCaseList(processedLines)) {
                fileWriter.write(start + processedLine + end);
            }
            title = "maiusc + underscore\n\n";
            for(String line : printTitle(title)){
                fileWriter.write(line);
            }
            for (String processedLine : maiuscList(underscoreList(processedLines))) {
                fileWriter.write(start + processedLine + end);
            }
            title = "min + underscore\n\n";
            for(String line : printTitle(title)){
                fileWriter.write(line);
            }
            for (String processedLine : minList(underscoreList(processedLines))) {
                fileWriter.write(start + processedLine + end);
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static List<String> processLines(List<String> lines) {
        List<String> processedLines = new ArrayList<>();
    
        for (String line : lines) {
            // Rimuovi i punti e le virgole
            String processedLine = line.replaceAll("[.,]", " ");
    
            // Rimuovi i doppi spazi
            processedLine = processedLine.replaceAll("\\s{2,}", " ");
    
            processedLines.add(processedLine);
        }
        return processedLines;
    }

    //Maiusc
    private static List<String> maiuscList(List<String> lines) {
        List<String> processedLines = new ArrayList<>();
        for (String line : lines) {
            //Maiusc
            String processedLine = line.toUpperCase();
            processedLines.add(processedLine);
        }
        return processedLines;
    }

    //Min
    private static List<String> minList(List<String> lines) {
        List<String> processedLines = new ArrayList<>();
        for (String line : lines) {
            //Min
            String processedLine = line.toLowerCase();
            processedLines.add(processedLine);
        }
        return processedLines;
    }

    //Underscore
    private static List<String> underscoreList(List<String> lines) {
        List<String> processedLines = new ArrayList<>();    
        for (String line : lines) {
            // Sostituisci spazi con underscore e converti in minuscolo
            String processedLine = line.replaceAll(" ", "_").toLowerCase();
            processedLines.add(processedLine);
        }
        
        return processedLines;
    }
    
    //CamelCase
    private static List<String> camelCaseList(List<String> lines) {
        List<String> processedLines = new ArrayList<>();
        
        for (String line : lines) {
            String[] words = line.split(" ");
        
            StringBuilder camelCaseBuilder = new StringBuilder();
            boolean isFirstWord = true;
            
            for (String word : words) {
                if (!word.isEmpty()) {
                    if (isFirstWord) {
                        camelCaseBuilder.append(word.toLowerCase());
                        isFirstWord = false;
                    } else {
                        camelCaseBuilder.append(word.substring(0, 1).toUpperCase());
                        camelCaseBuilder.append(word.substring(1).toLowerCase());
                    }
                }
            }
        
            processedLines.add(camelCaseBuilder.toString());
        }
        

        return processedLines;
    }

    //CamelCase
    private static List<String> printTitle(String title) {
        List<String> processedLines = new ArrayList<>();
        processedLines.add("\n******************************\n\n");
        processedLines.add(title + "******************************\n\n");
        return processedLines;
    }

}
