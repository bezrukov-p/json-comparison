package com.company.model.metadata;

public class Metadata {
    private Description description;
    private Application application;

    public Metadata() {
    }

    public Metadata(Description description, Application application) {
        this.description = description;
        this.application = application;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }
}
