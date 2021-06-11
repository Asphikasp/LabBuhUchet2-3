package asphikasp.com.asphikasp.controllers;

import asphikasp.com.asphikasp.DB.PaymentHistory;
import asphikasp.com.asphikasp.DB.Worker;
import asphikasp.com.asphikasp.Repos.Workers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WorkersController {



    @GetMapping("/worker")
    public String workersMain(Model model){
        Iterable<Worker> workers = Workers.getInstance().readAll();
        model.addAttribute("workers", workers);
        return "worker-main";
    }

    @PostMapping("/worker")
    public String workersPayday(Model model){
        Workers.getInstance().payday();
        return "redirect:/worker";
    }


    @GetMapping("/worker/add")
    public String workersAdd(Model model){
        Iterable<Worker> workers = Workers.getInstance().readAll();
        model.addAttribute("workers", workers);
        return "worker-add";
    }

    @PostMapping("/worker/add")
    public String workersWorkerAdd(@RequestParam String name, @RequestParam String payment, Model model){
        Workers.getInstance().create(name, payment);
        return "redirect:/worker";
    }

    @GetMapping("/worker/{id}")
    public String workersDetails(@PathVariable(value = "id") Long id,  Model model){
        if(!Workers.getInstance().existById(id)){
            return "redirect:/worker";
        }
        Worker worker = Workers.getInstance().readById(id);
        Iterable<PaymentHistory> paymentHistories = Workers.getInstance().readAllHById(id);
        model.addAttribute("worker",worker);
        model.addAttribute("paymentHistories",paymentHistories);
        return "worker-details";
    }

    @GetMapping("/worker/{id}/edit")
    public String workerEdit(@PathVariable(value = "id") Long id, Model model){

        model.addAttribute("worker", Workers.getInstance().readById(id));
        return "worker-edit";
    }

    @PostMapping("/worker/{id}/edit")
    public String workerUpdate(@RequestParam String name, @RequestParam String payment, @PathVariable(value = "id") Long id, Model model){
        if(!Workers.getInstance().existById(id)){
            return "redirect:/worker";
        }
        Workers.getInstance().update(id, name, payment);
        return "redirect:/worker/{id}";
    }

    @PostMapping("/worker/{id}/deleteWorker")
    public String workerDelete(@PathVariable(value = "id") Long id, Model model){
        if(!Workers.getInstance().existById(id)){
            return "redirect:/worker";
        }
        Workers.getInstance().delete(id);
        return "redirect:/worker";
    }

    @PostMapping("/worker/{id}/deleteHistory")
    public String workerHistoryDelete(@PathVariable(value = "id") Long id,@RequestParam String date, Model model){
        if(!Workers.getInstance().existById(id)){
            return "redirect:/worker";
        }
        Workers.getInstance().deleteH(id,date);
        return "redirect:/worker";
    }
}
