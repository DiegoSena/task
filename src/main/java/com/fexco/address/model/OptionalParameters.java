package com.fexco.address.model;

/**
 * Created by Denize on 15/11/2016.
 */
public class OptionalParameters {
    private String lines;
    private String include;
    private String exclude;
    private String addtags;
    private String identifier;
    private String callback;
    private String page;

    public OptionalParameters(String lines, String include, String exclude, String addtags, String identifier, String callback, String page) {
        this.lines = lines;
        this.include = include;
        this.exclude = exclude;
        this.addtags = addtags;
        this.identifier = identifier;
        this.callback = callback;
        this.page = page;
    }

    public static OptionalParametersBuilder builder(){
        return new OptionalParametersBuilder();
    }

    public String getLines() {
        return lines;
    }

    public String getInclude() {
        return include;
    }

    public String getExclude() {
        return exclude;
    }

    public String getAddtags() {
        return addtags;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getCallback() {
        return callback;
    }

    public String getPage() {
        return page;
    }

    public static class OptionalParametersBuilder{
        private String lines;
        private String include;
        private String exclude;
        private String addtags;
        private String identifier;
        private String callback;
        private String page;

        public OptionalParametersBuilder lines(String lines){
            this.lines = lines;
            return this;
        }

        public OptionalParametersBuilder include(String include){
            this.include = include;
            return this;
        }

        public OptionalParametersBuilder exclude(String exclude){
            this.exclude = exclude;
            return this;
        }

        public OptionalParametersBuilder addtags(String addtags){
            this.addtags = addtags;
            return this;
        }

        public OptionalParametersBuilder identifier(String identifier){
            this.identifier = identifier;
            return this;
        }

        public OptionalParametersBuilder callback(String callback){
            this.callback = callback;
            return this;
        }

        public OptionalParametersBuilder page(String page){
            this.page = page;
            return this;
        }

        public OptionalParameters build(){
            return new OptionalParameters(lines,include,exclude,addtags,identifier,callback,page);
        }
    }
}
