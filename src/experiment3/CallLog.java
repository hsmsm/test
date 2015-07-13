package experiment3;

public class CallLog<T> extends CirDLinkedQueue<T>{

	private final int  MAXCOUNT = 10;
	
	public CallLog(){
		super();
	}
	
	//记录通话记录
	public void record(T x){      
		if(this.list.length() < MAXCOUNT)
			this.enqueue(x);
		else{
			this.dequeue();
			this.enqueue(x);
		}
			 
    }
	
	
	//清空通话记录
	public void clear(){
		list.removeAll();
	}
	
	
	
	
	
	public static void main(String[] args) {
		String[] tels = {
			"18814120000","18814120009","18814120008","18814120007","18814120006",
			"18814120005","18814120004","18814120003","18814120002","18814120001"
		};
		CallLog<String> missedCalls = new CallLog<String>();
		CallLog<String> receivedCalls = new CallLog<String>();
		CallLog<String> dialedCalls = new CallLog<String>();
		for(int i = 0;i < 10;i++){
			missedCalls.record(tels[i]);
			receivedCalls.record(tels[i]);
			dialedCalls.record(tels[i]);
		}
		System.out.printf("%3s\t%11s\t%11s\t%11s\n","No.","未接来电","已接来电","已拨电话");
		System.out.printf("%3s\t%11s","---","-----------");
		System.out.printf("\t%11s","-----------");
		System.out.printf("\t%11s\n","-----------");
		for(int i = 9;i >= 0;i--){
			System.out.printf("%3d\t%11s",(10-i),missedCalls.list.get(i));
			System.out.printf("\t%11s",receivedCalls.list.get(i));
			System.out.printf("\t%11s\n",dialedCalls.list.get(i));
		}
		missedCalls.record("13800138000");
		receivedCalls.record("13800138000");
		dialedCalls.record("13800138000");
		
		System.out.println("刷新通话记录(插入13800138000)：");
		for(int i = 9;i >= 0;i--){
			System.out.printf("%3d\t%11s",(10-i),missedCalls.list.get(i));
			System.out.printf("\t%11s",receivedCalls.list.get(i));
			System.out.printf("\t%11s\n",dialedCalls.list.get(i));
		}
		
		System.out.println("清空通话记录：");
		missedCalls.clear();
		receivedCalls.clear();
		dialedCalls.clear();
		for(int i = 9;i >= 0;i--){
			System.out.printf("%3d\t%11s",(10-i),missedCalls.list.get(i));
			System.out.printf("\t%11s",receivedCalls.list.get(i));
			System.out.printf("\t%11s\n",dialedCalls.list.get(i));
		}
	}
}
