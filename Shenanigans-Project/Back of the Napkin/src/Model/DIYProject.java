
package Model;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * A DIY Project object.
 * 
 * @author Eric Harty hartye@uw.edu
 * @version .75
 */
public class DIYProject {

	/**The name of this Project.*/
    private String myName;

    /**The misc cost of the component.*/
    private BigDecimal myMiscCost;
    
    /**The estimated man-hours.*/
    private double myManHrs;
    
    /**The list of DIYcomponents.*/
    public LinkedList<DIYComponent> myComponents;
    
    /**
     * Constructs a DIYProject with a default name and empty fields.
     * @author Eric Harty - hartye@uw.edu
     * 
     */
    public DIYProject() {
		myName = "Untitled";
		myMiscCost = new BigDecimal(0);
		myManHrs = 0;
		myComponents = new LinkedList<DIYComponent>();
	}

	/**
	 * @author Eric Harty - hartye@uw.edu
	 * @return the Name
	 */
	public String getName() {
		return myName;
	}

	/**
	 * @author Eric Harty - hartye@uw.edu
	 * @return the ManHrs
	 */
	public double getManHrs() {
		return myManHrs;
	}

	/**
	 * @author Eric Harty - hartye@uw.edu
	 * @return the MiscCost
	 */
	public BigDecimal getMiscCost() {
		return myMiscCost;
	}
	
	/**
	 * @author Eric Harty - hartye@uw.edu
	 * @return the myComponents
	 */
	public LinkedList<DIYComponent> getComponents() {
		return myComponents;
	}

	/**
	 * Calculates and returns the cost per month for this project.
	 * @author Eric Harty - hartye@uw.edu
	 * 
	 * @return the CostPerMonth
	 */
	public BigDecimal getCostPerMonth() {
		BigDecimal total = new BigDecimal(0);
		for(DIYComponent c : myComponents) {
        	total.add(c.getCostPerMonth());
        }
		return total;
	}
	
	/**
	 * Calculates and returns the total up front month for this project.
	 * @author Eric Harty - hartye@uw.edu
	 * 
	 * @return the Total Cost
	 */
	public BigDecimal getTotalUpfrontCost() {
		BigDecimal total = myMiscCost;
		for(DIYComponent c : myComponents) {
        	total.add(c.getCost());
        }
		return total;
	}
	
	/**
	 * Calculates and returns the total man-hours for this project.
	 * @author Eric Harty - hartye@uw.edu
	 * 
	 * @return the total man-hours
	 */
	public double getTotalManHrs() {
		double total = myManHrs;
		for(DIYComponent c : myComponents) {
        	total += c.getManHrs();
        }
		return total;
	}

	
	/**
	 * @author Eric Harty - hartye@uw.edu
	 * @param myName the myName to set
	 */
	public void setName(String theName) {
		myName = theName;
	}
	
	/**
	 * @param the ManHrs to set
	 */
	public void setManHrs(double theManHrs) {
		myManHrs = theManHrs;
	}
	
	/**
	 * @author Eric Harty - hartye@uw.edu
	 * @param the MiscCost to set
	 */
	public void setMyMiscCost(BigDecimal theMiscCost) {
		myMiscCost = theMiscCost;
	}
	

	/**
	 * Adds a component to the component list.
	 * @author Eric Harty - hartye@uw.edu
	 * 
	 * @param the Component to add
	 */
	public void AddComponent(DIYComponent theComponent) {
		myComponents.add(theComponent);
	}
	
	/**
	 * Removes a component from the component list.
	 * @author Eric Harty - hartye@uw.edu
	 * 
	 * @param the Component to remove
	 * @throws NoSuchElementException
	 */
	public void RemoveComponent(DIYComponent theComponent) {
		if(!myComponents.contains(theComponent)){
			throw new NoSuchElementException(); 
		}
		myComponents.remove(theComponent);
	}
    
    
}
