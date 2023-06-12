package com.ngrok.basic.model;

import java.util.List;

public class Data {
    private String id;
    private String type;
    private String self;

    private String html_url;
    private String number;

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    private String status;
    private String incident_key;
    private String created_at;
    private String title;
    private Service service;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIncident_key() {
        return incident_key;
    }

    public void setIncident_key(String incident_key) {
        this.incident_key = incident_key;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<Assignee> getAssignees() {
        return assignees;
    }

    public void setAssignees(List<Assignee> assignees) {
        this.assignees = assignees;
    }

    public Escalation_policy getEscalation_policy() {
        return escalation_policy;
    }

    public void setEscalation_policy(Escalation_policy escalation_policy) {
        this.escalation_policy = escalation_policy;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public String getConference_bridge() {
        return conference_bridge;
    }

    public void setConference_bridge(String conference_bridge) {
        this.conference_bridge = conference_bridge;
    }

    public String getResolve_reason() {
        return resolve_reason;
    }

    public void setResolve_reason(String resolve_reason) {
        this.resolve_reason = resolve_reason;
    }

    private List<Assignee> assignees;

    public Data() {
    }

    private Escalation_policy escalation_policy;
    private List<Team> teams;
    private Priority priority;
    private String urgency;
    private String conference_bridge;
    private String resolve_reason;
}
