public class DefensiveProgramming {
  public static void main(String[] args) {
    //
  }
  
  void comm() {
    String s;
    
    s = Comm.receive();
    if (s.equals("deliver")) {
      // carry out the deliver request
    } else if (s.equals("examine")) {
      // carry out the examine request
    } else {
      // handle error case
    }  
  }
  
  void commWithAssertion() {
    String s;
    
    s = Comm.receive();
    if (s.equals("deliver")) {
      // carry out the deliver request
    } else if (s.equals("examine")) {
      // carry out the examine request
    } else {
      // AssertionError is thrown here because 
      // this can never happen
      assert false;
    }
  }

  void commWithAssertion2() {
    String s;
    
    s = Comm.receive();
    
    // an assertion to validate a belief that communication message
    // cannot be null
    assert(s != null) : "communication message cannot be null";
    
    if (s.equals("deliver")) {
      // carry out the deliver request
    } else if (s.equals("examine")) {
      // carry out the examine request
    } else {
      // AssertionError is thrown here because 
      // this can never happen
      assert false;
    }
  }

  static class Comm {
    static String receive() {
      return null;
    }
  }
}
