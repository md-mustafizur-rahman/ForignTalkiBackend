package org.example.foringtalkibackend.DTO;

public class TranslateDTO {
    private String text;
    private String sourceLanguage;
    private String targetLanguage;

    public String getText() {
        return text;
    }

    public TranslateDTO setText(String text) {
        this.text = text;
        return this; // Return the current object to enable chaining
    }

    public String getSourceLanguage() {
        return sourceLanguage;
    }

    public TranslateDTO setSourceLanguage(String sourceLanguage) {
        this.sourceLanguage = sourceLanguage;
        return this; // Return the current object to enable chaining
    }

    public String getTargetLanguage() {
        return targetLanguage;
    }

    public TranslateDTO setTargetLanguage(String targetLanguage) {
        this.targetLanguage = targetLanguage;
        return this; // Return the current object to enable chaining
    }
}
