public class Base {

  public static boolean prime(int number){
   System.out.println("deneme");
    for(int i=2; i<number; i++){
      if(number%i==0){
        return false;
      }
    }
    
    return true;
  }
  
  

}
