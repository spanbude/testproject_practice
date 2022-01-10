package xretry;

import java.lang.reflect.Constructor;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class MyTransformerListner implements IAnnotationTransformer {
	
public void transform(ITestAnnotation annotation,
        Class testClass,
        Constructor testConstructor,
        java.lang.reflect.Method testMethod)
    
    
    {
        annotation.setRetryAnalyzer(xretry.RetryLogic.class);
      
        
        
    }
    

}
