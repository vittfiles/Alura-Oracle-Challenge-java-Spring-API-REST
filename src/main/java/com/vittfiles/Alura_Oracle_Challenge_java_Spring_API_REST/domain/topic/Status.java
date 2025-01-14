package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic;

public enum Status {
    NO_ANSWER("SIN_RESPUESTA"),
    RESOLVED("RESUELTO"),
    SPAM("SPAM");

    private String spanishName;

    Status(String spanishName){
        this.spanishName = spanishName;
    }

    public static Status fromSpanishName(String spanishName){
        for(Status status : Status.values()){
            if(status.spanishName.equalsIgnoreCase(spanishName)){
                return status;
            }
        }
        throw new IllegalArgumentException("Status not found");
    }
}
