/* ===========================================================
 * JFreeChart : a free chart library for the Java(tm) platform
 * ===========================================================
 *
 * (C) Copyright 2000-2011, by Object Refinery Limited and Contributors.
 *
 * Project Info:  http://www.jfree.org/jfreechart/index.html
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Oracle and Java are registered trademarks of Oracle and/or its affiliates. 
 * Other names may be trademarks of their respective owners.]
 *
 * --------------
 * AxisState.java
 * --------------
 * (C) Copyright 2003-2008, by Object Refinery Limited and Contributors.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   -;
 *
 * Changes
 * -------
 * 03-Nov-2003 : Added standard header (DG);
 * 07-Nov-2003 : Added 'max' attribute (DG);
 *
 * Quantrix Modifications forked from version 1.0.14
 * 7/26/2007 bcabana Added ability to utilize native chart title and axis label.  Also exposed native chart legend.
 */

package org.jfree.chart.axis;

import java.awt.geom.Rectangle2D;
import java.util.List;

import org.jfree.ui.RectangleEdge;

/**
 * Instances of this class are used to carry state information for an axis
 * during the drawing process.  By retaining this information in a separate
 * object, it is possible for multiple threads to draw the same axis to
 * different output targets (each drawing will maintain separate state
 * information).
 */
public class AxisState {

    /** The cursor position. */
    private double cursor;

    /** The axis ticks. */
    private List ticks;

    /** The maximum width/height. */
    private double max;
    
    /** The bounds of the label. */
    private Rectangle2D labelBounds;
    
    /**
     * Creates a new axis state.
     */
    public AxisState() {
        this(0.0);
    }

    /**
     * Creates a new axis state.
     *
     * @param cursor  the cursor.
     */
    public AxisState(double cursor) {
        this.cursor = cursor;
        this.ticks = new java.util.ArrayList();
        this.labelBounds = new Rectangle2D.Double();
    }

    /**
     * Returns the cursor position.
     *
     * @return The cursor position.
     */
    public double getCursor() {
        return this.cursor;
    }

    /**
     * Sets the cursor position.
     *
     * @param cursor  the cursor position.
     */
    public void setCursor(double cursor) {
        this.cursor = cursor;
    }

    /**
     * Moves the cursor outwards by the specified number of units.
     *
     * @param units  the units.
     * @param edge  the edge.
     */
    public void moveCursor(double units, RectangleEdge edge) {
        if (edge == RectangleEdge.TOP) {
            cursorUp(units);
        }
        else if (edge == RectangleEdge.BOTTOM) {
            cursorDown(units);
        }
        else if (edge == RectangleEdge.LEFT) {
            cursorLeft(units);
        }
        else if (edge == RectangleEdge.RIGHT) {
            cursorRight(units);
        }
    }

    /**
     * Moves the cursor up by the specified number of Java 2D units.
     *
     * @param units  the units.
     */
    public void cursorUp(double units) {
        this.cursor = this.cursor - units;
    }

    /**
     * Moves the cursor down by the specified number of Java 2D units.
     *
     * @param units  the units.
     */
    public void cursorDown(double units) {
        this.cursor = this.cursor + units;
    }

    /**
     * Moves the cursor left by the specified number of Java 2D units.
     *
     * @param units  the units.
     */
    public void cursorLeft(double units) {
        this.cursor = this.cursor - units;
    }

    /**
     * Moves the cursor right by the specified number of Java 2D units.
     *
     * @param units  the units.
     */
    public void cursorRight(double units) {
        this.cursor = this.cursor + units;
    }

    /**
     * Returns the list of ticks.
     *
     * @return The list of ticks.
     */
    public List getTicks() {
        return this.ticks;
    }

    /**
     * Sets the list of ticks.
     *
     * @param ticks  the ticks.
     */
    public void setTicks(List ticks) {
        this.ticks = ticks;
    }

    /**
     * Returns the maximum width/height.
     *
     * @return The maximum width/height.
     */
    public double getMax() {
        return this.max;
    }

    /**
     * Sets the maximum width/height.
     *
     * @param max the maximum width/height.
     */
    public void setMax(double max) {
        this.max = max;
    }
    
    /**
     * Sets the bounds of the axis label
     * @param bounds
     * @author Brian Cabana
     * @since 1.0.6
     */
    public void setLabelBounds(Rectangle2D bounds){
    	this.labelBounds = bounds;
    }
    
    /**
     * 
     * @return the bounds of the axis label
     * @author Brian Cabana
     * @since 1.0.6
     */
    public Rectangle2D getLabelBounds(){
    	return labelBounds;
    }
}
