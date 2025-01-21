package org.example.foringtalkibackend.Controller;

import org.example.foringtalkibackend.DTO.TranslateDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/translate")
public class TranslateController {

    private final WebClient webClient = WebClient.create("https://generativelanguage.googleapis.com");

    @PostMapping("/start")
    public Mono<String> startTranslate(@RequestBody TranslateDTO translateDTO) {
        System.out.println("flag");
        System.out.println(translateDTO.getText());
      return translateEngine(translateDTO.getText(), translateDTO.getSourceLanguage(), translateDTO.getTargetLanguage());
    }
    private Mono<String> translateEngine(String text, String sourceLanguage, String targetLanguage) {


            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("model", "gemini-pro");

            Map<String, Object> userContent = new HashMap<>();
            userContent.put("role", "user");
        userContent.put("parts", Arrays.asList(
                Map.of("text", "Translate this text " + text.replaceAll("\\n", "") + " to this language where the language code is "
                        + targetLanguage + ". Just provide only the translated text, nothing else. Remove any escape sequences or related expressions, and provide just the exact text.")
        ));


        requestBody.put("contents", Arrays.asList(userContent));


            return webClient.post()
                    .uri("/v1beta/models/gemini-1.5-flash:generateContent?key=AIzaSyBMx5M-RMPtZqo70n-fXYV-k_thnh5dH74")
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(String.class);

    }
}
