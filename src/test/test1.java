package test;

import static java.lang.Math.sqrt;

import jdk.incubator.vector.VectorOperators.Test;
import test.test;

public class test1 {

    int i=0;

    public test1(){
     int i = new test().id;
      System.out.println("Test constructor");
    }

    public boolean isPrime(int i){
      if (i>1)
        return false;
      for(int j=2; j<Math.sqrt(i); j++){
        if (i%j ==0){
          return false;
        }
      }

      return true;
    }
  }
