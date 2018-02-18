
package Model;

import java.math.BigDecimal;
import java.util.LinkedList;

/**
 * A component for a DIY project.
 * 
 * @author Eric Harty hartye@uw.edu
 * @version .75
 */
public class DIYComponent /*? implements ComponentList ?*/ {

    /**The name of this component.*/
    private final String myName;

    /**The quantity of the component in the project.*/
    private int myQuantity;

    /**The unit price of the component.*/
    private final BigDecimal myCost;
    
    /**The unit price per month of the component.*/
    private final BigDecimal myCostPerMonth;
    
    /**The double width of the component.*/
    private final double myWidth;
    
    /**The double length of the component.*/
    private final double myLength;
    
    /**The double height of the component.*/
    private final double myHeight;
    
    /**The double weight of the component.*/
    private final double myWeight;
    
    /**The material of this component.*/
    private final String myMaterial;
    
    /**The estimated man-hours.*/
    private final double myManHrs;
    
    /**The list of subcomponents.*/
    public final LinkedList<DIYComponent> mySubComponents;
    
    
    /**
     * Constructs a DIYComponent with the specified name and quantity.
     * 
     * @param theName
     * @param theQuantity
     * @throws IllegalArgumentException if theQuantity is less than or equal to zero
     */
    public DIYComponent(final String theName, final int theInitQuantity, 
    		final BigDecimal theCost, final BigDecimal theCostPerMonth, 
    		final double theWidth, final double theLength, final double theHeight,
    		final double theWeight, final String theMaterial, final double theManHrs,
    		final LinkedList<DIYComponent> theSubComponents) {
		myName = theName;
		myCost = theCost;
		myCostPerMonth = theCostPerMonth;
		myWidth = theWidth;
		myLength = theLength;
		myHeight = theHeight;
		myWeight = theWeight;
		myMaterial = theMaterial;
		myManHrs = theManHrs;
		mySubComponents = theSubComponents;
		
		if(theInitQuantity <= 0) {
			throw new IllegalArgumentException();
		}
		myQuantity = theInitQuantity;
	}

   
    /**
     * Sets the quantity of the component.
     * 
     * @param theQuantity
     */
    public final void setQuantity(final int theQuantity) {
    	myQuantity = theQuantity;
    }
    
	/**
	 * @return the Quantity
	 */
	public int getQuantity() {
		return myQuantity;
	}

	/**
	 * @return the Name
	 */
	public String getName() {
		return myName;
	}

	/**
	 * @return the Width
	 */
	public double getWidth() {
		return myWidth;
	}

	/**
	 * @return the Length
	 */
	public double getLength() {
		return myLength;
	}

	/**
	 * @return the Height
	 */
	public double getHeight() {
		return myHeight;
	}

	/**
	 * @return the myWeight
	 */
	public double getWeight() {
		return myWeight;
	}

	/**
	 * @return the myMaterial
	 */
	public String getMaterial() {
		return myMaterial;
	}

	/**
	 * @return the SubComponents
	 */
	public LinkedList<DIYComponent> getSubComponents() {
		return mySubComponents;
	}

    /**
     * Returns the Unit price of this component.
     * 
     * @return the BigDecimal cost
     */
    public final BigDecimal getUnitCost() {
    	return myCost;
    }

    /**
     * Calculates and returns the total price of this component 
     * and all subcomponents.
     * 
     * @return the BigDecimal cost
     */
    public final BigDecimal getCost() {
        BigDecimal total = myCost;
    	total.multiply(new BigDecimal(myQuantity));
        
        for(DIYComponent c : mySubComponents) {
        	total.add(c.getCost());
        }
        
    	return total;
    }
    
    /**
     * Returns the Unit cost-per-month of this component.
     * 
     * @return the BigDecimal price
     */
    public final BigDecimal getUnitCPM() {
    	return myCostPerMonth;
    }
    
    /**
     * Calculates and returns the total price-per-month of 
     * this component and all subcomponents.
     * 
     * @return the BigDecimal cost per month
     */
    public final BigDecimal getCostPerMonth() {
        BigDecimal total = myCostPerMonth;
    	total.multiply(new BigDecimal(myQuantity));
        
        for(DIYComponent c : mySubComponents) {
        	total.add(c.getCostPerMonth());
        }
        
    	return total;
    }
    
    /**
     * Returns the Unit man-hours of this component.
     * 
     * @return the myManHrs
	 */
	public double getUnitManHrs() {
		return myManHrs;
	}
    
    /**
     * Returns the estimated man-hours for this component 
     * and all subcomponents.
     * 
     * @return the double ManHours
     */
    public final double getManHrs() {
    	double hrs = myManHrs;
    	for(DIYComponent c : mySubComponents) {
    		hrs += c.getManHrs();
        }
    	return hrs;
    }

    
    
	


}