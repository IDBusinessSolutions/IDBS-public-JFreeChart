/*
 * Copyright subx, inc 2007-2018
 */
package org.jfree.chart.axis;

import org.jfree.text.TextBlock;
import org.jfree.text.TextBlockAnchor;
import org.jfree.ui.TextAnchor;

/**
 * @author Brian Cabana
 * A definition of a NumberTick that takes a TextBlock and allows for rotated number ticks
 * on the value axis.
 */
public class NumberBlockTick extends NumberTick {

	private TextBlock label;

	public NumberBlockTick(Number number, TextBlock label,
			TextBlockAnchor labelAnchor, TextAnchor rotationAnchor, double angle) {
		this(number, number.toString(), label, labelAnchor, rotationAnchor, angle);
	}
	
	public NumberBlockTick(Number number, String label, TextBlock textBlock,
			TextBlockAnchor labelAnchor, TextAnchor rotationAnchor, double angle) {
		super(number, label, getTextAnchor(labelAnchor), rotationAnchor, angle);
		this.label = textBlock;
	}
	

	public TextBlock getLabel() {
		return label;
	}
	
    protected static TextAnchor getTextAnchor(TextBlockAnchor anchor)
    {
    	if (anchor == TextBlockAnchor.BOTTOM_CENTER)
    		return TextAnchor.BOTTOM_CENTER;
    	else if (anchor == TextBlockAnchor.BOTTOM_LEFT)
    		return TextAnchor.BOTTOM_LEFT;
    	else if (anchor == TextBlockAnchor.BOTTOM_RIGHT)
    		return TextAnchor.BOTTOM_RIGHT;
    	else if (anchor == TextBlockAnchor.CENTER)
    		return TextAnchor.CENTER;
    	else if (anchor == TextBlockAnchor.CENTER_LEFT)
    		return TextAnchor.CENTER_LEFT;
    	else if (anchor == TextBlockAnchor.CENTER_RIGHT)
    		return TextAnchor.CENTER_RIGHT;
    	else if (anchor == TextBlockAnchor.TOP_CENTER)
    		return TextAnchor.TOP_CENTER;
    	else if (anchor == TextBlockAnchor.TOP_LEFT)
    		return TextAnchor.TOP_LEFT;
    	else if (anchor == TextBlockAnchor.TOP_RIGHT)
    		return TextAnchor.TOP_RIGHT;
    	return TextAnchor.BASELINE_CENTER;
    }

}
