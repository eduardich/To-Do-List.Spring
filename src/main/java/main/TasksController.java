

package main;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import main.model.Task;
import main.model.TaskRepo;
import main.model.Task.TaskStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping(
        path = {"/todolist"}
)
@Controller
public class TasksController {
    @Autowired
    private TaskRepo taskRepo;

    public TasksController() {
    }

    @GetMapping
    public String getAllTasks(Model model) {

        model.addAttribute("newTask", new Task());

        ArrayList<Task> list = new ArrayList<>();
        this.taskRepo.findAll().forEach(task -> list.add(task));
        model.addAttribute("list", list);

        return "todolist";

    }

    @PostMapping
    public String addTask(@ModelAttribute("newTask") Task newTask, Model model) {
        this.taskRepo.save(newTask);
        return "redirect:/todolist";
    }


    @DeleteMapping
    public String deleteAll() {
        this.taskRepo.deleteAll();
        return "redirect:/todolist";
    }

    //    Single action

    @DeleteMapping({"/{id}"})
    public String deleteTask(@PathVariable String id) {
        Task task = this.taskRepo.findById(Integer.parseInt(id)).get();
        this.taskRepo.delete(task);
        return "redirect:/todolist";
    }
    //    Single action

    @PatchMapping({"/{id}"})
    public String markAsDone(@PathVariable String id) {
        Task task = (Task) this.taskRepo.findById(Integer.parseInt(id)).get();
        task.setStatus(TaskStatus.DONE);
        this.taskRepo.save(task);
        return "redirect:/todolist";
    }

}
