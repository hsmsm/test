package experiment1;

public class GcdWithRecursion{
	
  public static int gcd(int m,int n){
	if(m % n == 0)
	  return n;
    else
	  return gcd(n,m % n);
  }
  
  public static void main(String[] args){
	int a = 12,b = 18,c = 24;
	int m = 49,n = 91;
	
	System.out.println(m + "," + n + "�����Լ��Ϊ��" + gcd(m,n));
    System.out.println(a + "," + b + "," + c + "�����Լ��Ϊ��" + gcd(gcd(a,b),c));
    System.out.println(m + "," + n + "����С������Ϊ��" + (m * n / gcd(m,n)));
  }
}