package cz.rodr.springAopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this will be called before any method with the name addAccount() in any class
    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n====>>> Executing @Before advice before addAccount method.");
    }

    // this will be called before addAccount() in Membership class only
    @Before("execution(public void cz.rodr.springAopDemo.dao.MembershipDAO.addAccount())")
    public void beforeMembershipAddAccountAdvice() {
        System.out.println("\n*****>>> Executing the second @Before advice before addAccount method.");
    }

    // this will be called before any method in any class with name starting with "add"
    @Before("execution(public void add*())")
    public void beforeAllAddMethodsAdvice() {
        System.out.println("\n####>>> Executing the third @Before advice before any add* method.");
    }

    // will be called before any add* method with Account as its only parameter
    @Before("execution(* add*(cz.rodr.springAopDemo.Account))")
    public void beforeAnyAddMethodWithAccountAsOnlyParameterAdvice() {
        System.out.println("\n????>>> Executing the @Before advice before any add* method with Account as its only parameter.");
    }

    // will be called before any add* method with Account as its first parameter with other parameters
    @Before("execution(* add*(cz.rodr.springAopDemo.Account, ..))")
    public void beforeAnyAddMethodWithAccountAsFirstParameterWithOtherParametersAdvice() {
        System.out.println("\n????>>> Executing the @Before advice before any add* method with Account as its first parameter with other parameters.");
    }

}
