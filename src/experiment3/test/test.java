package experiment3.test;

import experiment3.CallLog;

public class test {
	public static void main(String[] args) {
		String[] tels = {
			"110","111","112","113","114",
			"115","116","117","118","119"
		};
		CallLog<String> missedCalls = new CallLog<String>();
		CallLog<String> receivedCalls = new CallLog<String>();
		CallLog<String> dialedCalls = new CallLog<String>();
		for(int i = 0;i < 10;i++){
			missedCalls.record(tels[i]);
			receivedCalls.record(tels[i]);
			dialedCalls.record(tels[i]);
		}
		
		System.out.println("δ������"+missedCalls.toString());
		System.out.println("�ѽ�����"+receivedCalls.toString());
		System.out.println("�Ѳ��绰"+dialedCalls.toString());
		
		missedCalls.record("100");
		receivedCalls.record("100");
		dialedCalls.record("100");
		
		System.out.println("����100��");
		
		System.out.println("δ������"+missedCalls.toString());
		System.out.println("�ѽ�����"+receivedCalls.toString());
		System.out.println("�Ѳ��绰"+dialedCalls.toString());
		
	}
}
