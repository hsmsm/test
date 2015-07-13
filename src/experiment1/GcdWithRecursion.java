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
	
	System.out.println(m + "," + n + "的最大公约数为：" + gcd(m,n));
    System.out.println(a + "," + b + "," + c + "的最大公约数为：" + gcd(gcd(a,b),c));
    System.out.println(m + "," + n + "的最小公倍数为：" + (m * n / gcd(m,n)));
  }
}