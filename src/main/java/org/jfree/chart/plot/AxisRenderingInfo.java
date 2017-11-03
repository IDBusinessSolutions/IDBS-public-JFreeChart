/*
 *	Copyright subx, inc 2007-2017, All rights reserved.
 *	
 * Quantrix Modifications
 * 6/6/2007 bcabana Created rendering info to track objects in rendered by the axis
 * 7/26/2007 bcabana Added ability to utilize native chart title and axis label.  Also exposed native chart legend.
 *	 
 */
package org.jfree.chart.plot;

import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.jfree.io.SerialUtilities;

public class AxisRenderingInfo implements Cloneable, Serializable {
    /** For serialization. */
    private static final long serialVersionUID = 8446760134379617220L;

    /** the owning rendering info */
    private PlotRenderingInfo owner;

    /** the bounds of the rendered axis */
    private transient Rectangle2D axisArea;
    
    /** the bounds of the rendered axis label */
    private transient Rectangle2D labelArea;

    public AxisRenderingInfo() {
        this(null);
    }
    
    public AxisRenderingInfo(Rectangle2D axisArea) {
        super();
        this.axisArea = axisArea;
    }

    /**
     * @return Returns the axisArea.
     */
    public Rectangle2D getAxisArea() {
        return axisArea;
    }

    /**
     * @param axisArea The axisArea to set.
     */
    public void setAxisArea(Rectangle2D axisArea) {
        this.axisArea = axisArea;
    }
    
    /**
     * 
     * @return Returns the area of the axis label
     * @author Brian Cabana
     * @since 1.0.6
     */
    public Rectangle2D getLabelArea() {
    	return labelArea;
    }
    
    /**
     * 
     * @param labelArea The label area to set
     * @author Brian Cabana
     * @since 1.0.6
     */
    public void setLabelArea(Rectangle2D labelArea) {
    	this.labelArea = labelArea;
    }

    /**
     * @return Returns the owner.
     */
    public PlotRenderingInfo getOwner() {
        return owner;
    }

    /**
     * @param owner The owner to set.
     */
    public void setOwner(PlotRenderingInfo owner) {
        this.owner = owner;
    }
    
    /**
     * Provides serialization support.
     *
     * @param stream  the output stream.
     *
     * @throws IOException  if there is an I/O error.
     */
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        SerialUtilities.writeShape(this.axisArea, stream);
    }

    /**
     * Provides serialization support.
     *
     * @param stream  the input stream.
     *
     * @throws IOException  if there is an I/O error.
     * @throws ClassNotFoundException  if there is a classpath problem.
     */
    private void readObject(ObjectInputStream stream) 
            throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        this.axisArea = (Rectangle2D) SerialUtilities.readShape(stream);
    }
}
