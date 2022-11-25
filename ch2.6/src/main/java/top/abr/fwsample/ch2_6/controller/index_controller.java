package top.abr.fwsample.ch2_6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import top.abr.fwsample.ch2_6.POJO.file_list;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@Controller
public class index_controller {
	@PostMapping("/upload")
	public String upload_files(@ModelAttribute file_list list, HttpServletRequest request) {
		final String real_path = request.getServletContext().getRealPath("portal");
		final File target_dir = new File(real_path);
		if (target_dir.exists() == false) {target_dir.mkdirs();}
		final List<MultipartFile> files = list.file;
		for (MultipartFile file : files) {
			final String file_name = file.getOriginalFilename();
			if (file_name == null) continue;
			final File target_file = new File(real_path, file_name);
			try {file.transferTo(target_file);}
			catch (Exception e) {e.printStackTrace();}
		}
		return "result";
	}
}
