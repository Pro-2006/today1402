package com.klu.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String index() {
        return "<html><body>"
                + "<h2>today1402 - Available endpoints</h2>"
                + "<ul>"
                + "<li><a href=\"/crud/alldata\">List all students (GET /crud/alldata)</a></li>"
                + "<li><a href=\"/crud/insertByParams?sname=Kumar&sdept=CSE\">Insert sample (GET /crud/insertByParams?sname=Kumar&sdept=CSE)</a></li>"
                + "<li><a href=\"/crud/get/1\">Get student id=1 (GET /crud/get/1)</a></li>"
                + "<li><a href=\"/crud/updateName/1?sname=NewName\">Update name for id=1 (GET /crud/updateName/1?sname=NewName)</a></li>"
                + "<li><a href=\"/crud/delete/1\">Delete id=1 (GET /crud/delete/1)</a></li>"
                + "<li><a href=\"/h2-console\">H2 Console</a></li>"
                + "</ul>"
                + "</body></html>";
    }
}
