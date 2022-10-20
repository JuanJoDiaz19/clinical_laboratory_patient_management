package model;

import model.Patient;

public class NodeUndoStack {
    boolean action;
    Patient patient;

    public NodeUndoStack(boolean action, Patient patient) {
        this.action = action;
        this.patient = patient;
    }

    public boolean isAction() {
        return action;
    }

    public void setAction(boolean action) {
        this.action = action;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
