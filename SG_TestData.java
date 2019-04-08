package wiseIntranet.member.holiday.action;

import java.lang.reflect.Field;
import java.util.*;

import org.apache.poi.ss.formula.functions.T;

import wiseIntranet.member.holiday.dto.VacationDTO;

public class SG_TestData {

	/*
	 * Date		:	2019-04-08
	 * Usage	:	List, DTO등의 내부 데이터를 확인하기 위하여 출력하는 클래스
	 * Method	:
	 * 1. 	MapValueTest(Map map) 									//	Map 데이터 확인용
	 * 2. 	DTOValueTest(Object obj)								//	DTO 데이터 확인용
	 * 3. 	ListDTOValueTest(ArrayList<?> ListDTO, boolean flag) 	// 	List<DTO> 데이터 확인용
	 * 		flag	▶	true = null제외, false = null포함 
	 * 예시
	 * 1. 	SG_TestData.MapValueTest(map);
	 * 2.	SG_TestData.DTOValueTest(this.vacationDTO);
	 * 3-1 	SG_TestData.ListDTOValueTest(this.vacationList, true);	// null 포함 출력
	   3-2	SG_TestData.ListDTOValueTest(this.vacationList, false); // null 제외 출력
	 * */	
			
	/*
	 * Date		:	2019-04-08
	 * Usage	:	Class to output internal data such as List and DTO
	 * Method	:
	 * 1. 	MapValueTest(Map map) 									//	For checking Map data
	 * 2. 	DTOValueTest(Object obj)								//	For checking DTO value
	 * 3. 	ListDTOValueTest(ArrayList<?> ListDTO, boolean flag)	//	For checking List<DTO> value
	 * 		flag	▶	 true = null excluded, false = null included
	 * 
	 * EX
	 * 1. 	SG_TestData.MapValueTest(map);
	 * 2.	SG_TestData.DTOValueTest(this.vacationDTO);
	 * 3-1 	SG_TestData.ListDTOValueTest(this.vacationList, true);	// null exclude output
	   3-2	SG_TestData.ListDTOValueTest(this.vacationList, false); // null inclusive output
	 * */	
			
	public SG_TestData() {
		// TODO Auto-generated constructor stub
		System.out.println("==테스트용 클래스 시작==");
	}
	
	public static void MapValueTest(Map map){
		try {
			for ( Object key : map.keySet() ) {
			    System.out.println("방법1) key : " + key +"	/	value : " + map.get(key));
			}
			System.out.println("=======================");
		} catch (Exception e) {
			System.out.println("MapValueTest : ERROR");
			e.printStackTrace();
		}
	}
	public static void DTOValueTest(Object obj){
		System.out.println("DTOValueTest : Start" );
		try {
			for ( Field field : obj.getClass().getDeclaredFields() ){
				field.setAccessible(true);;
				Object value = field.get(obj);
				System.out.println("TEST 데이터 : "+field.getName()+"	:	"+value);
			}
			System.out.println("=======================");
		}catch(Exception e){
			System.out.println("DTOValueTest : ERROR");
			e.printStackTrace();
		}
	}
	public static void ListDTOValueTest(ArrayList<?> ListDTO, boolean flag) {
		// TODO Auto-generated method stub
	      try {
	    	  for(int i = 0; i<ListDTO.size(); i++){
	    		  System.out.println("Memory Add : "  + ListDTO.get(i));
				  Object obj = ListDTO.get(i);
					for ( Field field : obj.getClass().getDeclaredFields() ){
						field.setAccessible(true);
						Object value = field.get(obj);
						if(value == null && flag){
						}else{
							System.out.println("TEST 데이터 : "+field.getName()+"	:	"+value);
						}
					}
			  }
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

/*			
			
*/

}
