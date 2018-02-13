package Model;

import java.math.BigDecimal;
import java.util.LinkedList;

/**
 * A component for a DIY project.
 * 
 * @author Eric Harty hartye@uw.edu
 * @version .5
 */
public class DIYComponent /*? implements ComponentList ?*/ {

    /**The name of this component.*/
    private String myName;

    /**The quantity of the component in the project.*/
    private int myQuantity;

    /**The unit price of the component.*/
    private BigDecimal myPrice;
    
    /**The unit price per month of the component.*/
    private BigDecimal myPricePerMonth;
    
    /**The estimated man-hours.*/
    private double myManHrs;
    
    /**The list of subcomponents.*/
    public LinkedList<DIYComponent> mySubComponents = new LinkedList<DIYComponent>();


    /**
     * Constructs a DIYComponent with the specified name and quantity.
     * 
     * @param theName
     * @param theQuantity
     * @throws IllegalArgumentException if theQuantity is less than or equal to zero
     */
    public DIYComponent(final String theName, final int theQuantity) {

        if (theQuantity <= 0) {
            throw new IllegalArgumentException("We'll figure out what to do later");
        }
        myName = theName;
        myQuantity = theQuantity; 
    }

    //Still need to figure out the constructor/setter combo we want for creating new components,
    //  and editing subcomponents?
    
    /**
     * Sets the unit price.
     * 
     * @param thePrice
     */
    public final void setPrice(final BigDecimal thePrice) {
        myPrice = thePrice;
    }
    
    /**
     * Sets the man-hours.
     * 
     * @param theTime
     */
    public final void setTime(final double theTime) {
        myManHrs = theTime;
    }
    
    /**
     * Adds a subcomponent to the subcomponent list.
     * 
     * @param the component being added
     */
    public final void AddSubComp(final DIYComponent theComp) {
    	mySubComponents.add(theComp);
    }
    
    /**
     * Returns the Unit price of this component.
     * 
     * @return the BigDecimal price
     */
    public final BigDecimal getSinglePrice() {
    	return myPrice;
    }

    /**
     * Calculates and returns the total price of this component 
     * and all subcomponents.
     * 
     * @return the BigDecimal price
     */
    public final BigDecimal getPrice() {
        BigDecimal total = myPrice;
    	total.multiply(new BigDecimal(myQuantity));
        
        for(DIYComponent c : mySubComponents) {
        	total.add(c.getPrice());
        }
        
    	return total;
    }
    
    /**
     * Returns the Unit price-per-month of this component.
     * 
     * @return the BigDecimal price
     */
    public final BigDecimal getSinglePPM() {
    	return myPricePerMonth;
    }
    
    /**
     * Calculates and returns the total price-per-month of 
     * this component and all subcomponents.
     * 
     * @return the BigDecimal price per month
     */
    public final BigDecimal getPricePerMonth() {
        BigDecimal total = myPricePerMonth;
    	total.multiply(new BigDecimal(myQuantity));
        
        for(DIYComponent c : mySubComponents) {
        	total.add(c.getPricePerMonth());
        }
        
    	return total;
    }
    
    /**
     * Returns the estimated man-hours for this component 
     * and all subcomponents.
     * 
     * @return the double ManHours
     */
    public final double getTime() {
    	double hrs = myManHrs;
    	for(DIYComponent c : mySubComponents) {
    		hrs += c.getTime();
        }
    	return hrs;
    }

    //TBD
    
	


}