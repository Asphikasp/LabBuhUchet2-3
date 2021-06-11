package asphikasp.com.asphikasp.DB;

import java.util.ArrayList;

public class PaymentHistory {
    private Long id;
    private String date;
    private Integer value;

    public PaymentHistory(Long id, String date, Integer value) {
        this.id = id;
        this.date = date;
        this.value = value;
    }

    public PaymentHistory(Long id, String date) {
        this.id = id;
        this.date = date;
        this.value = 0;
    }

    public PaymentHistory() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
