package br.com.donatti.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.donatti.entities.Base64Request;

/**
 * 
 * @author Donatti [tallescosttapaiva@gmail.com] 14/06/2023 - 04:19:35
 *
 */
@RestController
@RequestMapping("/api/v1")
public class Base64Controller {

	@GetMapping("/download/{filename:.+}")
	public ResponseEntity<FileSystemResource> downloadPdf(@PathVariable("filename") String filename) {
		String filePath = "./" + filename;
		FileSystemResource file = new FileSystemResource(filePath);
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);
		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE);

		return ResponseEntity.ok().headers(headers).body(file);
	}

	@PostMapping(value = "/convertBase64ToPDF", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> convertBase64ToPdf(@RequestBody Base64Request request) {
		try {
			byte[] decodedBytes = Base64.decodeBase64(request.getBase64Data());
			String filename = "document-" + LocalDate.now() + ".pdf";
			FileOutputStream fos = new FileOutputStream(filename);
			fos.write(decodedBytes);
			fos.close();

			return ResponseEntity.ok(filename);
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body("Erro ao converter arquivo base64 em PDF!");
		}
	}
	
}
