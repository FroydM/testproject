package com.mycompany.refactoringplus.Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Oscar
 */

public class ChatGPTClient {
    
    public ChatGPTClient(){
        
    }
    
    /**
     * Make a request to chatgpt to get an answer
     * @return chat GPT 3.5-turbo output request
     */
    public static String consultChatGPT(String prompt){
        
        String url = "https://api.openai.com/v1/chat/completions";
        String apiKey = "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";
        String model = "gpt-3.5-turbo";
        int maxRetries = 3; // Maximum number of retries
        int retryDelay = 1000; // Initial retry delay in milliseconds

        for (int retry = 0; retry < maxRetries; retry++) {
            try {
                URL obj = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Authorization", "Bearer " + apiKey);
                connection.setRequestProperty("Content-Type", "application/json");

                // The request body
                String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + prompt + "\"}]}";
                connection.setDoOutput(true);
                OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
                writer.write(body);
                writer.flush();
                writer.close();

                // Response from ChatGPT
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
                String line;

                StringBuffer response = new StringBuffer();

                while ((line = br.readLine()) != null) {
                    response.append(line);
                }
                br.close();

                String chatGPTOut = extractMessageFromJSONResponse(response.toString());
                //System.out.println(chatGPTOut);
                return chatGPTOut;

            } catch (IOException e) {
                // Retry on IOException
                System.out.println("Error: " + e.getMessage());
                System.out.println("Retry attempt: " + (retry + 1));
                try {
                    // Implement exponential backoff by doubling the delay time on each retry
                    Thread.sleep(retryDelay);
                    retryDelay *= 2;
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            } 
        } return "No description from Chat GPT";

    }
    
    
    private static String extractMessageFromJSONResponse(String response) {
        
       int start = response.indexOf("content")+ 11;
       int end = response.indexOf("\"", start);
       
       return response.substring(start, end);

   }
    
}

