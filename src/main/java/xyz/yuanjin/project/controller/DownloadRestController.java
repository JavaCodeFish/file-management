package xyz.yuanjin.project.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
public class DownloadRestController {

    /**
     * 下载文件(不包含文件夹)
     *
     * @param path 绝对路径
     * @return 文件流
     * @throws IOException 异常
     */
    @GetMapping("/download")
    public ResponseEntity<byte[]> download(String path) throws IOException {
        //获取文件信息
        File file = new File(path);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", file.getName());

        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] bytes = new byte[102400];
        int length;
        while ((length = fis.read(bytes)) != -1) {
            bos.write(bytes, 0, length);
        }
        return new ResponseEntity<byte[]>(bos.toByteArray(),
                headers, HttpStatus.OK);
    }
}