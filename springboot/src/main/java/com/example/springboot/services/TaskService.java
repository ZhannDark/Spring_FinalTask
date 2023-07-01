package com.example.springboot.services;

import com.example.springboot.model.Tasks;
import com.example.springboot.repository.TasksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final FolderService folderService;
    private final TasksRepository tasksRepository;
    public void addTask(Tasks tasks, Long folder_id){
        tasks.setStatus(0);
        tasks.setFolders(folderService.getFolder(folder_id));
        tasksRepository.save(tasks);
    }

    public Tasks getTask(Long id){
        return tasksRepository.findById(id).orElseThrow();
    }

    public List<Tasks> findAllById(Long id){
        return tasksRepository.findAllByFolders_Id(id);
    }

    public void updateTask(Tasks tasks, Long id){
        tasks.setFolders(folderService.getFolder(id));
        tasksRepository.save(tasks);
    }

    public void deleteTask(Long id){
        tasksRepository.deleteById(id);
    }

    public void deleteAllTask(Long id){
        tasksRepository.deleteByFolders_Id(id);
    }

}
