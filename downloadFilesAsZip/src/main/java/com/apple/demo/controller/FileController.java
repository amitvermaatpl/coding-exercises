package com.apple.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.FileSystemResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class FileController {

	
	@GetMapping("/test")
	public String getMessage() {
	    return "Hello-World";
	}	
	
	@GetMapping("/downloadZip")
	public void downloadFile(HttpServletResponse response) {

		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=download.zip");
		response.setStatus(HttpServletResponse.SC_OK);

		//List<String> fileNames = service.getFileNames();
		List<String> fileNames = getFileName();

		System.out.println("############# file size ###########" + fileNames.size());

		try (ZipOutputStream zippedOut = new ZipOutputStream(response.getOutputStream())) {
			for (String file : fileNames) {
				FileSystemResource resource = new FileSystemResource(file);

				ZipEntry e = new ZipEntry(resource.getFilename());
				// Configure the zip entry, the properties of the file
				e.setSize(resource.contentLength());
				e.setTime(System.currentTimeMillis());
				// etc.
				zippedOut.putNextEntry(e);
				// And the content of the resource:
				StreamUtils.copy(resource.getInputStream(), zippedOut);
				zippedOut.closeEntry();
			}
			zippedOut.finish();
		} catch (Exception e) {
			// Exception handling goes here
		}
	} 

	private List<String> getFileName() {
		List<String> fileNames= new ArrayList<>(); 
		fileNames.add("C:/app/demo.pdf");
		return fileNames;
	}
}
