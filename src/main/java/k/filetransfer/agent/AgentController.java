package k.filetransfer.agent;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import k.filetransfer.agent.client.FileTransferClient;
import k.filetransfer.agent.service.FileTransferService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@Slf4j
public class AgentController {

    private final FileTransferClient filetransferClient;
    private final FileTransferService fileTransferService;

    @GetMapping("/hello")
    public String hello() {
        log.debug(filetransferClient.hello());
        return "hello";
    }

    @PostMapping(value="sendFile")
    @ResponseStatus(HttpStatus.OK)
    public void sendFile(
            @RequestBody Map<String, String> data
    ) throws IOException {

        log.debug("path, name : {}", data);
        fileTransferService.run(data.get("path"),data.get("name"));
    }

    @PostMapping(value="sendFile2")
    @ResponseStatus(HttpStatus.OK)
    public void sendFile2(
            @RequestPart(value="file") MultipartFile file
            ,@RequestParam String filepath
    ) throws IOException {
        log.debug("file {}", file);
        log.debug("path, name : {}", filepath);
//        fileTransferService.run(data.get("path"),data.get("name"));
        fileTransferService.run(file);
    }

}
