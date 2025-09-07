package daos;

import java.util.Random;

public class GenerateId {
	
	public String generateId() {
		Random r = new Random();
		
		StringBuilder str= new StringBuilder();
		
		for(int i=0;i<3;i++) {
			int b=r.nextInt(122-97+1)+97;
			str=str.append((char)b);
		}
		
		int b=r.nextInt(999-100+1)+100;
		String num=Integer.toString(b);
		String cid="";
		for(int i=0;i<6;i++) {
			if(i%2==0) {
				cid=cid+str.charAt(i/2);
				
			}
			else{
				cid=cid+num.charAt(i/2);
				
			}
			
		}
		
		return cid;
		
		
		}
}
