package com.spov.hellodocent.parseFormat;

import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.spov.hellodocent.domain.DisplayDTO;
import com.spov.hellodocent.domain.DisplayInfoDTO;
 



public class ExcelParser {
	
	@SuppressWarnings("deprecation")
	public void xlsxReader(String filePath, List<DisplayDTO> displays, List<DisplayInfoDTO> infos){
		
		
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		
		try {
			
			fis = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fis);
			
			XSSFSheet curSheet;
			XSSFRow curRow;
			XSSFCell curCell;
			DisplayDTO display = new DisplayDTO();
			DisplayInfoDTO info = new DisplayInfoDTO();
			int count = 0;
			
			for(int sheetIndex = 0 ; sheetIndex < 10000; ++sheetIndex ) {
				
				curSheet = workbook.getSheetAt(sheetIndex);
				
				for(int rowIndex=0; rowIndex < curSheet.getPhysicalNumberOfRows(); ++rowIndex) {
					
					if(rowIndex != 0) {
						
						
						curRow = curSheet.getRow(rowIndex);
						
						display = new DisplayDTO();
						info = new DisplayInfoDTO();
						
						String value = null;
						String temp[];
						
						if((curRow.getCell(0).getStringCellValue()).isEmpty()) {						
							
							
							for(int cellIndex = 0; cellIndex < curRow.getPhysicalNumberOfCells() ; ++cellIndex) {
								
								
								
								curCell = curRow.getCell(cellIndex);
								

								  switch (curCell.getCellType()){
                                  case HSSFCell.CELL_TYPE_FORMULA:
                                      value = curCell.getCellFormula();
                                      break;
                                  case HSSFCell.CELL_TYPE_NUMERIC:
                                      value = curCell.getNumericCellValue()+"";
                                      break;
                                  case HSSFCell.CELL_TYPE_STRING:
                                      value = curCell.getStringCellValue()+"";
                                      break;
                                  case HSSFCell.CELL_TYPE_BLANK:
                                      value = curCell.getBooleanCellValue()+"";
                                      break;
                                  case HSSFCell.CELL_TYPE_ERROR:
                                      value = curCell.getErrorCellValue()+"";
                                      break;
                                  default:
                                      value = new String();
                                      break;
                                  }

								   // 현재 column index에 따라서 vo에 입력
                                  switch (cellIndex) {
                                  case 1: // 부제목
                                	  info.setDpl_alternativeTitle(value);
                                      break;
                                      
                                  case 3: // CREATOR
                                	  display.setDp_exp(value);                             
                                      break;
                                      
                                  case 4: // EXTENT
                                	  info.setDpl_extent(value);
                                      break;
                                      
                                  case 8: // PUBLISHER
                                	  info.setDpl_publisher(value);
                                      break;
                                      
                                  case 9: // 썸네일 이미지
                                      info.setDpl_imageUrl(value);
                                	  break;
                                      
                                  case 11: // 시대
                                	  info.setDpl_temporal(value);
                                      break;
                                      
                                  case 12: // 제목
                                      display.setDp_name(value);
                                	  break;
                                      
                                  case 13: // 타입
                                      display.setDp_type(value);
                                	  break;
                                	  
                                  case 14: // UCI
                                	 display.setDp_uci(value);
                                	 temp = value.split("\\.");
                                	 display.setDp_id(temp[2]);
                                	 info.setDpl_id(temp[2]);
                                	
 
                                      break;
                                      
                                  case 15: // URL
                                	  info.setDpl_url(value);
                                      break;
      
                                  default:
                                      break;
                                  }


								
                                  displays.add(display);
                                  infos.add(info);
                                  
                                  System.out.println("------------- " + count + "개 파싱 중 -----------");
                                  System.out.println("현재 ID : " + display.getDp_id());
                                  System.out.println("현재 TITLE : " + display.getDp_name());
                                  
                                  
								
							}
							
							
							
							
						}
						
						
						
					}
					
					
					
				}
				
				
				
			}
			
			
			
			
			System.out.println("파싱된 요소 개수 : " + displays.size() + " / " + infos.size());
			 
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	

}
