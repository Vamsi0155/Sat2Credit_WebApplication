package com.sat2credit.testcases;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name = "Farm uploaded on - Tue, 24 May 2022 11:12:00 GMT";
		System.out.println(extract(name));
		try {
			int r=Integer.parseInt(extract(name))+10;
			System.out.println(r);
		}
		catch (NumberFormatException ex ) {
			ex.printStackTrace();
		}
		
		
	}
	
	public static String extract(String name) {
		
		name = name.replaceAll("[^0-9]", " ");
		name = name.replaceAll(" +", " ");
		 
        if (name.equals(""))
            return "-1";
 
        return name;
	}
	
//	private static boolean isNumeric(String str){
//        return str != null && str.matches("[0-9.]+");
//    }

}
