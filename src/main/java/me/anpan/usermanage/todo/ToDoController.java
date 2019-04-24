package me.anpan.usermanage.todo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo")
public class ToDoController {

    @GetMapping("/list")
    public String getToDoList() {
        return "/member/todo.html";
    }
}
