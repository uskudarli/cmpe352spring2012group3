public class Base {

  public boolean prime(int number){
  
    for(int i=2; i<number; i++){
      if(number%i==0){
        return false;
      }
    }
    
    return true;
  }
  
  

}
