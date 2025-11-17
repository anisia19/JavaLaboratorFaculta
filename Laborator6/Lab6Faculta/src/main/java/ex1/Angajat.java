package ex1;

import java.time.LocalDate;

public class Angajat {
    private String numele;
    private String post;
    private LocalDate data_angajarii;
    private float salariul;

    public Angajat(String numele, String postul, LocalDate data_angajarii, float salariul) {
        this.numele = numele;
        this.post = postul;
        this.data_angajarii = data_angajarii;
        this.salariul = salariul;
    }

    public Angajat() {
    }

    public String getNumele() {
        return numele;
    }

    public void setNumele(String numele) {
        this.numele = numele;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public LocalDate getData_angajarii() {
        return data_angajarii;
    }

    public void setData_angajarii(LocalDate data_angajarii) {
        this.data_angajarii = data_angajarii;
    }

    public float getSalariul() {
        return salariul;
    }

    public void setSalariul(float salariul) {
        this.salariul = salariul;
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "numele='" + numele + '\'' +
                ", postul='" + post + '\'' +
                ", data_angajarii=" + data_angajarii +
                ", salariul=" + salariul +
                '}';
    }
}
