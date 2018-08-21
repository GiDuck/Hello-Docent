package com.spov.hellodocent.tools;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileExistsException;
import org.springframework.util.FileCopyUtils;


/* singleton class - 파일 관리 */

public class FileManager {
	
	private static FileManager instance = new FileManager();
	
	public static FileManager getInstance() {
		
		if(instance==null) {
			
			instance = new FileManager();
			
		}
		
		
		return instance;
	}
	
	

	public String uploadImage(String uploadPath, String originalName, String boardUid, byte[] fileData)
			throws Exception {

		uploadPath = uploadPath + "\\" + boardUid;

		String savedName = UidMaker.getUUid() + "_" + originalName;

		File targetDir = new File(uploadPath);

		if (!targetDir.exists()) {

			targetDir.mkdirs();
			System.out.println(uploadPath + " 가 존재하지 않습니다.. 생성합니다.");

		}

		File target = new File(uploadPath, savedName);
		FileCopyUtils.copy(fileData, target);
		System.out.println("현재 저장되는 경로는 ... : " + uploadPath);

		String approachURL = "/img/" + boardUid + "/" + savedName;

		return approachURL;

	}

	public void deleteImage(String deletePath) throws Exception {

		File file = new File(deletePath);
		if (file.exists()) {

			if (file.delete()) {

				System.out.println("FILE DELETE SUCCESS --> " + deletePath);

			} else {

				System.out.println("FILE DELETE FAIL!");

			}

		} else {

			new FileExistsException();

		}

	}

	public List<String> exsistFileList(String uploadPath, String[] fileList) {

		List<String> exsistFiles = new ArrayList<>();

		File dummyFile;

		for (String file : fileList) {

			dummyFile = new File(uploadPath + file.subSequence(4, file.length()));

			if (dummyFile.exists()) {

				exsistFiles.add(file);

			}

		}

		return exsistFiles;
	}

	
	
	
	
	public void removeFiles(String uploadPath, List<String> files) {

		File dummyFile = null;

		for (String file : files) {

			System.out.println("remove file path.... file : " + uploadPath + file.subSequence(4, file.length()));
			
			try {
				dummyFile = new File(uploadPath + file.subSequence(4, file.length()));

				if (dummyFile.exists()) {

					dummyFile.delete();

				}

			} catch (Exception e) {

				e.printStackTrace();
				System.out.println("FILE REMOVE FAIL! --> " + dummyFile.getAbsolutePath() + dummyFile.getName());

			}

		}

	}
	
	
	

	public void removeDir(String removeDir) {
		
		
		File dir = new File(removeDir);
		File[] children = dir.listFiles();
		
		
		if(dir.isDirectory()) {
			
			for(File child : children) {
				
				try {
				
				child.delete();
				}catch (Exception e) {

					System.out.println("FILE REMOVE FAIL! --> " + child.getAbsolutePath() + child.getName());
				
				}
			}
			
			dir.delete();
			
		}


	}

}
