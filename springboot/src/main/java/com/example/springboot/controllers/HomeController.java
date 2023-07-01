package com.example.springboot.contollers;

import com.example.springboot.model.Folders;
import com.example.springboot.services.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class HomeController {

    @Autowired
    private FolderService folderService;

    @GetMapping("/")
    public String mainPage(Model model){
        List<Folders> foldersList = folderService.allFolders();
        model.addAttribute("folders", foldersList);
        return "main_page";
    }
}
