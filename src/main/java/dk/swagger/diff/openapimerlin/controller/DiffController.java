package dk.swagger.diff.openapimerlin.controller;

import org.openapitools.openapidiff.core.OpenApiCompare;
import org.openapitools.openapidiff.core.model.ChangedOpenApi;
import org.openapitools.openapidiff.core.output.HtmlRender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.util.*;

@Controller
public class DiffController {

    static String directory = "";

    public DiffController(@Value("${main.directory}") String directory) {
        this.directory = directory;
        System.out.println("=======================================여기에요============"+directory+"&&"+ this.directory);
    }

    @GetMapping("/diff")
    public String diff(Model model, String openapi1, String openapi2) {
        String OPENAPI_DOC1 = openapi1;
        String OPENAPI_DOC2 = openapi2;

        ChangedOpenApi diff = OpenApiCompare.fromLocations(OPENAPI_DOC1, OPENAPI_DOC2);

        String html = new HtmlRender("Changelog",
                "http://deepoove.com/swagger-diff/stylesheets/demo.css")
                .render(diff);

        model.addAttribute("diffResult", html);

        // html 파일로 추출 (return to html file)
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
        return "diffResult";
    }

    @GetMapping("/")
    public String home(Model model) {

        Map<String, String> apiFolder = new HashMap<>();

        File mainDir = new File(directory);
        File[] folderDir = mainDir.listFiles();
        List<String> folders = List.of(mainDir.list());
        for (int i = 0; i < folderDir.length; i++) {
            apiFolder.put(folders.get(i),folderDir[i].toString());
        }
        model.addAttribute("apiFolder", apiFolder);

        return "home";
    }

    // @RequestParam HashMap<Object, Object> reqParam
    @GetMapping("/showFiles")
    public String showFiles(Model model, String folderName, String folderDir) {

        folderDir += "/" + "backup";

        File backupFiles = new File(folderDir);
        List<String> openapiFilesName = List.of(backupFiles.list());
        File[] openapiFilesDirectory = backupFiles.listFiles();

        Map<String, File> openapiFilesDir = new HashMap<>();
        for (int i = 0; i < openapiFilesName.size(); i++) {
            openapiFilesDir.put(openapiFilesName.get(i), openapiFilesDirectory[i]);
        }

        model.addAttribute("openapiFilesName", openapiFilesName);
        model.addAttribute("openapiFiles", openapiFilesDir);

        return "home::#files";
    }
}
