package ru.vsu.cs.elfimov_k_d.model;

public class Workers {
    private final int id;
    private final String firstName;
    private final String secondName;
    private final int qualification;

    public Workers(int id, String firstName, String secondName, int qualification) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.qualification = qualification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Workers)) {
            return false;
        }

        Workers worker = (Workers) o;

        if (hashCode() != o.hashCode()) {
            return false;
        }

        if (id != worker.id) return false;
        if (qualification != worker.qualification) return false;
        if (firstName != null ? !firstName.equals(worker.firstName) : worker.firstName != null) return false;
        return secondName != null ? secondName.equals(worker.secondName) : worker.secondName == null;
    }

    @Override
    public String toString() {
        return String.format("%s %s: qualification = %d;", this.firstName, this.secondName, this.qualification);
    }

    @Override
    public int hashCode(){
        return 31 * id;
    }

    public int getId() {
        return id;
    }

    public int getQualification() {
        return qualification;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }
}