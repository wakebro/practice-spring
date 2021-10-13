package org.ict.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class FileController {
	
	// 업로드 폼
	@GetMapping("/exUpload ")
	public void exupload() {
		log.info("/exUpload............");
	}
	
	// 업로드 처리 - 파일 여러개를 전달 받으려면 배열 구조의 객체를 파라미터로 선언
	public void exUploadPost(ArrayList<MultipartFile> files) {
		
		// 넘어온 파일의 정보를 출력
		// forEach(람다식) : files의 데이터를 한 개씩 꺼내어 file에 저장해서 처리하는 함수
		files.forEach(file -> {
			log.info("-------------------------");
			
			// .getOriginalFilename() - cos 라이브러리와 기능이 동일
			// 		파일 업로드 당시의 이름이 출력
			//		중복이 되면 1,2,3,4...를 붙인다
			log.info("name : " + file.getOriginalFilename());
			log.info("size : " + file.getSize());
			
			// .transferTo(File객체) - 파일을 저장하는 기능
			// 파일을 저장하려면 저장하려는 File 객체를 만들어 .transferTo(File 객체)를 사용한다. 
		});
	}
}
