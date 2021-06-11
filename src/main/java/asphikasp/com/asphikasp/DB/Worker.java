package asphikasp.com.asphikasp.DB;


import java.util.ArrayList;

public class Worker {

    private Long id;
    private String name;
    private int payment;

    public Worker(long id, String name, int payment){
        this.id = id;
        this.name = name;
        this.payment = payment;
    }

    public Worker(long id, String name){
        this.id = id;
        this.name = name;
    }

    public Worker(){
    }



    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }
}
