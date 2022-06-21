package dk.swagger.diff.openapimerlin.controller;

import org.openapitools.openapidiff.core.OpenApiCompare;
import org.openapitools.openapidiff.core.model.ChangedOpenApi;
import org.openapitools.openapidiff.core.output.HtmlRender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.FileWriter;
import java.io.IOException;

@Controller
public class DiffController {

    @GetMapping("/diff")
    public String diff(Model model) {

        String OPENAPI_DOC1 = "D:\\swaggerapi-history\\one.json";
        String OPENAPI_DOC2 = "D:\\swaggerapi-history\\two.json";

        ChangedOpenApi diff = OpenApiCompare.fromLocations(OPENAPI_DOC1, OPENAPI_DOC2);

        String html = new HtmlRender("Changelog",
                "http://deepoove.com/swagger-diff/stylesheets/demo.css")
                .render(diff);

        System.out.println(html);
        model.addAttribute("tt", html);
//        try {
//            FileWriter fw = new FileWriter(
//                    "D:\\openapi-merlin\\src\\main\\resources\\templates\\test.html");
//            fw.write(html);
//            fw.close();
////            Thread.sleep(5000);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return "home";
    }
}
