package task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/test")
    public String showTestPage() {
        return "test"; // соответствует test.html в /WEB-INF/views/
    }
}
