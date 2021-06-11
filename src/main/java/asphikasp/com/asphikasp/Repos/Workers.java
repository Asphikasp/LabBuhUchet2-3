package asphikasp.com.asphikasp.Repos;

import asphikasp.com.asphikasp.DB.PaymentHistory;
import asphikasp.com.asphikasp.DB.Worker;

import java.time.LocalDate;
import java.util.ArrayList;

public class Workers {

    private static Workers myInstance = null;

    private long id = 1;

    private ArrayList<Worker> workers = new ArrayList<>();
    private ArrayList<PaymentHistory> paymentHistories = new ArrayList<>();

    public static Workers getInstance(){
        if(myInstance == null){
            myInstance = new Workers();
        }
        return myInstance;
    }


    //CRUD realization for workers array

    //C
    public void create(String name, String payment){
        int intPayment;
        try{
            intPayment = Integer.parseInt(payment);
        } catch (NumberFormatException e){
            Worker worker = new Worker(id,name);
            workers.add(worker);
            id++;
            return;
        }
        Worker worker = new Worker(id,name,intPayment);
        workers.add(worker);
        id++;
    }
    public void create(){
    }
    //R
    public ArrayList<Worker> readAll(){
        return workers;
    }
    public Worker readById(Long id){
        for (Worker worker:workers) {
            if(worker.getId().equals(id)){
                return worker;
            }
        }
        return null;
    }
    public boolean existById(Long id){
        Worker test = readById(id);
        if(test == null){
            return false;
        }
        return true;
    }
    //U
    public void update(Long id, Long id2){
        for(Worker worker: workers){
            if(id2 == worker.getId()){
                return;
            }
        }
        for(Worker worker: workers){
            if(id == worker.getId()){
                worker.setId(id2);
                return;
            }
        }
    }
    public void update(Long id, int payment){
        for(Worker worker: workers){
            if(id.equals(worker.getId())){
                worker.setPayment(payment);
                return;
            }
        }
    }
    public void update(Long id, String name, String payment){
        int intValue;
        try{
            intValue = Integer.parseInt(payment);
        } catch (NumberFormatException e){
            for(Worker worker: workers){
                if(id.equals(worker.getId())){
                    worker.setName(name);
                    return;
                }
            }
            return;
        }
        for(Worker worker: workers){
            if(id.equals(worker.getId())){
                worker.setName(name);
                worker.setPayment(intValue);
                return;
            }
        }
    }
    //D
    public void delete(Long id){
        for(Worker worker: workers){
            if(id.equals(worker.getId())){
                deleteHById(worker.getId());
                workers.remove(worker);
                return;
            }
        }

    }
    public void deleteH(Long id, String date){
        for (PaymentHistory ph: paymentHistories) {
            if(ph.getId().equals(id) && ph.getDate().equals(date)){
                paymentHistories.remove(ph);
                return;
            }
        }
    }
    //CRUD realization for paymentHistories

    //C
    public void createH(Worker worker, String value){
        for (PaymentHistory ph: paymentHistories) {
            if(ph.getDate().equals(LocalDate.now().toString()) && ph.getId().equals(worker.getId()))
                return;
        }
        int intValue;
        try{
            intValue = Integer.parseInt(value);
        } catch (NumberFormatException e){
            PaymentHistory paymentHistory = new PaymentHistory(worker.getId(), LocalDate.now().toString(), 0);
            paymentHistories.add(paymentHistory);
            return;
        }
        PaymentHistory paymentHistory = new PaymentHistory(worker.getId(), LocalDate.now().toString(),intValue);
        paymentHistories.add(paymentHistory);
    }
    public void payday(){
        for (Worker worker: workers) {
            createH(worker,Integer.toString(worker.getPayment()));
        }
    }
    //R
    public ArrayList<PaymentHistory> readAllH(){
        return paymentHistories;
    }
    public ArrayList<PaymentHistory> readAllHById(Long id){
        ArrayList<PaymentHistory> ph = new ArrayList<>();
        for (PaymentHistory paymentHistory: paymentHistories) {
            if(paymentHistory.getId().equals(id)){
                ph.add(paymentHistory);
            }
        }
        return ph;
    }
    //U
    public void updateH(){

    }
    //D
    public void deleteHById(Long id){
        paymentHistories.removeIf(paymentHistory -> id.equals(paymentHistory.getId()));
    }


}
