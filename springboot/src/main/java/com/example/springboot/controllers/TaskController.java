package com.example.springboot.contollers;

import com.example.springboot.model.Tasks;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.springboot.services.TaskService;

@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping(value = "/add-task")
    public String addTask(Tasks tasks, @RequestParam(name = "folder_id") Long folder_id){
        taskService.addTask(tasks, folder_id);
        return "redirect:/details/" + folder_id;
    }

    @PostMapping(value = "/view-task/{taskId}")
    public String detailsTask(@PathVariable(name = "taskId") Long id, Model model){
        model.addAttribute("task", taskService.getTask(id));
        return "taskDetails";
    }
    @PostMapping(value = "/updateTask")
    public String updateTask(Tasks tasks, @RequestParam(name = "folder_id") Long id,
                             @RequestParam(name = "task_id") Long taskId){
        tasks.setId(taskId);
        taskService.updateTask(tasks, id);
        return "redirect:/details/" + id;
    }

    @PostMapping(value = "/delete-task")
    public String deleteTask(@RequestParam(name = "id") Long id){
        taskService.deleteTask(id);
        return "redirect:/";
    }


}
