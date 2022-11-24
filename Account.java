package vianne;



class Account {
	    float principal;
    float rate;
        int daysActive;
    	    int accountType;
    	
    	    public static final int  STANDARD = 0;
    	    public static final int  BUDGET = 1;
    	    public static final int  PREMIUM = 2;
    	    public static final int  PREMIUM_PLUS = 3;
    	
    	    float interestEarned() {
    	        float years = daysActive / (float) 365.25;
    	        float compoundInterest = principal * (float) Math.exp( rate * years );
    	        return ( compoundInterest - principal );
    	    }
    	
    	    public boolean isPremium() {
    	        if (accountType == Account.PREMIUM || accountType == Account.PREMIUM_PLUS)
    	            return true;
   	        else
    	            return false;
    	    }
    	
    	
    	float calculateFee(Account accounts[]) {
    	    float totalFee = 0;
    	    Account account;
    	    for (int i = 0; i < accounts.length; i++) {
    	        account = accounts[i];
    	        if ( account.isPremium() ) {
    	            totalFee += BROKER_FEE_PERCENT * account.interestEarned();
    	        }
    	    }
    	    return totalFee;
    	}
    	
    	static final double BROKER_FEE_PERCENT = 0.0125;
	}

//To refactor a program is to improve the design of that program without altering its behavior.[*] There are many different kinds of improvementscalled refactorings that can be performed.
//Every programmer knows that there are many ways to write code to implement one specific behavior. There are many choices that do not affect the behavior of the software but that can have an enormous impact on how easy the code is to read and understand. The programmers choose variable names, decide whether certain blocks of code should be pulled out into separate functions, choose among various different but syntactically equivalent statements, and make many other choices that can have a significant impact on how easy the software is to maintain.
//
//Many programmers think of coding as a purely constructive task, for which the only reason to add, remove, or change the source code is to alter the behavior of the software. Refactoring introduces a new concept: adding, removing, or changing the source code for the sole purpose of making it easier to maintain. There are many different refactorings, or techniques, through which programmers can alter their code to make it easier to understand.
//
//Refactoring is a new way of thinking about software design. Traditionally, software is designed first and then built. This is especially true of object-oriented programming, where the programmers might be handed a complex object model to implement. But most programmers who have worked on a reasonably complex project have run across instances when they discover ways that an object could have been designed better. They could not have predicted most of these improvements because they only became apparent during the construction of the code. Refactoring provides them with a way to incorporate those improvements in a structured, repeatable manner.
//
//Because each refactoring is a change to the design, it may impact the design review process. If the software design has already been reviewed by project team members, then any changes that arise from refactoring activities should be communicated to the people who reviewed it. This does not necessarily mean that design specification must be reinspected after each refactoring; since refactoring changes the design without altering the functionality, it is usually sufficient to distribute just the changes to the design and have the team members approve those changes. In general, people do not object very often to refactoring, but they appreciate being given the opportunity to discuss it and suggest alternatives.
//
//Each refactoring has a set of stepssimilar to the scripts we use to describe the tools in this bookwhich makes it much less likely for the programmer to introduce defects.
//