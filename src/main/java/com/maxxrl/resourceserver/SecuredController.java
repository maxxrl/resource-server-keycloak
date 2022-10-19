package com.maxxrl.resourceserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class SecuredController {

    @GetMapping(path = "/secured")
    public DoubleSlash securedHelloWorld() {
        return new DoubleSlash("Hello from doubleSlash secured");
    }

    @GetMapping(path = "/unsecured")
    public DoubleSlash unsecuredHelloWorld() {
        return new DoubleSlash("Hello from doubleSlash unsecured");
    }

    class DoubleSlash {
        private final String content;

        public DoubleSlash(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }

    }
}
